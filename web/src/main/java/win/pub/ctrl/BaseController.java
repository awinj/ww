package win.pub.ctrl;


import awin.bean.SuperVO;
import awin.dao.exception.DAOException;
import awin.logger.Logger;
import awin.util.parse.JsonUtil;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;
import win.pub.srv.PubServer;
import win.pub.vo.AggVO;
import win.pub.vo.BusinessException;
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
        view.setViewName("index");
        return view;
    }
    public abstract String query(String condition, Integer curr, Integer nums  );

    public <T extends SuperVO> String  queryData(Class<T> c,String condition, Integer index ,Integer pageSize)
    {
        // 将查询条件组装放到dao层，并参数化，防止sql注入
        Map<String,Object> con= JsonUtil.jsonToBean(condition, HashMap.class);
        QueryData queryData= null;
        try {
            queryData = getServer().queryData(c,con,index,pageSize);
        } catch (BusinessException e) {
            throw new RuntimeException("数据查询异常");
        }
        return JsonUtil.beanToJson(queryData);
    }


    public ModelAndView add(T aggVO)
    {
        return null;
    }

    public Result save(T aggVO)
    {
        Result result=createResult();
        try {
             AggVO ret=getServer().save(aggVO);
            result.setCode("1");
            result.setData(ret);
            result.setMsg("保存成功");
        } catch (DAOException e) {
            handle(result,e);
        }
        return  result;
    }

    public Result delete(List<T> aggVOs)
    {
        Result result=createResult();
        try {
            for (T aggVO : aggVOs)
            {
                getServer().delete(aggVO);
            }
            result.setMsg("删除成功");
        } catch (DAOException e) {
            Logger.Error(e.getMessage(),e);
            handle(result,e);
        }

        return result;
    }


    protected Result handle(Result result,Exception e)
    {
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
    protected PubServer getServer()
    {
        if(server==null)
            server=new PubServer();
        return server;
    }
}
