package win.pub.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import win.pub.vo.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by aWin on 2018-12-04.
 *
 * @Description:
 */
@Controller
@RequestMapping("file")
public class FileUploadController {

    @RequestMapping(value = "upload",method = RequestMethod.POST)
    public Result upload(HttpServletRequest request, HttpServletResponse response)
    {
        return null;
    }
}
