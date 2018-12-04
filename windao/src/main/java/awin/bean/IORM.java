package awin.bean;

/**
 * Created by aWin on 2018-08-09.
 */
public interface IORM {

    /**
     * 返回数据库表名称
     * @return
     */
     String getTableName();

    /**
     * 返回主键字段
     * @return
     */
     String getPrimaryKey();

    /**
     * 获得字段的值
     * @param attr
     * @return
     */
     Object getAttrValue(String attr);

    /**
     * 设置字段的值
     * @param attr
     * @param val
     */
    void setAttrValue(String attr,Object val);

    /**
     * 获得字段名称数据
     * @return
     */
    String[] getAttrNames();

    /**
     * 获得字段值数组
     * @return
     */
    Object[] getAttrValues();

}
