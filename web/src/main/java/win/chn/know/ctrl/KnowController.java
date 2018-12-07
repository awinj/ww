package win.chn.know.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import win.chn.know.srv.KnowServer;
import win.chn.know.vo.KnowAggVO;
import win.chn.know.vo.KnowVO;
import win.pub.ctrl.BaseController;
import win.pub.vo.Result;

import java.util.List;

/**
 * Created by aWin on 2018-12-05.
 *
 * @Description:
 */
@Controller
@RequestMapping("chn/know")
public class KnowController extends BaseController<KnowAggVO> {


    @Override
    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView view=new ModelAndView();
        view.setViewName("chn/know/index");
        return view;
    }

    @Override
    @RequestMapping("query")
    @ResponseBody
    public String query(String condition, Integer index, Integer pageSize) {
        return super.queryData(KnowVO.class,condition,index,pageSize);
    }



    @Override
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public Result delete(@RequestBody List<KnowAggVO> aggVOs) {
        return super.delete(aggVOs);
    }

    @Override
    @RequestMapping(value = "save",method = RequestMethod.POST)
    @ResponseBody       //如果不作为ResponseBody的话，则会报404
    public Result save(@RequestBody KnowAggVO aggVO) {
        return super.save(aggVO);
    }
    protected KnowServer getServer() {
        return new KnowServer();
    }
}
