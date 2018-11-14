package win.auth.login.filter;

import org.springframework.web.filter.OncePerRequestFilter;
import win.auth.login.pub.CookieUtil;
import win.auth.login.pub.LoginUtil;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by aWin on 2018-09-04.
 */
public class LoginFilter extends OncePerRequestFilter {

    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
//        filterChain.doFilter(httpServletRequest,httpServletResponse);
        String[] notFilter = new String[] { "login","static","css","js"};
        String uri = httpServletRequest.getRequestURI();
        boolean doFilter = true;
        for (String s : notFilter) {
            if (uri.indexOf(s) != -1) {
                // 如果uri中包含不过滤的uri,则不进行过滤
                doFilter = false;
                break;
            }
        }
        if(doFilter)
        {
//            Cookie[] cookies = httpServletRequest.getCookies();

            HttpSession session=httpServletRequest.getSession();
//            if(cookies!=null&&cookies.length>0)
//            {
//                for(int i=0;i<cookies.length;i++)
//                {
//                    if(CookieUtil.TICKET.equals(cookies[i].getName()))
//                    {
//                        userName= CookieUtil.getUserNameByCookie(cookies[i]);
//                    }
//                }
//            }
            LoginUtil.setSession(session);
            String pk_user=LoginUtil.getUserID();
            if(LoginUtil.getUserID()==null||pk_user.length()<=0)
            {
                httpServletResponse.sendRedirect("/ww/auth/login");
            }
            else
            {
                filterChain.doFilter(httpServletRequest,httpServletResponse);
            }
        }
        else
        {
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }

    }
}
