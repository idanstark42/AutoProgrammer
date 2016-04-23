package procedures.conditional_procedures;

import procedures.Procedure;
import procedures.expressions.Expression;
import situations.Situation;

/**
 * Created by Idan Stark on 23/04/16.
 */
public class BasicCondition implements Procedure{

    public Procedure onTrue;
    public Procedure onFalse;
    public Expression<Boolean> condition;

    @Override
    public Situation act(Situation initialSituation) {
        if(condition.get(initialSituation)){
            return onTrue.act(initialSituation);
        }
        return onFalse.act(initialSituation);
    }
}
