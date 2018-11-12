package win.pub.ctrl;


import awin.bean.SuperVO;
import awin.dao.exception.DAOException;
import org.springframework.web.servlet.ModelAndView;
import win.pub.srv.PubServer;
import win.pub.util.JsonUtil;
import win.pub.vo.AggVO;
import win.pub.vo.QueryData;
import win.pub.vo.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aWin on 2018-09-04.
 */
public abstract class BaseController<T extends AggVO>{




    public ModelAndView index()
    {
        ModelAndView view=new ModelAndView();
        view.setViewName("auth/user/index");
        return view;
    }
    public abstract String query(String condition, Integer curr, Integer nums  );

    public <T extends SuperVO> String  queryData(Class<T> c,String condition, Integer index ,Integer pageSize)
    {
        //TODO 将condition 转换为查询条件
        Map con= JsonUtil.jsonToBean(condition, HashMap.class);
        String where="";
        if(condition!=null&&condition.length()>0)
        {
            where="usercode like 'wsw_' or usercode like 'wsw__'" ;
        }
        QueryData queryData=getServer().queryData(c,where,index,pageSize);
        return JsonUtil.beanToJson(queryData);
    }


    public ModelAndView add(T aggVO)
    {
        return null;
    }

    public Result save(T aggVO)
    {
        try {
             getServer().save(aggVO);
        } catch (DAOException e) {
            return  null;
        }
        return  null;
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

    PubServer server;
    private PubServer getServer()
    {
        if(server==null)
            server=new PubServer();
        return server;
    }
}
