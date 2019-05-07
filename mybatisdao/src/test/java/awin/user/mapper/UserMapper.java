package awin.user.mapper;

import awin.base.mapper.BaseMapper;

/**
 * Created by aWin on 2019-04-26.
 *
 * @Description:
 */
public interface UserMapper extends BaseMapper<UserVO> {

    UserVO selectByPrimaryKey(String pk);


}
