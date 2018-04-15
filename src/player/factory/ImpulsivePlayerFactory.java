package player.factory;

import player.AbstractPlayer;
import player.behavior.ImpulsiveBehavior;

/**
 * Created by e11even on 14/04/18.
 */
public class ImpulsivePlayerFactory implements PlayerFactory{
    @Override
    public AbstractPlayer createPlayer() {
        return new Player(new ImpulsiveBehavior());
    }
}
