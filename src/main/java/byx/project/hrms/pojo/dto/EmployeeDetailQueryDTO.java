package byx.project.hrms.pojo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * 员工详情查询对象
 *
 * @author byx
 */
@Getter @Setter @ToString
public class EmployeeDetailQueryDTO {
    @NotNull(message = "empNo不能为空")
    private String empNo;
}
