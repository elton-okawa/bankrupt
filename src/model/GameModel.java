package model;

import map.Map;
import map.Property;
import player.AbstractPlayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e11even on 13/04/18.
 */
public class GameModel {

    private Map map = new Map();
    private List<AbstractPlayer> abstractPlayerList;

    public GameModel() {
        init();
    }

    public void init() {
        map.init();
        AbstractPlayer.resetId();
        abstractPlayerList = new ArrayList<>();
    }

    public void addPlayer(AbstractPlayer abstractPlayer) {
        abstractPlayerList.add(abstractPlayer);
    }

    public AbstractPlayer getPlayerAt(int index) {
        return abstractPlayerList.get(index);
    }

    public int getNumberOfPlayers() {
        return abstractPlayerList.size();
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
