import procedures.Procedure;
import situations.Situation;

/**
 * Created by Idan Stark on 30/04/16.
 */
public interface ChoosingAlgorithm {

    Procedure choose(Situation begin, Situation end);

}
