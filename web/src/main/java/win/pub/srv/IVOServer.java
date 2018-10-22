package win.pub.srv;

import awin.bean.SuperVO;
import awin.dao.exception.DAOException;
import win.pub.vo.AggVO;
import win.pub.vo.MutiAggVO;

import java.util.List;

/**
 * 基础业务接口
 * Created by aWin on 2018-09-04.
 */
public interface IVOServer {

    SuperVO save(SuperVO vo) throws DAOException;
    List<SuperVO> save(List<SuperVO> vos) throws DAOException;
    int delete(SuperVO vo) throws DAOException;


    int delete(List<SuperVO> vos) throws DAOException;

    AggVO save(AggVO aggVO) throws DAOException;
    int delete(AggVO aggVO) throws DAOException;

    MutiAggVO save(MutiAggVO aggVO) throws DAOException;
    int delete(MutiAggVO aggVO) throws DAOException;





}
