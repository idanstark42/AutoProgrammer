package situations;

import exceptions.ObjectNotFoundException;

import java.util.ArrayList;

/**
 * Created by Idan Stark on 23/04/16.
 */
public class Situation {

    public ArrayList<InstanceState> objects;

    public Situation(){
        objects = new ArrayList<InstanceState>();
    }

    public Situation(Situation otherSituation) {
        this();
        for(InstanceState object : otherSituation.objects){
            objects.add(new InstanceState(object));
        }
    }

    public Situation subSituation(String... names){
        Situation result = new Situation();
        for(String name : names){
            result.objects.add(getObject(name));
        }
        return result;
    }

    public InstanceState getObject(String name){
        for(InstanceState object : objects){
            if(object.instance.name.equals((name))){
                return object;
            }
        }
        throw new ObjectNotFoundException();
    }

    public void join(Situation situation) {
        for(InstanceState object : situation.objects){
            try {
                objects.remove(getObject(object.instance.name));
            }catch(ObjectNotFoundException e){

            }
            objects.add(object);
        }
    }
}
