package procedures.flow;

import procedures.Procedure;
import situations.Situation;

/**
 * Created by Idan Stark on 13/05/16.
 */
public class If extends Procedure{

    public Procedure onTruth;
    public Procedure onFalse;

    public String conditionObjectName;

    @Override
    public Situation act(Situation initialSituation) {
        if(initialSituation.get(conditionObjectName).isMarkedAs("true")){
            return onTruth.act(initialSituation);
        }else{
            return onFalse.act(initialSituation);
        }
    }
}
