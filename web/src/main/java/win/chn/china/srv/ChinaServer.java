package win.chn.china.srv;

import awin.dao.exception.DAOException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import win.chn.china.vo.ChinaVO;
import win.pub.srv.PubServer;
import win.pub.vo.AggVO;

import java.util.List;

/**
 * Created by aWin on 2018-12-05.
 *
 * @Description:
 */
public class ChinaServer extends PubServer {

    /**
     * 更新陶瓷藏品的系统关键词
     * @param pk_china 主键
     */
    private void updateIndex(String pk_china)
    {
        //对藏品的属性（例：简介）以及关联资源的名称进行分词操作，更新到陶瓷藏品的syskeyword 字段
        //分词请使用 WinSegmenter
        throw new NotImplementedException();
    }

    /**
     * 智能关键词搜索
     * @param text
     * @return 查询结果
     */
    public List<ChinaVO> search(String text)
    {
        //将text分词 使用WinSegmenter类
        //转化为syskeyword like '%%' and syskeyword like '%%' ，数据量过大的话，可以考虑对syskeyword建全文索引
        throw new NotImplementedException();
    }


    @Override
    public AggVO save(AggVO aggVO) throws DAOException {
        //TODO 数据校验
        //如果资源权限类型为付费，则价格必须>0
        //资源内容content必须不为空。
        return super.save(aggVO);
    }
}
