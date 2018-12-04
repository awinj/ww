package win.chn.author.vo;

import awin.bean.SuperVO;

/**
 * Created by aWin on 2018-12-04.
 *
 * @Description:
 */
public class AuthorVO extends SuperVO {
    public String getTableName() {
        return "chn_author";
    }

    public String getPrimaryKey() {
        return "pk_author";
    }
}
