package byx.project.hrms.service.impl;

import byx.project.hrms.common.Status;
import byx.project.hrms.exception.BizException;
import byx.project.hrms.mapper.UserMapper;
import byx.project.hrms.pojo.dto.LoginDTO;
import byx.project.hrms.pojo.vo.UserVO;
import byx.project.hrms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现类
 *
 * @author byx
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserVO login(LoginDTO dto) {
        UserVO vo = userMapper.get(dto);
        if (vo == null) {
            throw new BizException(Status.LOGIN_ERROR);
        }
        return vo;
    }
}
