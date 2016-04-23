package procedures.conditional_procedures;

import procedures.Procedure;
import procedures.expressions.Expression;
import situations.Situation;

/**
 * Created by Idan Stark on 23/04/16.
 */
public class While implements Procedure{

    public Procedure procedure;
    public Expression<Boolean> condition;

    @Override
    public Situation act(Situation initialSituation) {
        Situation sit = initialSituation;
        while(condition.get(sit)){
            sit = procedure.act(sit);
        }
        return sit;
    }
}
