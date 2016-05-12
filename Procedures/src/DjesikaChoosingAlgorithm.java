import procedures.Procedure;
import procedures.SequenceProcedure;
import procedures.singleObjectCRUD.Create;
import procedures.singleObjectCRUD.Update;
import situations.Instance;
import situations.InstanceState;
import situations.Situation;
import situations.SituationMath;

/**
 * Created by Idan Stark on 30/04/16.
 */
public class DjesikaChoosingAlgorithm implements ChoosingAlgorithm{

    public Iterable<Procedure> possibleUpdates;

    public DjesikaChoosingAlgorithm(Iterable<Procedure> possibleUpdates){
        this.possibleUpdates = possibleUpdates;
    }

    public Procedure choose(Situation begin, Situation end){
        SequenceProcedure result = new SequenceProcedure();
        Situation currentSituation = new Situation(begin);

        for(InstanceState object : SituationMath.objectsSubstraction(end, begin)){
            Create create = new Create(new Instance(object.instance));
            currentSituation = create.act(currentSituation);
            result.sequence.add(create);
        }

        Iterable<Update> updates = SituationMath.marksSubstraction(end, currentSituation);
        for(Update currentUpdate : updates){
            Procedure chosenProcedureForCurrentUpdate = chooseProcedure(currentUpdate);
            currentSituation = chosenProcedureForCurrentUpdate.act(currentSituation);
            result.sequence.add(chosenProcedureForCurrentUpdate);
        }

        return result;
    }

    public Procedure chooseProcedure(Update update){
        for(Procedure procedure : possibleUpdates){
            if(procedureFitsToUpdate(procedure, update)){
                return procedure;
            }
        }
        return null;
    }

    public boolean procedureFitsToUpdate(Procedure procedure, Update update){
        Situation initialSituation = update.getNesseceryInitialSituation();

        Situation procedureFinalSituation = procedure.act(initialSituation);
        Situation updateFinalSituation = update.act(initialSituation);
        return procedureFinalSituation.equals(updateFinalSituation);
    }

}
