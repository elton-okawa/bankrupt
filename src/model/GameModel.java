package model;

import map.Map;
import map.Property;
import player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e11even on 13/04/18.
 */
public class GameModel {

    private Map map = new Map();
    private List<Player> playerList;

    public GameModel() {
        init();
    }

    public void init() {
        map.init();
        playerList = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        playerList.add(player);
    }

    public Player getPlayerAt(int index) {
        return playerList.get(index);
    }

    public int getNumberOfPlayers() {
        return playerList.size();
    }

    public int getMapSize() {
        return map.getSize();
    }

    public void addProperty(Property property) {
        map.addProperty(property);
    }

    public Property getPropertyAt(int index) {
        return map.getPropertyAt(index);
    }

}
