package situations;

import java.util.ArrayList;

/**
 * Created by Idan Stark on 07/05/16.
 */
public class SituationMath {


    public static Iterable<InstanceState> objectsSubstraction(Situation sit1, Situation sit2) {
        ArrayList<InstanceState> result = new ArrayList<InstanceState>();
        for(InstanceState object : sit1.objects){
            if(!sit2.objects.contains(object)){
                result.add(object);
            }
        }
        return result;
    }
}
