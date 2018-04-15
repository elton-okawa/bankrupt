package player.factory;

import player.AbstractPlayer;
import player.behavior.RandomBehavior;

/**
 * Created by Elton on 15/04/2018.
 */
public class RandomPlayerFactory implements PlayerFactory {
    @Override
    public AbstractPlayer createPlayer() {
        return new Player(new RandomBehavior());
    }
}
