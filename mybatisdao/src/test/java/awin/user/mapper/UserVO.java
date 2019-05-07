package awin.user.mapper;

import awin.orm.annotations.Column;
import awin.orm.annotations.PrimaryKey;
import awin.orm.annotations.Table;

/**
 * Created by aWin on 2019-04-26.
 *
 * @Description:
 */
@Table(tableName = "sm_user")
public class UserVO {

    @PrimaryKey
    private String cuserid;


    @Column(columnName = "user_name")
    private String userName;

    public String getCuserid() {
        return cuserid;
    }

    public void setCuserid(String cuserid) {
        this.cuserid = cuserid;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
