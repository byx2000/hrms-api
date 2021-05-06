package byx.project.hrms.pojo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * 用于更新员工的数据传输对象
 *
 * @author byx
 */
@Getter @Setter @ToString
public class EmployeeUpdateDTO {
    @NotNull(message = "empNo不能为空")
    private String empNo;

    private String name;
    private Integer gender;
    private Integer age;
    private String contact;
    private Integer deptId;
    private Integer posId;
    private Integer type;
    private String desc;
}
