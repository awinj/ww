package awin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import awin.bean.IORM;
import awin.bean.SuperVO;
import awin.bean.util.BeanHelper;
import awin.dao.exception.DAOException;
import awin.dao.persistence.Persistence;
import awin.dao.persistence.ResultSetUtil;
import awin.dao.persistence.type.SQLParameter;
import awin.logger.Logger;

public class BaseDAO {

    //	Persistence persistence;
    private ResultSetUtil resultSetUtil;


    private boolean isAutoCommit=true;

    /**
     * @param vo 插入的数据
     * @throws DAOException 异常
     * @return 返回插入数据的主键
     */
    public String insert(SuperVO vo) throws DAOException {
        Persistence persistence = null;
        try {
            persistence = createPersistence();
            String pk = persistence.insert(vo);
            persistence.closeAll();
            return pk;
        } catch (DAOException e) {
            handleException(e, persistence);
            throw e;
        }
    }

    /**
     * @param vo 插入的数据
     * @throws DAOException 异常 异常
     * @return 返回插入数据的主键
     */
    public String[] insert(SuperVO[] vo) throws DAOException {
        Persistence persistence = null;
        try {
            persistence = createPersistence();
            String[] pks = persistence.insert(vo);
            persistence.closeAll();
            return pks;
        } catch (DAOException e) {
            handleException(e, persistence);
            throw e;
        }
    }

    /**
     * @param vo 更新的数据
     * @throws DAOException 异常 异常
     * @return 返回受影响的行数
     */
    public int update(SuperVO vo) throws DAOException {
        Persistence persistence = null;
        try {
            persistence = createPersistence();
            int i = persistence.update(vo);
            persistence.closeAll();
            return i;
        } catch (DAOException e) {
            handleException(e, persistence);
            throw e;
        }
    }

    /**
     * 根据主键删除数据
     *
     * @param vo 删除的数据
     * @return 删除的行数
     * @throws DAOException 异常 异常
     */
    public int delete(SuperVO vo) throws DAOException {
        Persistence persistence = null;
        try {
            persistence = createPersistence();
            int ret = persistence.delete(vo);
            persistence.closeAll();
            return ret;
        } catch (DAOException e) {
            handleException(e, persistence);
            throw e;
        }
    }

    /**
     * 批量根据主键删除数据
     *
     * @param vos 删除的数据
     * @return 删除的行数
     * @throws DAOException 异常
     */
    public int delete(SuperVO[] vos) throws DAOException {
        Persistence persistence = null;
        try {
            persistence = createPersistence();
            int ret = persistence.delete(vos);
            closePersistence(persistence);
            return ret;
        } catch (DAOException e) {
            handleException(e, persistence);
            throw e;
        }
    }

    /**
     * @param c   查询类型
     * @param <T> SuperVO子类 SuperVO
     * @return 返回实体集合
     * @throws DAOException 异常
     */
    public <T extends SuperVO> List<T> query(Class<T> c) throws DAOException {
        Persistence persistence = null;
        try {
            persistence = createPersistence();
            ResultSet rs = persistence.query(c);
            List<T> ret = getResultSetUtil().toBeanList(c, rs);
            close(rs, persistence);
            return ret;
        } catch (DAOException e) {
            handleException(e, persistence);
            throw e;
        }
    }


    /**
     * 必须为静态的sql,如果通过外界传入的参数进行拼接成的sql，会有sql注入的风险
     *
     * @param c   返回实体的类型
     * @param sql sql语句
     * @param <T> SuperVO子类 SuperVO子类
     * @return 返回实体集合
     * @throws DAOException 异常 异常
     */
    public <T> List<T> query(Class<T> c, String sql) throws DAOException {
        Persistence persistence = null;
        try {
            persistence = createPersistence();
            ResultSet rs = persistence.query(sql);
            List<T> ret = getResultSetUtil().toBeanList(c, rs);
            close(rs, persistence);
            return ret;
        } catch (DAOException e) {
            handleException(e, persistence);
            throw e;
        }
    }

    public <T> List<T> query(Class<T> c, String sql, SQLParameter parameter) throws DAOException {
        Persistence persistence = null;
        try {
            persistence = createPersistence();
            ResultSet rs = persistence.query(sql, parameter);
            List<T> ret = getResultSetUtil().toBeanList(c, rs);
            close(rs, persistence);
            return ret;
        } catch (DAOException e) {
            handleException(e, persistence);
            throw e;
        }
    }

    public List query4List(String sql, SQLParameter parameter) throws DAOException {
        Persistence persistence = null;
        try {
            persistence = createPersistence();
            ResultSet rs = persistence.query(sql, parameter);
            List ret = getResultSetUtil().toArrayList(rs);
            close(rs, persistence);
            return ret;
        } catch (DAOException e) {
            handleException(e, persistence);
            throw e;
        }
    }

    public List query4List(String sql) throws DAOException {
        Persistence persistence = null;
        try {
            persistence = createPersistence();
            ResultSet rs = persistence.query(sql);
            List ret = getResultSetUtil().toArrayList(rs);
            close(rs, persistence);
            return ret;
        } catch (DAOException e) {
            handleException(e, persistence);
            throw e;
        }
    }

    /**
     * 一般用于固定条件查询，例如 dr='N'
     *
     * @param c        查询的类型
     * @param whereSql where 子句
     * @param <T> SuperVO子类 SuperVO子类
     * @return 实体集合
     * @throws DAOException 异常 异常
     */
    public <T extends SuperVO> List<T> queryByWhere(Class<T> c, String whereSql) throws DAOException {
        Persistence persistence = null;
        try {
            persistence = createPersistence();
            ResultSet rs = persistence.queryByWhere(c, whereSql);
            List<T> ret = getResultSetUtil().toBeanList(c, rs);
            close(rs, persistence);
            return ret;
        } catch (DAOException e) {
            handleException(e, persistence);
            throw e;
        }
    }

    /**
     * @param c        查询的类型
     * @param whereSql where 子句
     * @param <T> SuperVO子类
     * @return 实体集合
     * @throws DAOException 异常
     */
    public <T extends SuperVO> List<T> queryByWhere(Class<T> c, String whereSql, SQLParameter parameter) throws DAOException {
        Persistence persistence = null;
        try {
            persistence = createPersistence();
            ResultSet rs = persistence.queryByWhere(c, whereSql, parameter);
            List<T> ret = getResultSetUtil().toBeanList(c, rs);
            close(rs, persistence);
            return ret;
        } catch (DAOException e) {
            handleException(e, persistence);
            throw e;
        }
    }

    /**
     * 分页查询
     *
     * @param c        查询的数据类型
     * @param con      查询条件
     * @param index    页码从0开始
     * @param pageSize 每页数据条数
     * @param <T> SuperVO子类
     * @return 实体集合
     * @throws DAOException 异常
     */
    public <T extends SuperVO> List<T> queryByPager(Class<T> c, Map<String, Object> con, Integer index, Integer pageSize) throws DAOException {
        Persistence persistence = null;
        try {
            persistence = createPersistence();
            ResultSet rs = persistence.queryByPager(c, con, index, pageSize);
            List<T> ret = getResultSetUtil().toBeanList(c, rs);
            close(rs, persistence);
            return ret;
        } catch (DAOException e) {
            handleException(e, persistence);
            throw e;
        }
    }


    /**
     * 返回第一行第一列值
     *
     * @param sql sql语句
     * @return 返回第一行第一列值
     * @throws DAOException 异常
     */
    public Object query4First(String sql) throws DAOException {
        Persistence persistence = null;
        try {
            persistence = createPersistence();
            Object ret = getResultSetUtil().firstToObject(persistence.query(sql));
            closePersistence(persistence);
            return ret;
        } catch (DAOException e) {
            handleException(e, persistence);
            throw e;
        }
    }

    /**
     * 返回第一行第一列值
     *
     * @param sql sql语句
     * @return 返回第一行第一列值
     * @throws DAOException 异常
     */
    public Object query4First(String sql, SQLParameter parameter) throws DAOException {
        Persistence persistence = null;
        try {
            persistence = createPersistence();
            Object ret = getResultSetUtil().firstToObject(persistence.query(sql, parameter));
            closePersistence(persistence);
            return ret;
        } catch (DAOException e) {
            handleException(e, persistence);
            throw e;
        }
    }

    public int update(String sql) throws DAOException {
        Persistence persistence = null;
        try {
            persistence = createPersistence();
            int ret = persistence.executeUpdate(sql);
            closePersistence(persistence);
            return ret;
        } catch (DAOException e) {
            handleException(e, persistence);
            throw e;
        }
    }

    public int update(String sql, SQLParameter parameter) throws DAOException {
        Persistence persistence = null;
        try {
            persistence = createPersistence();
            int ret = persistence.executeUpdate(sql, parameter);
            closePersistence(persistence);
            return ret;
        } catch (DAOException e) {
            handleException(e, persistence);
            throw e;
        }
    }

    public <T extends SuperVO> int deleteByWhere(Class<T> c, String where) throws DAOException {

        IORM vo = BeanHelper.createBean(c);
        Persistence persistence = null;
        try {
            persistence = createPersistence();
            String table = vo.getTableName();
            int ret = persistence.executeUpdate("delete from " + table + " where " + where);
            closePersistence(persistence);
            return ret;
        } catch (DAOException e) {
            handleException(e, persistence);
            throw e;
        }
    }

    public <T extends SuperVO> int deleteByWhere(Class<T> c, String where, SQLParameter parameter) throws DAOException {
        IORM vo = BeanHelper.createBean(c);
        String table = vo.getTableName();
        Persistence persistence = null;
        try {
            persistence = createPersistence();
            int ret = persistence.executeUpdate("delete from " + table + " where " + where, parameter);
            closePersistence(persistence);
            return ret;
        } catch (DAOException e) {
            handleException(e, persistence);
            throw e;
        }
    }

    /**
     * 查询符合条件的数据的条数
     *
     * @param c   类型
     * @param con 查询条件
     * @param <T> SuperVO子类
     * @return 数据行数
     */
    public <T extends SuperVO> Integer queryCount(Class<T> c, Map<String, Object> con) throws DAOException {
        Persistence persistence = null;
        try {
            persistence = createPersistence();
            Integer ret = getResultSetUtil().firstToInt(persistence.queryCount(c, con));
            closePersistence(persistence);
            return ret;
        } catch (DAOException e) {
            handleException(e, persistence);
            throw e;
        }
    }

    /**
     * @return 返回ResultSet 处理工具
     */
    private ResultSetUtil getResultSetUtil() {
        if (resultSetUtil == null) {
            resultSetUtil = new ResultSetUtil();
        }
        return resultSetUtil;
    }

    //执行数据库的为100s，如果超过100s将会抛出超时异常
    private int timeout=100;

    public void setTimeout(int timeout)
    {
        this.timeout=timeout;
    }


    void setAutoCommit(boolean autoCommit) {
        isAutoCommit = autoCommit;
    }
    private Persistence transPersistence;

    /**
     * @return 返回持久层实例
     */
    private Persistence createPersistence() throws DAOException {

        if(!isAutoCommit)  //如果不是自动提交，将返回同一个persistence。
        {
            if(transPersistence==null)
            {
                transPersistence=new Persistence();
                transPersistence.setTimeout(timeout);
            }
            return transPersistence;
        }
        else    //如果是自动提交，则dao创造新的persitence。
        {
            Persistence persistence=new Persistence();
            persistence.setTimeout(this.timeout);
            return persistence;
        }
    }

    private void closeResultSet(ResultSet rs) throws DAOException {
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            throw new DAOException(e.getMessage(), e);
        }
    }

    private void closePersistence(Persistence persistence) {
        //自动提交的时候，才会关闭，不自动提交的时候，需要等到commit或者rollback才会关闭
        if (persistence != null&&isAutoCommit)
            persistence.closeAll();
    }

    /**
     * 当dao添加到事务管理器中时，会采用transPersistence来读写数据库，
     * 如果没有添加到事务管理器中，将为空。
     * 同一个dao实例，返回的transPersistence也是同一个，同时也是同一个connection.
     * 添加到事务管理器中的dao，执行完方法，连接的关闭将由事务管理器控制。
     * @return 返回的transPersistence
     */
    Persistence getTransPersistence() throws DAOException {
        if(transPersistence==null&&!isAutoCommit)
        {
            transPersistence=new Persistence();
            transPersistence.setTimeout(this.timeout);
        }
        return transPersistence;
    }

    private void close(ResultSet rs, Persistence p) throws DAOException {
        closeResultSet(rs);
        closePersistence(p);
    }

    private void handleException(DAOException e, Persistence p) {
        Logger.Error(e.getMessage(), e);
        closePersistence(p);
    }
}
