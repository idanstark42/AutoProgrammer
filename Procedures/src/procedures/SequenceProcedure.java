package procedures;

import situations.Situation;

import java.util.ArrayList;

/**
 * Created by Idan Stark on 23/04/16.
 */
public class SequenceProcedure implements Procedure{

    public ArrayList<Procedure> sequence;

    @Override
    public Situation act(Situation initialSituation) {
        Situation sit = initialSituation;
        for(Procedure procedure : sequence){
            sit = procedure.act(sit);
        }
        return sit;
    }
}
