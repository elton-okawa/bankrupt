package player.behavior;

import utils.DecisionData;

/**
 * Created by e11even on 13/04/18.
 */
public class ImpulsiveBehavior implements PlayBehavior {
    @Override
    public boolean decide(DecisionData decisionData) {
        return true;
    }
}
