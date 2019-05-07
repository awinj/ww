import javax.transaction.*;

/**
 * Created by aWin on 2018-12-13.
 *
 * @Description:
 */
public class WinTransaction implements UserTransaction {



    public void begin() throws NotSupportedException, SystemException {

    }

    public void commit() throws RollbackException, HeuristicMixedException, HeuristicRollbackException, SecurityException, IllegalStateException, SystemException {

    }

    public void rollback() throws IllegalStateException, SecurityException, SystemException {

    }

    public void setRollbackOnly() throws IllegalStateException, SystemException {

    }

    public int getStatus() throws SystemException {
        return 0;
    }

    public void setTransactionTimeout(int i) throws SystemException {

    }
}
