package awin.dao.persistence;

import awin.bean.util.BeanHelper;
import awin.dao.exception.DAOException;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ResultSet 处理工具，将ResultSet转化为容易处理的java对象。
 */
public class ResultSetUtil {

    public <T> List<T> toBeanList(Class<T> c, ResultSet rs) throws DAOException {
        List<T> list=new ArrayList<T>();
        try {

            ResultSetMetaData metaData=rs.getMetaData();
            int colcount=metaData.getColumnCount();
            while (rs.next()) {
                T obj=c.newInstance();
                List<String> fields=BeanHelper.getPropertys(obj);
                for(int i=1;i<=colcount;i++)
                {
                    int type=metaData.getColumnType(i);
                    String columnname=metaData.getColumnName(i);
                    String fieldname=null;
                    for(int j = 0; j< fields.size(); j++)
                    {
                        if(columnname.equals(fields.get(j).toUpperCase()))
                            fieldname= fields.get(j);
                    }
                    if(fieldname!=null)
                    {
                        if(type==2)
                        {
                            BeanHelper.setProperty(obj,fieldname,rs.getBigDecimal(columnname));
                        }
                        else if(type==12||type==1)
                        {
                            BeanHelper.setProperty(obj,fieldname,rs.getString(columnname));
                        }
                    }
                }
                list.add(obj);
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage(), e);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return list;
    }

    public <T> T firstToBean(Class<T> c, ResultSet rs) throws DAOException {
        try {
            while (rs.next()) {
                System.out.println(rs.getString("deptno"));
                break;
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage(), e);
        }
        return null;
    }

    public Object[] firstToArray(ResultSet rs) {
        return null;
    }
}
