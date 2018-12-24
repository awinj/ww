import awin.dao.BaseDAO;
import awin.dao.TransactionManager;
import awin.util.date.DateUtil;


/**
 * Created by aWin on 2018-08-10.
 */
public class Main {

    public static void main(String[] args) throws Exception {
//        Connection con= BasicConnection.getInstance().getConnection();
//        con.setAutoCommit(false);
//        Statement statement = con.createStatement();
//        statement.executeUpdate("update auth_user set userName='ww' where pk_user='DF201811122213291004'");
//        statement.close();
//        con.close();
//        con.commit();


        BaseDAO dao =new BaseDAO();
        BaseDAO dao1=new BaseDAO();
        TransactionManager transaction=new TransactionManager();
        transaction.addToTransaction(dao);
//        transaction.addToTransaction(dao1);
        transaction.begin();
        try
        {
            dao.update("update auth_user set userName='wsw' where pk_user='DF201811122213291004'");
            System.out.print(DateUtil.getCurrentTime());
            dao1.update("update auth_user set userName='wsw1' where pk_user='DF201811122213291004'");
            dao1.update("update auth_user set userName1='ww1' where pk_user='DF201811122210511003'");
            transaction.commit();
        }
        catch (Exception e)
        {
//            e.printStackTrace();
            System.out.print(DateUtil.getCurrentTime());
            transaction.rollback();
        }

        System.out.print(DateUtil.getCurrentDate());

    }
}
