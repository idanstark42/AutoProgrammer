package procedures.singleObjectCRUD;

import procedures.Procedure;
import situations.InstanceMark;
import situations.InstanceState;
import situations.Situation;

import java.util.ArrayList;

/**
 * Created by Idan Stark on 05/05/16.
 */
public class Update implements Procedure{

    public String objectName;
    public ArrayList<InstanceMark> newState;

    public Update(){
        newState = new ArrayList<InstanceMark>();
    }

    public Update(String objectName){
        this.objectName = objectName;
    }

    @Override
    public Situation act(Situation initialSituation) {
        InstanceState object = initialSituation.getObject(objectName);
        object.state = newState;
        return initialSituation;
    }
}
