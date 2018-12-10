package awin.dao.persistence;

import awin.bean.util.BeanHelper;
import awin.dao.exception.BaseException;
import awin.dao.exception.DAOException;
import awin.logger.Logger;
import awin.util.parse.ParseUtil;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ResultSet 处理工具，将ResultSet转化为容易处理的java对象。
 */
public class ResultSetUtil {

    /**
     * 将数据集转化为实体集合
     * @param c 类型
     * @param rs 数据集
     * @param <T> 泛型
     * @return
     * @throws DAOException
     */
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
            Logger.Error(e.getMessage(),e);
        } catch (IllegalAccessException e) {
            Logger.Error(e.getMessage(),e);
        }
        return list;
    }

    /**
     * 将数据集的第一行转化为实体
     * @param c 类型
     * @param rs 数据集
     * @param <T> 泛型
     * @return
     * @throws DAOException
     */
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
    public Object[] firstToArray(ResultSet rs) throws SQLException {
        return rs.next() ? toArray(rs) : null;
    }

    /**
     * 将数据集的第一行第一列转化为字符串
     *
     * @param rs 数据集
     * @return
     */
    public String firstToString(ResultSet rs) throws DAOException {
        return ParseUtil.parseString(firstToObject(rs));
    }

    /**
     * 将数据集的第一行第一列转化为int
     *
     * @param rs 数据集
     * @return
     */
    public Integer firstToInt(ResultSet rs) throws DAOException {
        return ParseUtil.parseInt(firstToObject(rs));
    }

    /**
     * 返回数据集的第一行第一列
     * @param rs
     * @return
     * @throws DAOException
     */
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


    public List toArrayList(ResultSet rs) throws DAOException {

        List result = new ArrayList();
        try {
        while (rs.next()) {

                result.add(toArray(rs));

        }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage(),e);
        }
        return result;
    }

    public  Object[] toArray(ResultSet rs) throws SQLException {
        ResultSetMetaData meta = rs.getMetaData();
        int cols = meta.getColumnCount();
        Object[] result = new Object[cols];
        for (int i = 0; i < cols; i++) {
            result[i] = rs.getObject(i + 1);
        }
        return result;
    }
}
