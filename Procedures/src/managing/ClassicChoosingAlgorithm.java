package managing;

import procedures.CRUD.Create;
import procedures.Procedure;
import procedures.SequenceProcedure;
import situations.InstanceState;
import situations.Situation;

/**
 * Created by Idan Stark on 14/05/16.
 */
public class ClassicChoosingAlgorithm implements ChoosingAlgorithm{

    private ProceduresDB db;

    @Override
    public Procedure choose(Situation begining, Situation ending) {
        SequenceProcedure result = new SequenceProcedure();
        Situation currentSituation = begining;

        for(InstanceState object : begining.operations.missingObjects(ending)){
            Procedure creation = new Create(object.instance);

            currentSituation = creation.act(currentSituation);
            result.procedures.add(creation);
        }
        //TODO build updating algorithm.

        return result;
    }
}
