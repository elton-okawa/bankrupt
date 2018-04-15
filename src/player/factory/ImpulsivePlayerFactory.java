package player.factory;

import player.Player;
import player.behavior.ImpulsiveBehavior;

/**
 * Created by e11even on 14/04/18.
 */
public class ImpulsivePlayerFactory implements PlayerFactory{
    @Override
    public Player createPlayer() {
        return new ImpulsivePlayer(new ImpulsiveBehavior());
    }
}
