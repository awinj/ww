package awin.base.mapper;

import awin.base.pager.Pager;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

/**
 * Created by aWin on 2019-03-29.
 *
 * @Description:
 */
public interface BaseMapper<T> {

    @SelectProvider(type = SQLProvider.class, method = "queryByPk")
    T queryByPk(String pk);

    @SelectProvider(type = SQLProvider.class, method = "queryByPager")
    List<T> queryByPager(@Param("condition") Map<String,Object> condition, Pager pager);

    int insert(T vo);
    int insert(T[] vo);

    int update(T vo);
    int update(T[] vo);

    int delete(T vo);
    int delete(T[] vo);


    int deleteByPk(String pk);
    int deleteByPks(String[] pks);


}
