package situations;

import exceptions.ObjectNotFoundException;

import java.util.ArrayList;

/**
 * Created by Idan Stark on 23/04/16.
 */
public class Situation {

    public ArrayList<InstanceState> objects;

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
}
