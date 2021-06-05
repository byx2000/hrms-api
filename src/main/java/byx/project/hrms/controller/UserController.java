package byx.project.hrms.controller;

import byx.project.hrms.common.Result;
import byx.project.hrms.common.Status;
import byx.project.hrms.exception.BizException;
import byx.project.hrms.pojo.dto.LoginDTO;
import byx.project.hrms.pojo.vo.UserVO;
import byx.project.hrms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 用户控制器
 *
 * @author byx
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private final static String CURRENT_USER_KEY = "currentUser";

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    /**
     * 登录
     */
    @PostMapping("/login")
    public Result<UserVO> login(@RequestBody @Validated LoginDTO dto) {
        UserVO vo = userService.login(dto);
        session.setAttribute(CURRENT_USER_KEY, vo);
        return Result.success(vo);
    }

    /**
     * 获取当前用户
     */
    @PostMapping("/current")
    public Result<UserVO> current() {
        UserVO vo = (UserVO) session.getAttribute(CURRENT_USER_KEY);
        if (vo != null) {
            return Result.success(vo);
        }
        throw new BizException(Status.NOT_LOGIN_ERROR);
    }

    /**
     * 注销
     */
    @PostMapping("/logout")
    public Result<?> logout() {
        UserVO vo = (UserVO) session.getAttribute(CURRENT_USER_KEY);
        if (vo == null) {
            throw new BizException(Status.NOT_LOGIN_ERROR);
        }
        session.removeAttribute(CURRENT_USER_KEY);
        return Result.success();
    }
}
