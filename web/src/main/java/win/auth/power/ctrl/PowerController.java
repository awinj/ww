package win.auth.power.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import win.auth.power.srv.PowerServer;
import win.auth.power.vo.PowerAggVO;
import win.auth.power.vo.PowerMapMeta;
import win.auth.power.vo.PowerVO;
import win.auth.role.srv.RoleServer;
import win.auth.user.vo.UserVO;
import win.pub.ctrl.BaseController;
import win.pub.util.table.TableUtil;
import win.pub.vo.Result;

import java.util.List;

/**
 * Created by aWin on 2018-11-14.
 */
@Controller
@RequestMapping("auth/power")
public class PowerController extends BaseController<PowerAggVO> {



    @Override
    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView view=new ModelAndView();
        view.setViewName("auth/power/index");
        return view;
    }

    @Override
    @RequestMapping("query")
    @ResponseBody
    public String query(String condition, Integer index, Integer pageSize  )
    {
        return super.queryData(PowerVO.class,condition,index,pageSize);
    }



    @Override
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public Result delete(@RequestBody List<PowerAggVO> aggVOs) {
        return super.delete(aggVOs);
    }

    @Override
    @RequestMapping(value = "save",method = RequestMethod.POST)
    @ResponseBody       //如果不作为ResponseBody的话，则会报404
    public Result save(@RequestBody PowerAggVO aggVO) {
        return super.save(aggVO);
    }


    @RequestMapping("availablePower")
    @ResponseBody
    public String availablePower()
    {
        List<PowerVO> datas=getServer().queryByWhere(PowerVO.class,"dr='N'");
        return new TableUtil().transHtml4Data(datas,new PowerMapMeta());
    }
    PowerServer server;
    @Override
    protected PowerServer getServer()
    {
        if(server==null)
            server=new PowerServer();
        return server;
    }
}
