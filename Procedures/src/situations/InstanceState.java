package situations;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Idan Stark on 23/04/16.
 */
public class InstanceState {

    public final Instance instance;

    public ArrayList<String> state;

    public InstanceState(Instance instance){
        this.instance = instance;
        this.state = new ArrayList<String>();
    }

    public InstanceState(Type type, String name){
        this(new Instance(type, name));
    }

    public boolean isMarkedAs(String testedMark) {
        for(String myMark : state){
            if(myMark.equals(testedMark)){
                return true;
            }
        }
        return false;
    }

    public boolean equals(InstanceState instanceState){
        if(instanceState == null) return false;
        for(String mark : state){
            if(!instanceState.isMarkedAs(mark)) return false;
        }
        return instanceState.equals(instanceState.instance);
    }

}