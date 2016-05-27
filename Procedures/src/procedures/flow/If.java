package procedures.flow;

import procedures.Procedure;
import situations.Situation;

/**
 * Created by Idan Stark on 13/05/16.
 */
public class If extends Procedure{

    private Procedure onTruth;
    private Procedure onFalse;

    private String conditionObjectName;

    @Override
    public Situation act(Situation initialSituation) {
        if(initialSituation.get(conditionObjectName).isMarkedAs("true")){
            return onTruth.act(initialSituation);
        }else{
            return onFalse.act(initialSituation);
        }
    }
}
