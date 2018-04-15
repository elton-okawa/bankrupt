package player.factory;

import player.AbstractPlayer;
import player.behavior.DemandingBehavior;
import player.behavior.PlayBehavior;

/**
 * Created by Elton on 15/04/2018.
 */
public class DemandingPlayerFactory implements PlayerFactory{

    @Override
    public AbstractPlayer createPlayer() {
        return new Player(new DemandingBehavior());
    }
}
