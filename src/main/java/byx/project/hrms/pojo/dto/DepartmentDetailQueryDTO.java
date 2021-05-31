package byx.project.hrms.pojo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * 部门详情查询对象
 *
 * @author ztc
 */
@Getter @Setter @ToString
public class DepartmentDetailQueryDTO {
    @NotNull(message = "deptNo不能为空")
    private String deptNo;
}
