package byx.project.hrms.pojo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * 插入员工传输对象
 *
 * @author byx
 */
@Getter @Setter @ToString
public class EmployeeInsertDTO {
    @NotNull(message = "name不能为空")
    private String name;

    @NotNull(message = "gender不能为空")
    private Integer gender;

    @NotNull(message = "age不能为空")
    private Integer age;

    @NotNull(message = "contact不能为空")
    private String contact;

    @NotNull(message = "deptId不能为空")
    private Integer deptId;

    @NotNull(message = "posId不能为空")
    private Integer posId;

    @NotNull(message = "type不能为空")
    private Integer type;

    @NotNull(message = "desc不能为空")
    private String desc;
}
