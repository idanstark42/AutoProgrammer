package situations;

import java.util.ArrayList;

/**
 * Created by Idan Stark on 23/04/16.
 */
public class InstanceState {

    public Instance instance;

    public ArrayList<InstanceMark> state;

    public boolean is(String markName) {
        for(InstanceMark mark : state){
            if(mark.name.equals(markName)){
                return true;
            }
        }
        return false;
    }
}