package procedures.singleObjectCRUD;

import exceptions.ObjectNotFoundException;
import procedures.Procedure;
import situations.Instance;
import situations.InstanceMark;
import situations.InstanceState;
import situations.Situation;

import java.lang.reflect.*;

/**
 * Created by Idan Stark on 05/05/16.
 */
public class Read implements Procedure{

    private String name;

    private boolean copyAllOtherObjects;

    @Override
    public Situation act(Situation initialSituation)
        throws ObjectNotFoundException{
        Situation result;
        if(copyAllOtherObjects){
            result = new Situation(initialSituation);
        }else{
            result = new Situation();
        }
        InstanceState object = initialSituation.getObject(name);
        result.objects.remove(object);
        for(Instance field : getFieldsForType(object)){
            InstanceState fieldObject = new InstanceState();
            fieldObject.instance = field;
            fieldObject.state.add(getInstacneMarkForField(object, field.name));
            result.objects.add(fieldObject);
        }
        return result;
    }

    private Instance[] getFieldsForType(InstanceState object){
        Type t = object.instance.type;
        while(t instanceof ParameterizedType){
            t = ((ParameterizedType)t).getRawType();
        }
        if(t instanceof Class){
            return getFieldsForClass((Class)t);
        }
        if(t instanceof GenericArrayType){
            return getItemsForArray(((GenericArrayType)t).getGenericComponentType(), object);
        }
        if(t instanceof WildcardType && t instanceof TypeVariable){
            return new Instance[]{};
        }
        throw new TypeNotPresentException(t.getTypeName(), new Exception("Couldn't find the correct class"));
    }

    private Instance[] getFieldsForClass(Class c){
        Field[] fields = c.getFields();
        Instance[] instances = new Instance[fields.length];
        for(int i = 0; i < instances.length; i++){
            instances[i] = new Instance();
            instances[i].name = fields[i].getName();
            instances[i].type = fields[i].getType();
        }
        return instances;
    }

    private Instance[] getItemsForArray(Type innerType, InstanceState object){
        int length = Integer.parseInt(object.getMarkValue("length"));
        Instance[] items = new Instance[length];
        for(int i = 0; i < length; i++){
            items[i] = new Instance();
            items[i].name = "item" + i;
            items[i].type = innerType;
        }
        return items;
    }

    private InstanceMark getInstacneMarkForField(InstanceState object, String name) {
        String markValue = object.getMarkValue(name);
        return new InstanceMark(markValue);
    }
}
