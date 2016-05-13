package situations;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Idan Stark on 29/04/16.
 */
public class Instance {

    public Type type;
    public String name;

    public Instance(){

    }

    public Instance(Type type, String name){
        this();
        this.type = type;
        this.name = name;
    }

    public Instance(Instance otherInstance){
        this(otherInstance.type, otherInstance.name);
    }

    public boolean equals(Instance instance){
        return instance != null && this.type == instance.type && this.name == instance.name;
    }

}
