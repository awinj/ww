package win.pub.util;

import awin.dao.BaseDAO;
import awin.dao.conn.BasicConnection;
import awin.dao.exception.DAOException;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * Created by aWin on 2018-12-12.
 *
 * @Description:
 */
public class Test {

    public static void main(String[] args) throws DAOException {

            BaseDAO dao=new BaseDAO();
            dao.update("update auth_user set userName='aa' ");

            dao=new BaseDAO();

            dao.update("update auth_user set userName='汪士文1'");



            dao=new BaseDAO();
            dao.update("update auth_user set userNmae='a1'");




//
    }
}
