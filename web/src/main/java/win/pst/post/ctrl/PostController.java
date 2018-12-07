package win.pst.post.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import win.pst.post.srv.PostServer;
import win.pst.post.vo.PostAggVO;
import win.pst.post.vo.PostVO;
import win.pub.ctrl.BaseController;
import win.pub.vo.Result;

import java.util.List;

/**
 * Created by aWin on 2018-12-05.
 *
 * @Description:
 */
@Controller
@RequestMapping("pst/post")
public class PostController extends BaseController<PostAggVO> {



    @Override
    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView view=new ModelAndView();
        view.setViewName("pst/post/index");
        return view;
    }

    @Override
    @RequestMapping("query")
    @ResponseBody
    public String query(String condition, Integer index, Integer pageSize) {
        return super.queryData(PostVO.class,condition,index,pageSize);
    }


    @Override
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public Result delete(@RequestBody List<PostAggVO> aggVOs) {
        return super.delete(aggVOs);
    }

    @Override
    @RequestMapping(value = "save",method = RequestMethod.POST)
    @ResponseBody       //如果不作为ResponseBody的话，则会报404
    public Result save(@RequestBody PostAggVO aggVO) {
        return super.save(aggVO);
    }

    protected PostServer getServer() {
        return new PostServer();
    }
}
