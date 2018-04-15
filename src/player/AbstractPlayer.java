package player;

import map.Property;
import player.behavior.PlayBehavior;
import utils.DecisionData;
import utils.GameConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e11even on 13/04/18.
 */
public abstract class AbstractPlayer {

    private static int globalId = 0;

    private PlayBehavior playBehavior;

    private int id;
    private int position;
    private int coins;
    private List<Property> properties;

    public AbstractPlayer(PlayBehavior playBehavior) {
        this.id = globalId++;
        init();
        setPlayBehavior(playBehavior);
    }

    public void init() {
        position = GameConstants.DEFAULT_POSITION;
        coins = GameConstants.DEFAULT_COINS;
        properties = new ArrayList<>();
    }

    /*
    Returns true if the player will buy the place
    Returns false otherwise

    Pre-Conditions: Player has enough coins to buy
    */
    public boolean decision(DecisionData decisionData) {
        decisionData.setCoins(coins);
        return playBehavior.decide(decisionData);
    }

    public void addProperty(Property property) {
        properties.add(property);
    }
//
//    // Receives the number o moves and updates its position
//    public void move(int numberOfMoves) {
//        position += numberOfMoves;
//    }

    public void setPlayBehavior(PlayBehavior playBehavior) {
        this.playBehavior = playBehavior;
    }

    public int getPlayerId() {
        return id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void addCoins(int value) {
        coins += value;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public static void resetId() {
        globalId = 0;
    }

    @Override
    public String toString() {
        StringBuffer log = new StringBuffer();
        log.append(String.format("Player %d: coins: %d, position: %d\n", id, coins, position));
        for (int i = 0; i < properties.size(); i++) {
            log.append("\t" + properties.get(i) + "\n");
        }
        return log.toString();
    }
}
