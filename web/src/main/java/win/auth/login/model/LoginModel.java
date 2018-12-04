package win.auth.login.model;

import win.pub.vo.BusinessException;

/**
 * Created by aWin on 2018-09-07.
 * 登陆模型
 */
public class LoginModel {

    private String userName;

    private String password;

    private String msg;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean validate() throws BusinessException {
        if(this.userName==null||this.userName.length()<=0)
            throw new BusinessException("用户名不能为空");
        if(this.password==null||this.password.length()<=0)
            throw new BusinessException("密码不能为空");
        return true;
    }
}
