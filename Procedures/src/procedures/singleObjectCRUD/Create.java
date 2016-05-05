package procedures.singleObjectCRUD;

import procedures.Procedure;
import situations.InstanceState;
import situations.Situation;

/**
 * Created by Idan Stark on 05/05/16.
 */
public class Create<T> implements Procedure{

    private java.lang.reflect.Type type;
    private String name;

    @Override
    public Situation act(Situation initialSituation) {
        InstanceState objectState = new InstanceState();
        objectState.instance.type = this.type;
        objectState.instance.name = this.name;
        initialSituation.objects.add(objectState);
        return initialSituation;
    }
}
