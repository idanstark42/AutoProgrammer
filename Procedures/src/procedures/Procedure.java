package procedures;

import situations.Situation;

/**
 * Created by Idan Stark on 13/05/16.
 */
public abstract class Procedure {

    public abstract Situation act(Situation initialSituation);

}
