package win.pst.post.vo;

import win.pub.vo.DocVO;

/**
 * Created by aWin on 2018-12-05.
 *
 * @Description:
 */
public class PostVO extends DocVO {

    private String pk_post ;
    private String title ;
    private String content ;
    private String photo ;
    private String photoposi ;

    public String getPk_post() {
        return pk_post;
    }

    public void setPk_post(String pk_post) {
        this.pk_post = pk_post;
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

    public String getTableName() {
        return "pst_post";
    }

    public String getPrimaryKey() {
        return "pk_post";
    }
}
