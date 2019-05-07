package awin.user.mapper;

import awin.base.pager.Pager;
import awin.user.mapper.UserMapper;
import awin.user.mapper.UserVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aWin on 2019-04-26.
 *
 * @Description:
 */
public class UserMppperTests {
    private static SqlSessionFactory sqlSessionFactory;

    @Test
    public void testQueryBuPk(){
        UserVO vo=getMapper().queryByPk("0001A11000000000043Q");
        System.out.print(vo);
    }

    @Test
    public void testQueryByPager(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("cuserid","1");
        map.put("user_name","2");
        List<UserVO> vos=getMapper().queryByPager(map,new Pager());

    }

    @Test
    public void testSelectByPrimaryKey(){
        UserVO vo=getMapper().selectByPrimaryKey("0001A11000000000043Q");
        System.out.print(vo);
    }

    UserMapper userMapper;
    private UserMapper getMapper()
    {
        if(userMapper==null)
        {
            Reader reader = null;
            try {
                reader = Resources.getResourceAsReader("mybatis-config.xml");
            } catch (IOException e) {
                e.printStackTrace();
            }
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

            SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
            userMapper = sqlSession.getMapper(UserMapper.class);
        }
        return userMapper;
    }

}
