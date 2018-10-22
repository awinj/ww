package win.pub.model;

/**
 * Created by aWin on 2018-09-07.
 */
public class PageModel {

    private int nowIndex;

    private int pageCounts;

//    private int goIndex;

    private int pageSize=10;

    public int getNowIndex() {
        return nowIndex;
    }

    public void setNowIndex(int nowIndex) {
        this.nowIndex = nowIndex;
    }

    public int getPageCounts() {
        return pageCounts;
    }

    public void setPageCounts(int pageCounts) {
        this.pageCounts = pageCounts;
    }

//    public int getGoIndex() {
//        return goIndex;
//    }

//    public void setGoIndex(int goIndex) {
//        this.goIndex = goIndex;
//    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
