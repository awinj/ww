package win.pub.ctrl;


import awin.bean.SuperVO;
import awin.dao.exception.DAOException;
import org.springframework.validation.ObjectError;
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
        //TODO 将查询条件组装放到dao层，并参数化，防止sql注入
        StringBuffer where=new StringBuffer("1=1 ");
        Map<String,Object> con= JsonUtil.jsonToBean(condition, HashMap.class);
        if(con!=null)
        {
            for(String key : con.keySet())
            {
                Object val=con.get(key);
                if(val!=null&&val.toString().trim().length()>0)
                    where.append(" and ").append(key).append("='"+val+"'");
            }
        }
        QueryData queryData=getServer().queryData(c,where.toString(),index,pageSize);
        return JsonUtil.beanToJson(queryData);
    }


    public ModelAndView add(T aggVO)
    {
        return null;
    }

    public Result save(T aggVO)
    {
        Result result=new Result();
        try {
             AggVO ret=getServer().save(aggVO);
            result.setCode("1");
            result.setData(ret);
            result.setMsg("保存成功");
        } catch (DAOException e) {
            e.printStackTrace();
            result.setCode("0");
            result.setMsg("保存失败");
        }
        return  result;
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
