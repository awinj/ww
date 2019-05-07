package awin.entity.reflect;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aWin on 2019-05-06.
 *
 * @Description:
 */
public class EntityInfo {

    private String tableName;

    private String primaryKey;

    private Map<String,String> columnMap;


    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

//    public Map<String, String> getColumnMap() {
//        return columnMap;
//    }
//
//    public void setColumnMap(Map<String, String> columnMap) {
//        this.columnMap = columnMap;
//    }


    public void put(String columnName,String filedName)
    {
        if(columnMap==null)
            columnMap=new HashMap<String,String>();
        columnMap.put(columnName,filedName);
    }



    public String getSelectStr()
    {
        StringBuilder str=new StringBuilder();
        if(columnMap==null)
            columnMap=new HashMap<String,String>();
        for(String columnName : columnMap.keySet())
        {
            str.append(columnName).append(" as ").append(columnMap.get(columnName)).append(",");
        }
        return str.deleteCharAt(str.length()-1).toString();
    }

    public String[] getIntoColumns()
    {
        if(columnMap==null)
            columnMap=new HashMap<String,String>();
        return columnMap.keySet().toArray(new String[0]);
    }

    public String[] getIntoValues()
    {
        if(columnMap==null)
            columnMap=new HashMap<String,String>();
        //TODO
        return columnMap.keySet().toArray(new String[0]);
    }



    public String[] getSetKeyVal()
    {
        if(columnMap==null)
            columnMap=new HashMap<String,String>();
        int size=columnMap.keySet().size();
        String[] keyval=new String[size];

        int index=0;
        for(String column : columnMap.keySet())
        {
            //TODO
            String str=(column+"="+columnMap.get(column));
            keyval[index]=str;
            index++;
        }
        return keyval;
    }
}
