package exceptions;

/**
 * Created by Idan Stark on 29/04/16.
 */
public class ObjectNotFoundException extends NullPointerException {

    public ObjectNotFoundException(){
        super("Object doesn't exist in current situation");
    }

}
