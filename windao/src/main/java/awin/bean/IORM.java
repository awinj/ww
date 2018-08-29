package awin.bean;

/**
 * Created by aWin on 2018-08-09.
 */
public interface IORM {

     String getTableName();
     String getPrimaryKey();

     Object getAttrValue(String attr);
    void setAttrValue(String attr,Object val);

    String[] getAttrNames();
    Object[] getAttrValues();

}
