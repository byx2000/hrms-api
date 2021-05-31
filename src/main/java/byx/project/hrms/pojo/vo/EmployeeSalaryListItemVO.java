package byx.project.hrms.pojo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 员工薪资列表项视图对象
 *
 * @author byx
 */
@Getter @Setter
@ToString
public class EmployeeSalaryListItemVO {
    private Integer salary;
    private String time;
}
