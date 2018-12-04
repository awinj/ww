package win.auth.login.ctrl;

import awin.dao.exception.DAOException;
import awin.logger.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import win.auth.login.model.LoginModel;
import win.auth.login.pub.CookieUtil;
import win.auth.login.srv.LoginServer;
import win.auth.power.vo.PowerVO;
import win.pub.util.tree.TreeInitialize;
import win.pub.util.tree.TreeNode;
import win.pub.vo.BusinessException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aWin on 2018-09-04.
 */
@Controller
@RequestMapping("auth")
public class LoginController {

    private LoginServer loginServer = new LoginServer();

    @RequestMapping("login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, @ModelAttribute LoginModel model) {
        //get 表明是初次加载而不是点击登陆
        if ("GET".equals(request.getMethod())) {
            return new ModelAndView("auth/login");
        } else {
            try {
                String pk_user = loginServer.login(model); //返回登陆用户的主键
                HttpSession session = request.getSession();
                session.setAttribute("pk_user", pk_user);
                return new ModelAndView("redirect:user/index");
            } catch (BusinessException e) {
                model.setMsg(e.getMessage());
                return new ModelAndView("auth/login", "model", model);
            }
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, String userName) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (int i = 0; i < cookies.length; i++) {
                if (CookieUtil.TICKET.equals(cookies[i].getName())) {
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
    public String index() {
        return "index";
    }

    /**
     * 菜单栏
     * @return
     */
    @RequestMapping("/nav")
    public ModelAndView nav() {
        try {
            ModelAndView modelAndView = new ModelAndView("pub/nav");

            List<PowerVO> powers = loginServer.getPowerByUser("1");
            TreeInitialize<PowerVO> treeInitialize = new TreeInitialize<PowerVO>();
            List<TreeNode<PowerVO>> ret = treeInitialize.trans2Tree(powers);
            ret = new ArrayList<TreeNode<PowerVO>>();
            PowerVO powerVO = new PowerVO();
            powerVO.setPowerName("wsw");
            TreeNode<PowerVO> node = new TreeNode<PowerVO>(powerVO);
            ret.add(node);
            modelAndView.addObject("navs", ret);
            return modelAndView;
        } catch (DAOException e) {
            Logger.Error(e.getMessage(), e);
            return null;
        }
    }


}
