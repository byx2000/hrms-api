package byx.project.hrms.pojo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * 插入薪资数据传输对象
 *
 * @author byx
 */
@Getter @Setter @ToString
public class SalaryInsertDTO {
    @NotNull(message = "empId不能为空")
    private Integer empId;

    @NotNull(message = "salary不能为空")
    private Integer salary;

    private String time;
}
