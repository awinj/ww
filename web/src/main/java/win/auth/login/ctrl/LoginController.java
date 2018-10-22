package win.auth.login.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import win.auth.login.model.LoginModel;
import win.auth.login.pub.CookieUtil;
import win.auth.login.srv.LoginServer;
import win.pub.vo.BusinessException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by aWin on 2018-09-04.
 */
@Controller
@RequestMapping("auth")
public class LoginController  {

    private LoginServer loginServer=new LoginServer();

    @RequestMapping("login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, @ModelAttribute LoginModel model)
    {
        if("GET".equals(request.getMethod()))
        {
            return new ModelAndView("auth/login");
        }
        else
        {
            try
            {
                int state=loginServer.login(model);

                response.addCookie(CookieUtil.createTicket(model.getUserName()));
                return new ModelAndView("redirect:index");
            }
            catch (BusinessException e)
            {
                model.setMsg(e.getMessage());
                return new ModelAndView("auth/login","model",model);
            }
        }

    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response,String userName)
    {
        Cookie[] cookies = request.getCookies();
        if(cookies!=null&&cookies.length>0)
        {
            for(int i=0;i<cookies.length;i++)
            {
                if(CookieUtil.TICKET.equals(cookies[i].getName()))
                {
                    cookies[i].setValue(null);
                    cookies[i].setMaxAge(0);//立即过期
                    cookies[i].setHttpOnly(true);
                    response.addCookie(cookies[i]);
                }
            }
        }

        return "login";
    }

    @RequestMapping("/index")
    public String index()
    {
        return "index";
    }


}
