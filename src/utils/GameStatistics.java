package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by e11even on 14/04/18.
 */
public class GameStatistics {

    private int numberOfGames = 0;
    private int timeOutGames = 0;
    private int totalRounds = 0;
    // Wins: impulsive, demanding, cautious, random
    private List<Integer> behaviorWins = new ArrayList<>(Arrays.asList(0,0,0,0));

    public void addNumberOfGames(int numberOfGames) {
        this.numberOfGames += numberOfGames;
    }

    public void addTimeOutGames(int timeOutGames) {
        this.timeOutGames += timeOutGames;
    }

    public void addTotalRounds(int totalRounds) {
        this.totalRounds += totalRounds;
    }

    public void addBehaviorWins(PlayerType winner) {
        int wins = behaviorWins.get(winner.getType());
        behaviorWins.set(winner.getType(), wins + 1);
    }

    public double getMeanRounds() {
        return (double) totalRounds / numberOfGames;
    }

    public List<Double> getVictoryPercentByBehavior() {
        List<Double> victoryPercent = new ArrayList<>();
        for (int i = 0; i < behaviorWins.size(); i++) {
            victoryPercent.add((double) behaviorWins.get(i) / numberOfGames * 100.0);
        }
        return victoryPercent;
    }

    public PlayerType getTheMostWinner() {
        int mostWinner = 0;
        for (int i = 1; i < behaviorWins.size(); i++) {
            if (behaviorWins.get(mostWinner) < behaviorWins.get(i)) {
                mostWinner = i;
            }
        }
        return PlayerType.getPlayerByType(mostWinner);
    }

    public int getTimeOutGames() {
        return timeOutGames;
    }

    @Override
    public String toString() {
        StringBuffer bf = new StringBuffer();
        bf.append(String.format("Número de partidas finalizada por TIMEOUT: %d\n", getTimeOutGames()));
        bf.append(String.format("Número de turnos médio por partida: %.2f\n", getMeanRounds()));

        List<Double> victoryPercentByBehavior = getVictoryPercentByBehavior();
        bf.append(String.format("Porcentagem de vitória IMPULSIVO: \t%.2f%%\n", victoryPercentByBehavior.get(0)));
        bf.append(String.format("Porcentagem de vitória EXIGENTE: \t%.2f%%\n", victoryPercentByBehavior.get(1)));
        bf.append(String.format("Porcentagem de vitória CAUTELOSO: \t%.2f%%\n", victoryPercentByBehavior.get(2)));
        bf.append(String.format("Porcentagem de vitória ALEATÓRIO: \t%.2f%%\n", victoryPercentByBehavior.get(3)));

        bf.append(String.format("Comportamento mais vitorioso: %s", getTheMostWinner().getTypeString()));

        return bf.toString();
    }
}
