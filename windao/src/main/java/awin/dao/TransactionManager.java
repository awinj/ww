package awin.dao;

import awin.dao.exception.DAOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aWin on 2018-12-14.
 *
 * @Description: 申明式事务管理类
 * 使用方法  addToTransaction(dao);  begin();   业务逻辑 ;   commit();  异常：rollback()
 */
public class TransactionManager {

    List<BaseDAO> daos=new ArrayList<BaseDAO>();

    /**
     * 将需要当作事务处理的dao添加到管理器中，最好只添加一个dao
     * @param dao basedao
     */
    public void addToTransaction(BaseDAO dao) {
        if (dao != null) {
            dao.setAutoCommit(false);
            daos.add(dao);
        }
    }


    /**
     * 表明下面的数据库操作将启用事务
     * @throws DAOException 异常
     */
    public void begin() throws DAOException {
        try
        {
            for (BaseDAO dao :daos) {
                dao.getTransPersistence().getConnection().setAutoCommit(false);
            }
        }catch (SQLException e)
        {
            throw new DAOException(e.getMessage(),e);
        }

    }

    /**
     *  提交数据操作
     * @throws DAOException 异常
     */
    public void commit() throws DAOException {

        try
        {
            //如果非第一个dao提交发生异常，第一个dao已经提交，此bug待完善。
            for (BaseDAO dao:daos) {
                dao.getTransPersistence().getConnection().commit();
            }

            for (BaseDAO dao:daos) {
                dao.getTransPersistence().closeAll();
            }

            //归还自动提交，以免后续无需事务的dao不自动提交
            for (BaseDAO dao :daos) {
                dao.setAutoCommit(true);
            }
        }catch (SQLException e)
        {
            throw new DAOException(e.getMessage(),e);
        }


    }

    /**
     * 回滚数据库
     * @throws DAOException 异常
     */
    public void rollback() throws DAOException {

        try
        {
            for (BaseDAO dao:daos) {
                dao.getTransPersistence().getConnection().rollback();
            }

            for (BaseDAO dao:daos) {
                dao.getTransPersistence().closeAll();
            }

            //归还自动提交，以免后续无需事务的dao不自动提交
            for (BaseDAO dao :daos) {
                dao.setAutoCommit(true);
            }
        }catch (SQLException e)
        {
            throw new DAOException(e.getMessage(),e);
        }


    }



    void test() throws DAOException {
        BaseDAO dao =new BaseDAO();
        BaseDAO dao1=new BaseDAO();
        TransactionManager transaction=new TransactionManager();
        transaction.addToTransaction(dao);
//        transaction.addToTransaction(dao1);
        transaction.begin();
        try
        {
            dao.update("update auth_user set userName='wsw' where pk_user='DF201811122213291004'");

            dao1.update("update auth_user set userName='wsw1' where pk_user='DF201811122213291004'");
            dao1.update("update auth_user set userName1='ww1' where pk_user='DF201811122210511003'");
            transaction.commit();
        }
        catch (Exception e)
        {
//            e.printStackTrace();

            transaction.rollback();
        }

    }
}
