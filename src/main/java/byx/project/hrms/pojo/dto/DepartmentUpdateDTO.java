package byx.project.hrms.pojo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * 用于更新部门的数据传输对象
 *
 * @author ztc
 */
@Getter @Setter @ToString
public class DepartmentUpdateDTO {
    @NotNull(message = "deptNo不能为空")
    private String deptNo;
    private String name;
    private String managerEmpNo;
    private String desc;
}
