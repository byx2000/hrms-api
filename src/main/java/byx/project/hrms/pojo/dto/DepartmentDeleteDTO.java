package byx.project.hrms.pojo.dto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * 用于删除部门的数据传输对象
 *
 * @author ztc
 */
@Getter @Setter @ToString
public class DepartmentDeleteDTO {
    @NotNull(message ="deptNo不能为空")
    private String deptNo;
}
