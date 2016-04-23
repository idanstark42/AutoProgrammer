package procedures;

import situations.Situation;

/**
 * Created by Idan Stark on 23/04/16.
 */
public interface Procedure {

    Situation act(Situation initialSituation);

}
