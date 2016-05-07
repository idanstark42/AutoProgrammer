package procedures.singleObjectCRUD;

import procedures.Procedure;
import situations.Instance;
import situations.InstanceState;
import situations.Situation;

import java.lang.reflect.Type;

/**
 * Created by Idan Stark on 05/05/16.
 */
public class Create implements Procedure{

    private Instance instance;

    public Create(Type type, String name){
        this.instance = new Instance();
        this.instance.name = name;
        this.instance.type = type;
    }

    public Create(Instance instance){
        this.instance = instance;
    }

    @Override
    public Situation act(Situation initialSituation) {
        InstanceState objectState = new InstanceState();
        objectState.instance = this.instance;
        initialSituation.objects.add(objectState);
        return initialSituation;
    }
}
