package procedures.expressions;

import procedures.Procedure;
import situations.InstanceState;
import situations.Situation;

/**
 * Created by Idan Stark on 23/04/16.
 */
public abstract class Expression implements Procedure {

    public InstanceState get(Situation initialSituation){
        Situation sit = act(initialSituation);

        return sit.getObject("result");
    }

}
