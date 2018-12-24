package win.chn.china.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import win.chn.china.srv.ChinaServer;
import win.chn.china.vo.ChinaAggVO;
import win.chn.china.vo.ChinaVO;
import win.pub.ctrl.BaseController;
import win.pub.vo.Result;

import java.util.List;

/**
 * Created by aWin on 2018-12-05.
 *
 * @Description:
 */
@Controller
@RequestMapping("chn/china")
public class ChinaController extends BaseController<ChinaAggVO> {


    @Override
    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView view=new ModelAndView();
        view.setViewName("chn/china/index");
        return view;
    }

    @Override
    @RequestMapping("query")
    @ResponseBody
    public String query(String condition, Integer index, Integer pageSize) {
        return super.queryData(ChinaVO.class,condition,index,pageSize);
    }


    @Override
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestBody List<ChinaAggVO> aggVOs) {
        return super.delete(aggVOs);
    }

    @Override
    @RequestMapping(value = "save",method = RequestMethod.POST)
    @ResponseBody       //如果不作为ResponseBody的话，则会报404
    public Result save(@RequestBody ChinaAggVO aggVO) {
        return super.save(aggVO);
    }

    @RequestMapping("chinarsur")
    public ModelAndView chinarsus(String pk_china)
    {
        ModelAndView view=new ModelAndView();
        view.setViewName("chn/china/chinarsur");
        return view;
    }

    protected ChinaServer getServer() {
        return new ChinaServer();
    }
}
