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

    public String objectName;

    public Situation act(Situation initialSituation){
        return initialSituation.operations.subSituation(names(initialSituation));
    }

    private String[] names(Situation situation){
        ArrayList<String> names = new ArrayList<String>();
        situation.get(objectName).fields.forEach(f -> names.add(f.instance.name));
        return names.toArray(new String[names.size()]);
    }


}
