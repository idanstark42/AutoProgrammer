package managing;

import procedures.Procedure;

import java.util.Iterator;

/**
 * Created by Idan Stark on 14/05/16.
 */
public interface ProceduresDB {

    Iterator<Procedure> procedures();

}
