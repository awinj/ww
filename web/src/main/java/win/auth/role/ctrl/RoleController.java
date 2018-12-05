package win.auth.role.ctrl;

import awin.logger.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import win.auth.power.vo.PowerMapMeta;
import win.auth.power.vo.PowerVO;
import win.auth.role.srv.RoleServer;
import win.auth.role.vo.RoleAggVO;
import win.auth.role.vo.RoleVO;
import win.pub.ctrl.BaseController;
import win.pub.util.table.TableUtil;
import win.pub.vo.BusinessException;
import win.pub.vo.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by aWin on 2018-11-14.
 */
@Controller
@RequestMapping("auth/role")
public class RoleController extends BaseController<RoleAggVO> {



    @Override
    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView view=new ModelAndView();
        view.setViewName("auth/role/index");
        return view;
    }

    @Override
    @RequestMapping("query")
    @ResponseBody
    public String query(String condition, Integer index, Integer pageSize  )
    {
        return super.queryData(RoleVO.class,condition,index,pageSize);
    }



    @Override
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestBody List<RoleAggVO> aggVOs) {
        return super.delete(aggVOs);
    }

    @Override
    @RequestMapping(value = "save",method = RequestMethod.POST)
    @ResponseBody       //如果不作为ResponseBody的话，则会报404
    public Result save(@RequestBody RoleAggVO aggVO) {
        return super.save(aggVO);
    }

    @RequestMapping("availablePower")
    @ResponseBody
    public String availablePower()
    {
        List<PowerVO> datas=getServer().queryByWhere(PowerVO.class,"dr='N'");
        return new TableUtil().transHtml4Data(datas,new PowerMapMeta());
    }

    @RequestMapping(value = "assign",method = RequestMethod.POST)
    @ResponseBody
    public Result assign(@RequestBody Map<String,Object> map)
    {
        Result result=createResult();
        try {
            getServer().assign((String)map.get("pk_role"),(ArrayList<String>)map.get("powers"));
            result.setMsg("分配成功");
        } catch (BusinessException e) {
            Logger.Error(e.getMessage(),e);
            handle(result,e);
        }
        return result;
    }

    RoleServer server;
    @Override
    protected RoleServer getServer()
    {
        if(server==null)
            server=new RoleServer();
        return server;
    }
}
