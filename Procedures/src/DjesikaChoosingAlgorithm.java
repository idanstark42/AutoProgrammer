import procedures.Procedure;
import procedures.SequenceProcedure;
import procedures.singleObjectCRUD.Create;
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

        for(InstanceState object : SituationMath.objectsSubstraction(end, begin)){
            Create create = new Create(new Instance(object.instance));
            result.sequence.add(create);
        }

        //TODO add updates

        return result;
    }

}
