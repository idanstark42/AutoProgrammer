package procedures.CRUD;

import procedures.Procedure;
import situations.Instance;
import situations.InstanceState;
import situations.ObjectFactory;
import situations.Situation;

/**
 * Created by Idan Stark on 13/05/16.
 */
public class Create extends Procedure{

    public Instance object;

    public Create(Instance object){
        this.object = object;
    }

    @Override
    public Situation act(Situation initialSituation) {
        initialSituation.add(ObjectFactory.createObject(object));
        return initialSituation;
    }
}
