package win.pub.srv;

import awin.dao.BaseDAO;
import awin.dao.exception.DAOException;
import awin.dao.persistence.type.SQLParameter;
import awin.logger.Logger;
import awin.util.parse.ParseUtil;

/**
 * Created by aWin on 2018-12-10.
 *
 * @Description:
 */
public class WinRefServer {
    private BaseDAO dao;

    protected BaseDAO getDao() {
        if (dao == null)
            dao = new BaseDAO();
        return dao;
    }


    public String getValue(String table,String column,String pkfield,String pkval)
    {
        StringBuilder sql=new StringBuilder();
        sql.append("select ").append(column).append(" from ").append(table).append(" where ").append(pkfield).append("=?");
        SQLParameter parameter=new SQLParameter();
        parameter.addParam(pkval);
        try {
            Object ret=getDao().query(sql.toString(),parameter);
            return ParseUtil.parseString(ret);
        } catch (DAOException e) {
            Logger.Error("参照档案出现异常");
            Logger.Error(e.getMessage(),e);
        }
        return "";
    }

}
