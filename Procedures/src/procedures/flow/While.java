package procedures.flow;

import procedures.Procedure;
import situations.Situation;

/**
 * Created by Idan Stark on 13/05/16.
 */
public class While extends Procedure{

    private Procedure procedure;

    private String conditionObjectName;

    @Override
    public Situation act(Situation initialSituation) {
        Situation currentSituation = initialSituation;
        while(initialSituation.get(conditionObjectName).isMarkedAs("true")){
            currentSituation = procedure.act(currentSituation);
        }
        return currentSituation;
    }
}
