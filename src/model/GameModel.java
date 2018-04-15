package model;

import map.Map;
import map.Property;
import player.AbstractPlayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by e11even on 13/04/18.
 */
public class GameModel {

    private Map map = new Map();
//    private List<AbstractPlayer> abstractPlayerList;
    private java.util.Map<Integer, AbstractPlayer> abstractPlayerMap;
    private int playersPlaying;

    public GameModel() {
        init();
    }

    public void init() {
        map.init();
//        AbstractPlayer.resetId();
        abstractPlayerMap = new HashMap<>();
        playersPlaying = 0;
    }

    public void addPlayer(AbstractPlayer abstractPlayer) {
        abstractPlayerMap.put(abstractPlayer.getPlayerId(), abstractPlayer);
        addPlayersPlaying(1);
    }

    public Iterator<AbstractPlayer> getPlayerIterator() {
        return abstractPlayerMap.values().iterator();
    }

    public AbstractPlayer getPlayerById(int playerId) {
        return abstractPlayerMap.get(playerId);
    }

    public int getPlayersPlaying() {
        return playersPlaying;
    }

    public void addPlayersPlaying(int value) {
        playersPlaying += value;
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
