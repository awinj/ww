package awin.dao.sql.util;

import awin.dao.exception.UpdateParaNullException;

/**
 * Created by aWin on 2018-05-08.
 */
public class UpdateString extends SqlString {

    public UpdateString update(String tableName) throws UpdateParaNullException {
        if(isNullOrEmpty(tableName))
        {
            throw new UpdateParaNullException();
        }
        else
        {
            getEmptySql().append(" update  "+tableName+" ");
        }
        return this;
    }

    public UpdateString set(String field,String value) throws UpdateParaNullException {
        if(isNullOrEmpty(field)||isNullOrEmpty(value))
        {
            throw new UpdateParaNullException();
        }
        getSql().append("set ").append(field).append(" ='"+value+"'");
        return this;
    }

    public UpdateString set(String[] field,Object[] value)throws UpdateParaNullException
    {
        if(isNullOrEmpty(field)||isNullOrEmpty(value))
        {
            throw new UpdateParaNullException();
        }
        getSql().append("set ");
        for(int i=0;i<field.length;i++)
        {
            if(!isNullOrEmpty(field[i]))
            {
                if(value[i]==null){
                    getSql().append(field[i]).append(" =null ,");
                }
                else {
                    getSql().append(field[i]).append(" ='"+value[i]+"' ,");
                }

            }
        }
        getSql().deleteCharAt(getSql().length()-1);
        return this;
    }

    public UpdateString set(String[] field)throws UpdateParaNullException
    {
        if(isNullOrEmpty(field))
        {
            throw new UpdateParaNullException();
        }
        getSql().append("set ");
        for(int i=0;i<field.length;i++)
        {
            getSql().append(field[i]).append(" =? ,");//参数化
        }
        getSql().deleteCharAt(getSql().length()-1);
        return this;
    }


    public UpdateString where(String wherePara)
    {
        if(isNullOrEmpty(wherePara))
        {
            return this;
        }
        sql.append(" where "+wherePara+" ");
        return this;
    }

}
