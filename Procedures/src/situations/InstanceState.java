package situations;

import exceptions.ObjectNotFoundException;

import java.util.ArrayList;

/**
 * Created by Idan Stark on 23/04/16.
 */
public class InstanceState {

    public Instance instance;

    public ArrayList<InstanceMark> state;

    public InstanceState(){
        this.instance = new Instance();
        state = new ArrayList<InstanceMark>();
    }

    public InstanceState(InstanceState object) {
        this();
        this.instance = new Instance(object.instance);
        for(InstanceMark mark : object.state){
            this.state.add(mark);
        }
    }

    public boolean is(String markName) {
        for(InstanceMark mark : state){
            if(mark.name.equals(markName)){
                return true;
            }
        }
        return false;
    }

    public InstanceMark getMark(String name)
        throws ObjectNotFoundException {
        for(InstanceMark mark : state){
            if(mark.name.startsWith((name + "#"))){
                return mark;
            }
        }
        throw new ObjectNotFoundException();
    }

    public String getMarkValue(String name)
        throws ObjectNotFoundException {
        for(InstanceMark mark : state){
            if(mark.name.startsWith((name + "#"))){
                return mark.name.replace(name + "#", "");
            }
        }
        throw new ObjectNotFoundException();
    }

    public boolean equals(InstanceState object){
        for(InstanceMark mark : state){
            if(!object.is(mark.name)){
                return false;
            }
        }
        return true;
    }
}