package awin.orm.annotations;

import awin.entity.reflect.EntityInfo;
import awin.entity.reflect.ReflectUtil;
import awin.user.mapper.UserVO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by aWin on 2019-05-07.
 *
 * @Description:
 */
public class ReflectTests {

    @Test
    public void testReflect()
    {
        EntityInfo info=ReflectUtil.getInstance().getEntityInfo(UserVO.class);
        assertEquals("sm_user",info.getTableName());
        assertEquals("cuserid",info.getPrimaryKey());

    }
}
