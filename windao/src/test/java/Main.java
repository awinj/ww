import awin.bean.IORM;
import awin.dao.BaseDAO;
import awin.dao.exception.DAOException;

/**
 * Created by aWin on 2018-08-10.
 */
public class Main {

    public static void main(String[] args) throws DAOException {
        BaseDAO dao=new BaseDAO();
        dao.update("update auth_user set userName='aa' ");

        dao=new BaseDAO();

        dao.update("update auth_user set userName='汪士文'");



//        dao=new BaseDAO();
//        dao.update("update auth_user set userNmae='a1'");
//
    }
}
