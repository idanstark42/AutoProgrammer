package situations;

import java.util.ArrayList;

/**
 * Created by Idan Stark on 23/04/16.
 */
public class Situation {

    public ArrayList<InstanceState> objects;
    public Operations operations;

    public Situation(){
        objects = new ArrayList<InstanceState>();
        operations = new Operations(this);
    }

    public InstanceState get(String name){
        for(InstanceState object : objects){
            if(object.instance.name.equals((name))){
                return object;
            }
        }
        return null;
    }

    public boolean equals(Situation situation){
        for(InstanceState object : objects){
            InstanceState otherObject = situation.get(object.instance.name);
            if(!object.equals(otherObject)){
                return false;
            }
        }
        return true;
    }
}
