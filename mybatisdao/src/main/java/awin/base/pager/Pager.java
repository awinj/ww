package awin.base.pager;

/**
 * Created by aWin on 2019-05-05.
 *
 * @Description:
 */
public class Pager {

    /**
     * 默认pageIndex=1，pageSize=10
     */
    public Pager(){
        this(1,10);
    }

    /**
     *
     * @param pageIndex 页码  >==1
     * @param pageSize 每页数量
     */
    public Pager(int pageIndex,int pageSize)
    {
        this.pageIndex=pageIndex;
        this.pageSize=pageSize;
    }

    private int pageSize;

    private int pageIndex;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    /**
     *
     * @param pageIndex  页码  >==1
     */
    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }
}
