package win.chn.rsur.vo;

import win.pub.vo.DocVO;

import java.math.BigDecimal;

/**
 * Created by aWin on 2018-12-05.
 *
 * @Description:
 */
public class ResourceVO extends DocVO {

    private String pk_resource ;
    private String permtype ;
    private String secourcetype ;
    private String title ;
    private String content ;
    private BigDecimal price ;
    private Integer orderno ;
    private String billtype ;
    private String pk_china ;
    private String pk_know ;

    public String getPk_resource() {
        return pk_resource;
    }

    public void setPk_resource(String pk_resource) {
        this.pk_resource = pk_resource;
    }

    public String getPermtype() {
        return permtype;
    }

    public void setPermtype(String permtype) {
        this.permtype = permtype;
    }

    public String getSecourcetype() {
        return secourcetype;
    }

    public void setSecourcetype(String secourcetype) {
        this.secourcetype = secourcetype;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getOrderno() {
        return orderno;
    }

    public void setOrderno(Integer orderno) {
        this.orderno = orderno;
    }

    public String getBilltype() {
        return billtype;
    }

    public void setBilltype(String billtype) {
        this.billtype = billtype;
    }

    public String getPk_china() {
        return pk_china;
    }

    public void setPk_china(String pk_china) {
        this.pk_china = pk_china;
    }

    public String getPk_know() {
        return pk_know;
    }

    public void setPk_know(String pk_know) {
        this.pk_know = pk_know;
    }

    public String getTableName() {
        return "chn_resource";
    }

    public String getPrimaryKey() {
        return "pk_resource";
    }
}
