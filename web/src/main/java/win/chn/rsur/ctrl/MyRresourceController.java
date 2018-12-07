package win.chn.rsur.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import win.chn.rsur.srv.ResourceServer;
import win.chn.rsur.vo.ResourceAggVO;
import win.chn.rsur.vo.UserResourceVO;
import win.pub.ctrl.BaseController;
import win.pub.srv.PubServer;

/**
 * Created by aWin on 2018-12-06.
 */
@Controller
@RequestMapping("chn/myrsur")
public class MyRresourceController extends BaseController<ResourceAggVO> {





    @Override
    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView view=new ModelAndView();
        view.setViewName("chn/rsur/myrsur");
        return view;
    }

    @Override
    @RequestMapping("query")
    @ResponseBody
    public String query(String condition, Integer index, Integer pageSize) {
        return super.queryData(UserResourceVO.class,condition,index,pageSize);
    }

    protected PubServer getServer() {
        return new ResourceServer();
    }
}
