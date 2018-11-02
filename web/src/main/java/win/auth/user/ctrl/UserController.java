package win.auth.user.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import win.auth.user.vo.UserVO;
import win.pub.ctrl.BaseController;
import win.pub.util.JsonUtil;
import win.pub.vo.AggVO;
import win.pub.vo.QueryData;
import win.pub.vo.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aWin on 2018-09-05.
 */
@Controller
@RequestMapping("auth/user")
public class UserController extends BaseController {

    private static String whereStr;//存储查询条件，以便点击下一页时能根据查询条件分页

    @Override
    @RequestMapping("index")
    public ModelAndView index() {
        return super.index();
    }

    @Override
    @RequestMapping("query")
    @ResponseBody
    public String query(String condition, Integer index, Integer pageSize  )
    {

        return super.queryData(UserVO.class,whereStr,index,pageSize);
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
