package procedures.flowControlProcedures;

import procedures.Procedure;
import situations.InstanceState;
import situations.Situation;

/**
 * Created by Idan Stark on 30/04/16.
 */
public class IterateAndDo implements Procedure {

    private Procedure action;

    @Override
    public Situation act(Situation initialSituation)
            throws IllegalArgumentException{
        Situation situation = initialSituation;
        for(InstanceState object : initialSituation.objects){
            Situation singulerObjectSituation = new Situation();
            singulerObjectSituation.objects.add(object);

            singulerObjectSituation = act(singulerObjectSituation);

            situation.join(singulerObjectSituation);
        }
        return situation;
    }
}
