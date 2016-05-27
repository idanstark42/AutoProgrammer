package procedures.CRUD;

import procedures.Procedure;
import situations.Instance;
import situations.ObjectFactory;
import situations.Situation;

/**
 * Created by Idan Stark on 13/05/16.
 */
public class Delete extends Procedure{

    public String objectName;

    public Delete(String objectName){
        this.objectName = objectName;
    }

    @Override
    public Situation act(Situation initialSituation) {
        initialSituation.remove(objectName);
        return initialSituation;
    }

}
