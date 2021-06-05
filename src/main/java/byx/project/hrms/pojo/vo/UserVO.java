package byx.project.hrms.pojo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户实体类
 *
 * @author byx
 */
@Getter @Setter @ToString
public class UserVO {
    private Integer id;
    private String username;
    private String password;
}
