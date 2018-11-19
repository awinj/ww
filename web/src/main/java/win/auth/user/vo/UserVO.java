package win.auth.user.vo;

import awin.lang.BooleanExt;
import win.pub.vo.DocVO;

import java.math.BigDecimal;

/**
 * Created by aWin on 2018-09-07.
 */
public class UserVO extends DocVO {

    private String pk_user ;
    private String userCode ;
    private String userName ;
    private String password ;
    private BooleanExt isLocked ;
    private String telephone ;
    private String email ;
    private String sex ;
    private String city ;
    private String sign ;
    private BigDecimal score ;




    public String getTableName() {
        return "auth_user";
    }

    public String getPrimaryKey() {
        return "pk_user";
    }


    public String getPk_user() {
        return pk_user;
    }

    public void setPk_user(String pk_user) {
        this.pk_user = pk_user;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

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

    public BooleanExt getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(BooleanExt isLocked) {
        this.isLocked = isLocked;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }
}
