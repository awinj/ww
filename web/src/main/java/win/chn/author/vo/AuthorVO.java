package win.chn.author.vo;

import awin.bean.SuperVO;
import awin.lang.BooleanExt;
import win.pub.vo.DocVO;

/**
 * Created by aWin on 2018-12-04.
 *
 * @Description:
 */
public class AuthorVO extends DocVO {

    private String pk_author ;
    private String name ;
    private String record ;
    private String address ;
    private String cantact ;
    private String url ;
    private String email ;


    public String getPk_author() {
        return pk_author;
    }

    public void setPk_author(String pk_author) {
        this.pk_author = pk_author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCantact() {
        return cantact;
    }

    public void setCantact(String cantact) {
        this.cantact = cantact;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTableName() {
        return "chn_author";
    }

    public String getPrimaryKey() {
        return "pk_author";
    }
}
