package situations;

import java.lang.reflect.*;

/**
 * Created by Idan Stark on 13/05/16.
 */
public class ObjectFactory {


    public static InstanceState createObject(Instance instance){
        InstanceState result = new InstanceState(instance);
        for(Field field : getFields(instance.type)){
            result.fields.add(new InstanceState(new Instance(field.getType(), field.getName())));
        }

        return result;
    }
    public static InstanceState createObject(Type type, String name){
        return createObject(new Instance(type, name));
    }

    public static InstanceState createArray(Instance instance, int length){
        Type type = new GenericArrayType() {

            private Type genericComponentType;

            @Override
            public Type getGenericComponentType() {
                return genericComponentType;
            }
        };
        InstanceState result = new InstanceState(type, instance.name);

        for(int i = 0; i < length; i++){
            result.fields.add(result);
        }

        InstanceState lengthInstance = new InstanceState(new Instance(Integer.TYPE,"length"));
        lengthInstance.state.add("" + length);
        result.fields.add(lengthInstance);

        return result;
    }
    public static InstanceState createArray(Type type, String name, int length){
        return createArray(new Instance(type,name), length);
    }

    public static InstanceState createEmptyCopy(InstanceState object){
        if(object.instance.type instanceof GenericArrayType){
            Type type = ((GenericArrayType)object.instance.type).getGenericComponentType();
            InstanceState lengthInstance = null;
            for(InstanceState field : object.fields){
                if(field.instance.name.equals("length")){
                    lengthInstance = field;
                    break;
                }
            }
            if(lengthInstance == null) return null;//throw exception
            int length = Integer.parseInt(lengthInstance.state.get(0));
            return createArray(type, object.instance.name, length);
        }else{
            return createObject(new Instance(object.instance));
        }
    }

    private static Field[] getFields(Type type){
        if(type instanceof Class){
            return ((Class)type).getFields();
        }
        if(type instanceof ParameterizedType){
            return getFields(((ParameterizedType) type).getRawType());
        }
        if(type instanceof TypeVariable || type instanceof WildcardType){
            return new Field[0];
        }
        return null;
    }

}
