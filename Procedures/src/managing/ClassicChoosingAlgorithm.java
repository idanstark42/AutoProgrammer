package managing;

import procedures.CRUD.Create;
import procedures.CRUD.Delete;
import procedures.CRUD.Update;
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


        //Creating missing objects
        for(InstanceState object : begining.operations.missingObjects(ending)){
            Procedure creation = new Create(object.instance);

            currentSituation = creation.act(currentSituation);
            result.procedures.add(creation);
        }


        //Updating necessary updates
        Update[] necessaryUpdates = currentSituation.operations.necessaryUpdates(ending);
        //TODO finish updating algorithm.

        //Deleting extra objects
        Situation postUpdatesSituation = currentSituation;
        for(InstanceState object : ending.operations.missingObjects(postUpdatesSituation)){
            Procedure deletion = new Delete(object.instance.name);

            currentSituation = deletion.act(currentSituation);
            result.procedures.add(deletion);
        }

        return result;
    }
}
