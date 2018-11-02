package win.pub.srv;

import awin.bean.SuperVO;
import awin.bean.VOState;
import awin.dao.BaseDAO;
import awin.dao.exception.DAOException;
import win.pub.vo.AggVO;
import win.pub.vo.MutiAggVO;
import win.pub.vo.QueryData;

import java.util.List;

/**
 * //TODO 保持事务
 * Created by aWin on 2018-09-04.
 */
public class PubServer implements IVOServer {

    private BaseDAO dao;
    protected BaseDAO getDao()
    {
        if(dao==null)
            dao=new BaseDAO();
        return dao;
    }

    public SuperVO save(SuperVO vo) throws DAOException {
        if(vo.getStatus()== VOState.ADD)
        {
            String pk= getDao().insert(vo);
            vo.setAttrValue(vo.getPrimaryKey(),pk);
        }
        else if(vo.getStatus()== VOState.EDIT)
        {
            getDao().update(vo);
        }
        return vo;
    }

    public List<SuperVO> save(List<SuperVO> vos) throws DAOException {
        for(int i=0;i<vos.size();i++)
        {
            save(vos.get(i));
        }
        return vos;
    }

    public int delete(SuperVO vo) throws DAOException {
        if(vo.getStatus()== VOState.DELETE)
        {
            int rowCount= getDao().update(vo);
            return rowCount;
        }
        return 0;
    }

    public int delete(List<SuperVO> vos) throws DAOException {
        int rowCount=0;
        for(int i=0;i<vos.size();i++)
        {
            rowCount+=delete(vos.get(i));
        }
        return rowCount;
    }

    public AggVO save(AggVO aggVO) throws DAOException {

        save(aggVO.getParentVO());
        save(aggVO.getChildrenVO());
        return aggVO;
    }

    public int delete(AggVO aggVO) throws DAOException {
        int rowCount=0;
        rowCount+=delete(aggVO.getParentVO());
        rowCount+=delete(aggVO.getChildrenVO());
        return rowCount;
    }

    public MutiAggVO save(MutiAggVO aggVO) throws DAOException {
        save(aggVO.getParentVO());
        save((List<SuperVO>) aggVO.getAllChildrenVO().values());
        return aggVO;
    }

    public int delete(MutiAggVO aggVO) throws DAOException {
        int rowCount=0;
        rowCount+=delete(aggVO.getParentVO());
        rowCount+=delete((List<SuperVO>) aggVO.getAllChildrenVO().values());
        return rowCount;
    }


    public <T extends SuperVO> QueryData  queryData(Class<T> c,String where, Integer index ,Integer pageSize)
    {
        QueryData queryData=new QueryData();
        try {
            List data=getDao().queryByPager(c,where,index-1,pageSize);//前台从第一页开始，数据库从第0页开始
            Integer count=getDao().queryCount(c,where);
            queryData.setData(data);
            queryData.setCount(count);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return queryData;
    }
}
