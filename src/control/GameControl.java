package control;

import map.Property;
import model.GameModel;
import player.factory.*;
import player.AbstractPlayer;
import utils.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by e11even on 13/04/18.
 */
public class GameControl {

    private GameModel gameModel = new GameModel();
    private GameStatistics gameStatistics = new GameStatistics();
    private List<PlayerFactory> playerFactories = new ArrayList<>(Arrays.asList(
            new ImpulsivePlayerFactory(),
            new DemandingPlayerFactory(),
            new CautiousPlayerFactory(),
            new RandomPlayerFactory()
    ));

    public GameControl(String configName) throws IOException {
        init(configName);
    }

    public void init(String configName) throws IOException {
        gameModel.init();
        BufferedReader bf = Files.newBufferedReader(Paths.get(configName));
        String line;
        String[] arguments;
        while ((line = bf.readLine()) != null) {
            arguments = line.split("\\s+");
            gameModel.addProperty(new Property(Integer.valueOf(arguments[0]), Integer.valueOf(arguments[1])));
        }

        for (int i = 0; i < playerFactories.size(); i++) {
            gameModel.addPlayer(playerFactories.get(i).createPlayer());
        }
    }

    public void startGame() {
        int moves = 0;
        int round = 0;
        boolean finished = false;
        DecisionData decisionData = new DecisionData();
        AbstractPlayer player;
        Property property;
        while (round < GameConstants.MAX_NUMBER_OF_ROUNDS && !finished) {
            Iterator<AbstractPlayer> playerIterator = gameModel.getPlayerIterator();
            while (playerIterator.hasNext()){
                player = playerIterator.next();
                if (player.getCoins() >= 0) { //The player is still in the game
                    moves = SingletonRandom.getInstance().nextInt(GameConstants.MIN_MOVES, GameConstants.MAX_MOVES + 1);
                    int position = player.getPosition();
                    int newPosition = player.getPosition() + moves;

                    if (newPosition > gameModel.getMapSize()) { // Player's completed a round +100 coins
                        player.addCoins(GameConstants.COINS_ROUND_MAP);
                    }
                    player.setPosition((moves + position) % gameModel.getMapSize()); //Makes a circle map

                    property = gameModel.getPropertyAt(player.getPosition());
                    if (property.hasOwner()) {
                        int rent = property.getRent();
                        player.addCoins(-rent); // Subtract rent
                        gameModel.getPlayerById(property.getOwnerId()).addCoins(rent);

                        checkPlayerBankruptcy(player);
                    } else {
                        decisionData.setPrice(property.getPrice());
                        decisionData.setRent(property.getRent());

                        if (player.getCoins() >= property.getPrice() && player.decision(decisionData)) {
                            property.setOwnerId(player.getPlayerId());
                            player.addProperty(property);
                            player.addCoins(-(property.getPrice()));
                        }
                    }
                }
            }

            if (GameConstants.LOG_CONFIG) {
                if (round % 10 == 0) {
                    System.out.println(String.format("Round: %d", round));
                    Iterator<AbstractPlayer> iterator = gameModel.getPlayerIterator();
                    while(iterator.hasNext()) {
                        System.out.println(iterator.next());
                    }
                }
            }

            finished = (gameModel.getPlayersPlaying() <= 1);
            round++;
        }

        gameStatistics.addNumberOfGames(1);
        gameStatistics.addTotalRounds(round);
        if (round == GameConstants.MAX_NUMBER_OF_ROUNDS) {
            gameStatistics.addTimeOutGames(1);
        }
        gameStatistics.addBehaviorWins(PlayerType.getPlayerByType(getWinnerIndex()));
    }

    private void checkPlayerBankruptcy(AbstractPlayer abstractPlayer) {
        if (abstractPlayer.getCoins() < 0) {
            gameModel.addPlayersPlaying(-1);
            List<Property> properties = abstractPlayer.getProperties();
            for (int i = 0; i < properties.size(); i++) {
                properties.get(i).setOwnerId(GameConstants.NO_OWNER);
            }
            properties.removeAll(properties);
        }
    }

    private int getWinnerIndex() {
        int winner = 0;
        int position = 1;
        Iterator<AbstractPlayer> playerIterator = gameModel.getPlayerIterator();
        AbstractPlayer player = playerIterator.next();
        AbstractPlayer another;
        while (playerIterator.hasNext()) {
            another = playerIterator.next();
            if (another.getCoins() > player.getCoins()) {
                winner = position;
                player = another;
            }
            position++;
        }
        return winner;
    }

    @Override
    public String toString() {
        return gameStatistics.toString();
    }

}
