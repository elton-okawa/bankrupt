package player.factory;

import player.AbstractPlayer;
import player.behavior.PlayBehavior;

/**
 * Created by e11even on 14/04/18.
 */
public class Player extends AbstractPlayer {

    public Player(PlayBehavior playBehavior) {
        super(playBehavior);
    }
}
