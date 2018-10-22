package win.auth.login.pub;

import javax.servlet.http.Cookie;

/**
 * Created by aWin on 2018-09-08.
 */
public class CookieUtil {

    //登陸口令
    public static final String TICKET="ticket";

    public static Cookie createTicket(String userName)
    {
        //TODO  username 加密
        Cookie cookie=new Cookie(TICKET,userName);
        cookie.setHttpOnly(true);
        return cookie;
    }

    public static Cookie deleteTicket()
    {
        Cookie cookie=new Cookie(TICKET,"");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        return cookie;
    }

    public static String getUserNameByCookie(Cookie cookie)
    {
        if(cookie==null||!TICKET.equals(cookie.getName()))
        {
            return null;
        }
        String ticket=cookie.getValue();
        //解密
        return ticket;
    }
}
