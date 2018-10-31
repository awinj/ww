package awin.dao.persistence;

import awin.bean.util.BeanHelper;
import awin.dao.exception.BaseException;
import awin.dao.exception.DAOException;
import awin.pub.Parser;

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
        List<T> list = new ArrayList<T>();
        try {

            ResultSetMetaData metaData = rs.getMetaData();
            int colcount = metaData.getColumnCount();
            while (rs.next()) {
                T obj = c.newInstance();
                List<String> fields = BeanHelper.getPropertys(obj);
                for (int i = 1; i <= colcount; i++) {
                    int type = metaData.getColumnType(i);
                    String columnname = metaData.getColumnName(i);
                    String fieldname = null;
                    for (int j = 0; j < fields.size(); j++) {
                        if (columnname.equals(fields.get(j).toUpperCase()))
                            fieldname = fields.get(j);
                    }
                    if (fieldname != null) {
                        if (type == 2) {
                            BeanHelper.setProperty(obj, fieldname, rs.getBigDecimal(columnname));
                        } else if (type == 12 || type == 1) {
                            BeanHelper.setProperty(obj, fieldname, rs.getString(columnname));
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

    /**
     * 将数据集第一行转化为一维数组
     *
     * @param rs 数据集
     * @return 数组
     */
    public Object[] firstToArray(ResultSet rs) throws BaseException {
        try
        {
            ResultSetMetaData meta = rs.getMetaData();
            int cols = meta.getColumnCount();
            Object[] result = new Object[cols];

            for (int i = 0; i < cols; i++) {
                result[i] = rs.getObject(i + 1);
            }
            return result;
        }
       catch (Exception e)
       {
           throw new BaseException(e.getMessage(),e);
       }
    }

    /**
     * 将数据集的第一行第一列转化为字符串
     *
     * @param rs 数据集
     * @return
     */
    public String firstToString(ResultSet rs) throws DAOException {
        return Parser.toString(firstToObject(rs));
    }

    /**
     * 将数据集的第一行第一列转化为int
     *
     * @param rs 数据集
     * @return
     */
    public Integer firstToInt(ResultSet rs) throws DAOException {
        return Parser.parseInt(firstToObject(rs));
    }

    public Object firstToObject(ResultSet rs) throws DAOException {
        try {
            while (rs.next()) {
                return rs.getObject(1);
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage(), e);
        }
        return null;
    }
}
