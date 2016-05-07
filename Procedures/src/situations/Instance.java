package situations;

/**
 * Created by Idan Stark on 29/04/16.
 */
public class Instance {

    public java.lang.reflect.Type type;

    public String name;

    public Instance(){}

    public Instance(Instance instance) {
        this.name = instance.name;
        this.type = instance.type;
    }

    public boolean equals(Instance instance){
        return this.name == instance.name && this.type == instance.type;
    }

}
