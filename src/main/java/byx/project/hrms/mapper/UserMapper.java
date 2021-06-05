package byx.project.hrms.mapper;

import byx.project.hrms.pojo.dto.LoginDTO;
import byx.project.hrms.pojo.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 用户数据访问接口
 *
 * @author byx
 */
@Mapper
public interface UserMapper {
    /**
     * 根据用户名和密码获取用户
     */
    @Select("SELECT * FROM user WHERE username = #{username} AND password = #{password}")
    UserVO get(LoginDTO dto);
}
