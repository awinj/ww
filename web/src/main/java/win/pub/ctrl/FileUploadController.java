package win.pub.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import win.pub.vo.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * Created by aWin on 2018-12-04.
 *
 * @Description:
 */
@Controller
@RequestMapping("file")
public class FileUploadController {

    @RequestMapping(value = "upload",method = RequestMethod.POST)
    public Result upload(MultipartFile file, HttpServletRequest request) throws IOException {
         String path =request.getSession().getServletContext().getRealPath("/"); //服务器地址
        if (!file.isEmpty()) {
            // 文件保存路径
            String filePath = path + file.getOriginalFilename();
            // 转存文件

            file.transferTo(new File(filePath));
        }
        return null;
    }
}
