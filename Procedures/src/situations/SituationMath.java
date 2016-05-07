package situations;

import exceptions.ObjectNotFoundException;
import procedures.singleObjectCRUD.Update;

import java.util.ArrayList;

/**
 * Created by Idan Stark on 07/05/16.
 */
public class SituationMath {


    public static Iterable<InstanceState> objectsSubstraction(Situation sit1, Situation sit2) {
        ArrayList<InstanceState> result = new ArrayList<InstanceState>();
        for(InstanceState object : sit1.objects){
            if(!sit2.containsObjectByName(object.instance.name)){
                result.add(object);
            }
        }
        return result;
    }

    public static Iterable<Update> marksSubstraction(Situation sit1, Situation sit2)
        throws ObjectNotFoundException{
        ArrayList<Update> result = new ArrayList<Update>();
        for(InstanceState object : sit1.objects){
            if(sit2.containsObjectByName(object.instance.name)){
                Update update = new Update(object.instance.name);
                update.newState = sit2.getObject(object.instance.name).state;
                result.add(update);
            }else{
                throw new ObjectNotFoundException();
            }
        }
        return result;
    }
}
