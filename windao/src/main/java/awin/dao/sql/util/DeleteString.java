package awin.dao.sql.util;


import awin.dao.exception.DeleteParaNullException;

/**
 * Created by aWin on 2018-05-17.
 */
public class DeleteString extends SqlString {

    public DeleteString deleteFrom(String tableName) throws DeleteParaNullException {
        if(isNullOrEmpty(tableName))
        {
            throw new DeleteParaNullException();
        }
        else
        {
            getEmptySql().append(" delete from "+tableName+" ");
        }
        return this;
    }

    public DeleteString where(String wherePara)
    {
        if(isNullOrEmpty(wherePara))
        {
            return this;
        }
        sql.append(" where "+wherePara+" ");
        return this;
    }
}
