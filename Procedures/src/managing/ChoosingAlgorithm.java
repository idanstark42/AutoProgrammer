package managing;

import procedures.Procedure;
import situations.Situation;

/**
 * Created by Idan Stark on 14/05/16.
 */
public interface ChoosingAlgorithm{

    Procedure choose(Situation begining, Situation ending);

}
