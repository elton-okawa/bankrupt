package player.behavior;

import utils.DecisionData;
import utils.SingletonRandom;

/**
 * Created by Elton on 14/04/2018.
 */
public class RandomBehavior implements PlayBehavior {
    @Override
    public boolean decide(DecisionData decisionData) {
        return SingletonRandom.getInstance().nextInt(0, 2) == 0;
    }
}
