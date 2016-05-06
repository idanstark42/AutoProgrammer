package procedures.singleObjectCRUD;

import procedures.Procedure;
import situations.InstanceMark;
import situations.InstanceState;
import situations.Situation;

/**
 * Created by Idan Stark on 05/05/16.
 */
public class Update implements Procedure{

    private String objectName;
    private String oldMark;
    private String newMark;


    @Override
    public Situation act(Situation initialSituation) {
        InstanceState object = initialSituation.getObject(objectName);
        object.state.remove(object.getMark(oldMark));
        object.state.add(new InstanceMark(newMark));
        return initialSituation;
    }
}
