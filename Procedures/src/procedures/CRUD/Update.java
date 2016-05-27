package procedures.CRUD;

import procedures.Procedure;
import situations.InstanceState;
import situations.Situation;

/**
 * Created by Idan Stark on 13/05/16.
 */
public class Update extends Procedure{

    public enum Action{Delete, Add}

    public String objectName;
    public Action action;

    public String mark;

    public Update(String objectName, String mark, Update.Action action){
        this.objectName = objectName;
        this.mark = mark;
        this.action = action;
    }

    @Override
    public Situation act(Situation initialSituation) {
        InstanceState object = initialSituation.get(objectName);
        if(object == null) return initialSituation;
        if(action == Action.Delete){
            object.state.remove(mark);
        }else{
            object.state.add(mark);
        }
        return initialSituation;
    }

}
