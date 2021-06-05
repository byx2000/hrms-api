package byx.project.hrms.service;

import byx.project.hrms.pojo.dto.LoginDTO;
import byx.project.hrms.pojo.vo.UserVO;

/**
 * 用户服务接口
 *
 * @author byx
 */
public interface UserService {
    /**
     * 登录
     */
    UserVO login(LoginDTO dto);
}
