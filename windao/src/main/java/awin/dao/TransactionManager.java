package awin.dao;

import awin.dao.exception.DAOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aWin on 2018-12-14.
 *
 * @Description:
 */
public class TransactionManager {

    List<BaseDAO> daos=new ArrayList<BaseDAO>();

    public void addToTransaction(BaseDAO dao) {
        if (dao != null) {
            dao.setAutoCommit(false);
            daos.add(dao);
        }
    }


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

    public void commit() throws DAOException {

        try
        {
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
