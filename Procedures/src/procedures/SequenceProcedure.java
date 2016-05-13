package procedures;

import situations.Situation;

import java.util.ArrayList;

/**
 * Created by Idan Stark on 13/05/16.
 */
public class SequenceProcedure extends Procedure{

    public ArrayList<Procedure> procedures;

    public SequenceProcedure(){
        procedures = new ArrayList<Procedure>();
    }

    @Override
    public Situation act(Situation initialSituation) {
        Situation currentSituation = initialSituation;
        for(Procedure currentProcedure : procedures){
            currentSituation = currentProcedure.act(currentSituation);
        }
        return currentSituation;
    }
}
