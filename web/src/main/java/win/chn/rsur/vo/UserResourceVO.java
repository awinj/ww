package win.chn.rsur.vo;

import awin.bean.SuperVO;

/**
 * Created by aWin on 2018-12-05.
 *
 * @Description:
 */
public class UserResourceVO extends SuperVO {

    private String pk_user_resource ;
    private String name ;
    private String content ;
    private String endtime ;
    private String pk_resource ;
    private String pk_user ;

    public String getPk_user_resource() {
        return pk_user_resource;
    }

    public void setPk_user_resource(String pk_user_resource) {
        this.pk_user_resource = pk_user_resource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getPk_resource() {
        return pk_resource;
    }

    public void setPk_resource(String pk_resource) {
        this.pk_resource = pk_resource;
    }

    public String getPk_user() {
        return pk_user;
    }

    public void setPk_user(String pk_user) {
        this.pk_user = pk_user;
    }

    public String getTableName() {
        return "chn_user_resource";
    }

    public String getPrimaryKey() {
        return "pk_user_resource";
    }
}
