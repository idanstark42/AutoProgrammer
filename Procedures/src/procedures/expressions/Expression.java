package procedures.expressions;

import procedures.Procedure;
import situations.Situation;

/**
 * Created by Idan Stark on 23/04/16.
 */
public abstract class Expression<T> implements Procedure {

    public T get(Situation initialSituation){
        Situation sit = act(initialSituation);

        return (T) sit.objects.get(0).instance;
    }

}
