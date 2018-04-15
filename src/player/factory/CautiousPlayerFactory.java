package player.factory;

import player.AbstractPlayer;
import player.behavior.CautiousBehavior;

/**
 * Created by Elton on 15/04/2018.
 */
public class CautiousPlayerFactory implements PlayerFactory {
    @Override
    public AbstractPlayer createPlayer() {
        return new Player(new CautiousBehavior());
    }
}
