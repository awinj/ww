package win.pub.srv;

import awin.bean.SuperVO;
import awin.bean.VOState;
import awin.dao.BaseDAO;
import awin.dao.exception.DAOException;
import awin.logger.Logger;
import win.pub.vo.AggVO;
import win.pub.vo.BusinessException;
import win.pub.vo.MutiAggVO;
import win.pub.vo.QueryData;

import java.util.List;
import java.util.Map;

/**
 * //TODO 保持事务
 * Created by aWin on 2018-09-04.
 */
public class PubServer implements IVOServer {

    private BaseDAO dao;

    protected BaseDAO getDao() {
        if (dao == null)
            dao = new BaseDAO();
        return dao;
    }

    public SuperVO save(SuperVO vo) throws DAOException {
//        if(vo.getStatus()== VOState.ADD)
        if (vo == null)
            throw new RuntimeException("待保存的数据为空");
        String pkval = (String) vo.getAttrValue(vo.getPrimaryKey());
        if (pkval == null || "".equals(pkval.trim())) {
            pkval = getDao().insert(vo);
            vo.setAttrValue(vo.getPrimaryKey(), pkval);
        }
//        else if(vo.getStatus()== VOState.EDIT)
        else {
            getDao().update(vo);
        }
        return vo;
    }

    public List<SuperVO> save(List<SuperVO> vos) throws DAOException {
        if (vos == null || vos.size() <= 0) {
            throw new RuntimeException("待保存的数据为空");
        }
        for (int i = 0; i < vos.size(); i++) {
            save(vos.get(i));
        }
        return vos;
    }

    public int delete(SuperVO vo) throws DAOException {
        if (vo == null)
            throw new RuntimeException("待删除的数据为空");
        int rowCount = getDao().delete(vo);
        return rowCount;
    }

    public int delete(List<SuperVO> vos) throws DAOException {
        if (vos == null)
            throw new RuntimeException("待删除的数据为空");
        int rowCount = 0;
        for (int i = 0; i < vos.size(); i++) {
            rowCount += delete(vos.get(i));
        }
        return rowCount;
    }

    public AggVO save(AggVO aggVO) throws DAOException {
        if (aggVO.getParentVO() != null)
            save(aggVO.getParentVO());
        if (aggVO.getChildrenVO() != null)
            save(aggVO.getChildrenVO());
        return aggVO;
    }

    public int delete(AggVO aggVO) throws DAOException {
        int rowCount = 0;
        if (aggVO.getParentVO() != null)
            rowCount += delete(aggVO.getParentVO());
        if (aggVO.getChildrenVO() != null)
            rowCount += delete(aggVO.getChildrenVO());
        return rowCount;
    }

    public MutiAggVO save(MutiAggVO aggVO) throws DAOException {
        if (aggVO.getParentVO() != null)
            save(aggVO.getParentVO());
        if (aggVO.getAllChildrenVO() != null)
            save((List<SuperVO>) aggVO.getAllChildrenVO().values());
        return aggVO;
    }

    public int delete(MutiAggVO aggVO) throws DAOException {
        int rowCount = 0;
        if (aggVO.getParentVO() != null)
            rowCount += delete(aggVO.getParentVO());
        if (aggVO.getAllChildrenVO() != null)
            rowCount += delete((List<SuperVO>) aggVO.getAllChildrenVO().values());
        return rowCount;
    }


    /**
     * 分页查询
     *
     * @param c        查询的数据类型
     * @param con      查询条件
     * @param index    页码从0开始
     * @param pageSize 每页数据条数
     * @param <T>
     * @return 实体集合
     * @throws DAOException
     */
    public <T extends SuperVO> QueryData queryData(Class<T> c, Map<String, Object> con, Integer index, Integer pageSize) throws BusinessException {
        QueryData queryData = new QueryData();
        try {
            List data = getDao().queryByPager(c, con, index - 1, pageSize);//前台从第一页开始，数据库从第0页开始
            Integer count = getDao().queryCount(c, con);
            queryData.setData(data);
            queryData.setCount(count);
        } catch (DAOException e) {
            Logger.Error(e.getMessage(), e);
            throw new BusinessException("数据查询异常");
        }
        return queryData;
    }

    /**
     * 其中where不能是从界面数据拼接得到的字符串，这样会存在sql注入漏洞
     *
     * @param c
     * @param where 不能与界面数据有关，一般用于固定条件查询，例如 dr='N'
     * @param <T>
     * @return
     */
    public <T extends SuperVO> List<T> queryByWhere(Class<T> c, String where) {
        try {
            return getDao().queryByWhere(c, where);
        } catch (DAOException e) {
            Logger.Error(e.getMessage(), e);
            return null;
        }
    }
}
