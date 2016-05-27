package situations;

import procedures.CRUD.Update;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Idan Stark on 13/05/16.
 */
public class Operations{

    private Situation situation;
    public Operations(Situation situation){
        this.situation = situation;
    }

    public Situation subSituation(String... names){
        Situation result = new Situation();
        for(String name : names){
            result.add(situation.get(name));
        }
        return result;
    }

    public void join(Situation situation) {
        for(InstanceState object : situation.objects){
            situation.remove(situation.get(object.instance.name));
            situation.add(object);
        }
    }

    public Iterable<InstanceState> missingObjects(Situation situation){
        ArrayList<InstanceState> result = new ArrayList<InstanceState>();
        for(InstanceState object : situation.objects){
            if(this.situation.get(object.instance.name) == null){
                result.add(ObjectFactory.createEmptyCopy(object));
            }
        }
        return result;
    }

    public Update[] necessaryUpdates(Situation goal){
        ArrayList<Update> updates = new ArrayList<>();
        for(InstanceState object : this.situation.objects){
            InstanceState goalObject = goal.get(object.instance.name);
            if(goalObject != null){
                for(String existingMark : object.state){
                    if(!goalObject.isMarkedAs(existingMark)){
                        updates.add(new Update(object.instance.name, existingMark, Update.Action.Delete));
                    }
                }
                for(String missingMark : goalObject.state){
                    if(!object.isMarkedAs(missingMark)){
                        updates.add(new Update(object.instance.name, missingMark, Update.Action.Add));
                    }
                }
            }
        }
        return updates.toArray(new Update[updates.size()]);
    }

}