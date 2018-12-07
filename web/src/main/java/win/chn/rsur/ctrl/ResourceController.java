package win.chn.rsur.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import win.chn.rsur.srv.ResourceServer;
import win.chn.rsur.vo.ResourceAggVO;
import win.chn.rsur.vo.ResourceVO;
import win.pub.ctrl.BaseController;
import win.pub.vo.Result;

import java.util.List;

/**
 * Created by aWin on 2018-12-05.
 *
 * @Description:
 */
@Controller
@RequestMapping("chn/rsur")
public class ResourceController extends BaseController<ResourceAggVO> {



    @Override
    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView view=new ModelAndView();
        view.setViewName("chn/rsur/index");
        return view;
    }

    @Override
    @RequestMapping("query")
    @ResponseBody
    public String query(String condition, Integer index, Integer pageSize) {
        return super.queryData(ResourceVO.class,condition,index,pageSize);
    }



    @Override
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public Result delete(@RequestBody List<ResourceAggVO> aggVOs) {
        return super.delete(aggVOs);
    }

    @Override
    @RequestMapping(value = "save",method = RequestMethod.POST)
    @ResponseBody       //如果不作为ResponseBody的话，则会报404
    public Result save(@RequestBody ResourceAggVO aggVO) {
        return super.save(aggVO);
    }

    protected ResourceServer getServer() {
        return new ResourceServer();
    }
}
