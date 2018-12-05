package win.chn.know.vo;

import win.pub.vo.DocVO;

import java.math.BigDecimal;

/**
 * Created by aWin on 2018-12-05.
 *
 * @Description:
 */
public class KnowVO extends DocVO {

    private String pk_know ;
    private String title ;
    private String code ;
    private String pk_author ;
    private String kilneye ;
    private String times ;
    private String model ;
    private String journalnum ;
    private String memo ;
    private String keyword ;
    private String syskeyword ;
    private BigDecimal price ;

    public String getPk_know() {
        return pk_know;
    }

    public void setPk_know(String pk_know) {
        this.pk_know = pk_know;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPk_author() {
        return pk_author;
    }

    public void setPk_author(String pk_author) {
        this.pk_author = pk_author;
    }

    public String getKilneye() {
        return kilneye;
    }

    public void setKilneye(String kilneye) {
        this.kilneye = kilneye;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getJournalnum() {
        return journalnum;
    }

    public void setJournalnum(String journalnum) {
        this.journalnum = journalnum;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getSyskeyword() {
        return syskeyword;
    }

    public void setSyskeyword(String syskeyword) {
        this.syskeyword = syskeyword;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTableName() {
        return "chn_know";
    }

    public String getPrimaryKey() {
        return "pk_know";
    }
}
