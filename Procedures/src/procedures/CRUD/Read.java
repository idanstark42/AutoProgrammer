package procedures.CRUD;

import procedures.Procedure;
import situations.Instance;
import situations.InstanceState;
import situations.Situation;

import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * Created by Idan Stark on 13/05/16.
 */
public class Read extends Procedure{

    private String objectName;

    public Situation act(Situation initialSituation){
        return initialSituation.operations.subSituation(names(initialSituation));
    }

    private String[] names(Situation situation){
        ArrayList<String> names = new ArrayList<String>();
        for(InstanceState field : situation.get(objectName).fields){
            names.add(field.instance.name);
        }
        return names.toArray(new String[names.size()]);
    }


}
