package player.behavior;

import utils.DecisionData;

/**
 * Created by Elton on 14/04/2018.
 */
public class DemandingBehavior implements PlayBehavior {
    @Override
    public boolean decide(DecisionData decisionData) {
        return decisionData.getRent() > 50;
    }
}
