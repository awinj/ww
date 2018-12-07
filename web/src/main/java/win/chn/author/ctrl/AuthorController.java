package win.chn.author.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import win.chn.author.srv.AuthorServer;
import win.chn.author.vo.AuthorAggVO;
import win.chn.author.vo.AuthorVO;
import win.pub.ctrl.BaseController;
import win.pub.vo.Result;

import java.util.List;

/**
 * Created by aWin on 2018-12-04.
 *
 * @Description:
 */
@Controller
@RequestMapping("chn/author")
public class AuthorController extends BaseController<AuthorAggVO> {


    @Override
    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView view=new ModelAndView();
        view.setViewName("chn/author/index");
        return view;
    }

    @Override
    @RequestMapping("query")
    @ResponseBody
    public String query(String condition, Integer index, Integer pageSize ) {
        return super.queryData(AuthorVO.class,condition,index,pageSize);
    }


    @Override
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public Result delete(@RequestBody List<AuthorAggVO> aggVOs) {
        return super.delete(aggVOs);
    }

    @Override
    @RequestMapping(value = "save",method = RequestMethod.POST)
    @ResponseBody       //如果不作为ResponseBody的话，则会报404
    public Result save(@RequestBody AuthorAggVO aggVO) {
        return super.save(aggVO);
    }



    @Override
    protected AuthorServer getServer()
    {
        return new AuthorServer();
    }
}
