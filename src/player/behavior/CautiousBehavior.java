package player.behavior;

import utils.DecisionData;

/**
 * Created by Elton on 14/04/2018.
 */
public class CautiousBehavior implements PlayBehavior {
    @Override
    public boolean decide(DecisionData decisionData) {
        return (decisionData.getCoins() - decisionData.getPrice()) > 80;
    }
}
