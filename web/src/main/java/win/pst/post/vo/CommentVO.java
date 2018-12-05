package win.pst.post.vo;

import win.pub.vo.DocVO;

/**
 * Created by aWin on 2018-12-05.
 *
 * @Description:
 */
public class CommentVO extends DocVO {

    private String pk_comment ;
    private String title ;
    private String content ;
    private String photo ;
    private String photoposi ;
    private String pk_parent ;
    private String route ;

    public String getPk_comment() {
        return pk_comment;
    }

    public void setPk_comment(String pk_comment) {
        this.pk_comment = pk_comment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhotoposi() {
        return photoposi;
    }

    public void setPhotoposi(String photoposi) {
        this.photoposi = photoposi;
    }

    public String getPk_parent() {
        return pk_parent;
    }

    public void setPk_parent(String pk_parent) {
        this.pk_parent = pk_parent;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getTableName() {
        return "pst_comment";
    }

    public String getPrimaryKey() {
        return "pk_comment";
    }
}
