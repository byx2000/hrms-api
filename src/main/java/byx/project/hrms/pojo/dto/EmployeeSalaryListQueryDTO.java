package byx.project.hrms.pojo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * 员工薪资列表查询对象
 *
 * @author byx
 */
@Getter @Setter @ToString
public class EmployeeSalaryListQueryDTO {
    @NotNull(message = "empId不能为空")
    private Integer empId;
}
