package win.pub.ctrl;


import awin.bean.SuperVO;
import awin.dao.BaseDAO;
import awin.dao.exception.DAOException;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import win.auth.user.vo.UserVO;
import win.pub.model.PageModel;
import win.pub.util.JsonUtil;
import win.pub.vo.AggVO;
import win.pub.vo.QueryData;
import win.pub.vo.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aWin on 2018-09-04.
 */
public abstract class BaseController {




    public ModelAndView index()
    {
        ModelAndView view=new ModelAndView();
        view.setViewName("auth/user/index");
        return view;
    }
    public abstract String query(Integer curr,Integer nums  );

    public <T extends SuperVO> String  queryData(Class<T> c, Integer index ,Integer pageSize)
    {
        QueryData queryData=new QueryData();
        try {
            List data=getDao().queryByPager(c,null,index-1,pageSize);//前台从第一页开始，数据库从第0页开始
            queryData.setData(data);
            queryData.setCount(16);  //TODO 查询总数
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return JsonUtil.beanToJson(queryData);
    }


    public ModelAndView add(AggVO aggVO)
    {
        return null;
    }

    public ModelAndView save(AggVO aggVO)
    {
        return null;
    }

    public Result delete(List<String> pks)
    {
        return null;
    }


    protected Result handle(Exception e)
    {
        Result result=createResult();
        result.setStatue(1);
        result.setMsg(e.getMessage());
        return result;
    }

    protected Result createResult()
    {
        Result result=new Result();
        return result;
    }

    private BaseDAO dao;
    protected BaseDAO getDao()
    {
        if(dao==null)
            dao=new BaseDAO();
        return dao;
    }
}
