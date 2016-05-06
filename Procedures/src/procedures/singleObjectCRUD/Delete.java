package procedures.singleObjectCRUD;

import procedures.Procedure;
import situations.InstanceState;
import situations.Situation;

/**
 * Created by Idan Stark on 05/05/16.
 */
public class Delete implements Procedure {

    private String name;

    @Override
    public Situation act(Situation initialSituation) {
        InstanceState object = initialSituation.getObject(name);
        initialSituation.objects.remove(object);
        return initialSituation;
    }
}
