package win.auth.user.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import win.auth.user.vo.UserVO;
import win.pub.ctrl.BaseController;
import win.pub.vo.AggVO;
import win.pub.vo.QueryData;
import win.pub.vo.Result;

import java.util.List;

/**
 * Created by aWin on 2018-09-05.
 */
@Controller
@RequestMapping("auth/user")
public class UserController extends BaseController {


    @Override
    @RequestMapping("index")
    public ModelAndView index() {
        return super.index();
    }

    @Override
    @RequestMapping(value = "query",produces="text/html; charset=UTF-8")
    @ResponseBody
    public String query(Integer curr,Integer nums   )
    {
        return super.queryData(UserVO.class,curr,nums);
    }



    @Override
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public Result delete(List<String> pks) {
        return super.delete(pks);
    }

    @Override
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public ModelAndView save(AggVO aggVO) {
        return super.save(aggVO);
    }
}
