package win.auth.user.ctrl;

import awin.logger.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import win.auth.login.pub.LoginUtil;
import win.auth.user.srv.UserServer;
import win.auth.user.vo.UserAggVO;
import win.auth.user.vo.UserVO;
import win.pub.ctrl.BaseController;
import win.pub.vo.AggVO;
import win.pub.vo.BusinessException;
import win.pub.vo.QueryData;
import win.pub.vo.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aWin on 2018-09-05.
 */
@Controller
@RequestMapping("auth/user")
public class UserController extends BaseController<UserAggVO> {


    @Override
    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView view=new ModelAndView();
        view.setViewName("auth/user/index");
        return view;
    }

    @Override
    @RequestMapping("query")
    @ResponseBody
    public String query(String condition, Integer index, Integer pageSize  )
    {
        return super.queryData(UserVO.class,condition,index,pageSize);
    }



    @Override
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public Result delete(@RequestBody List<UserAggVO> aggVOs) {
        return super.delete(aggVOs);
    }

    @Override
    @RequestMapping(value = "save",method = RequestMethod.POST)
    @ResponseBody       //如果不作为ResponseBody的话，则会报404
    public Result save(@RequestBody UserAggVO aggVO) {
        return super.save(aggVO);
    }


    @RequestMapping(value = "assign",method = RequestMethod.POST)
    @ResponseBody
    public Result assign(@RequestBody Map<String,Object> map)
    {
        Result result=createResult();
        try {
            getServer().assign((String)map.get("pk_user"),(ArrayList<String>)map.get("roles"));
        } catch (BusinessException e) {
            Logger.Error(e.getMessage(),e);
            handle(result,e);
        }
        return result;
    }


    UserServer server;
    @Override
    protected UserServer getServer()
    {
        if(server==null)
            server=new UserServer();
        return server;
    }
}
