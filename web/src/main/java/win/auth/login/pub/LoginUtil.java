package win.auth.login.pub;

import javax.servlet.http.HttpSession;

/**
 * Created by aWin on 2018-11-14.
 */
public class LoginUtil {

    private static HttpSession session;

    public static void setSession(HttpSession session)
    {
        LoginUtil.session=session;
    }

    public static String getUserID()
    {
        Object obj=session.getAttribute("pk_user");
        if(obj!=null)
            return obj.toString();
        else
            return null;
    }

//    public static void setUserID(String pk_user)
//    {
//        LoginUtil.pk_user=pk_user;
//    }

}
