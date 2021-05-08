package byx.project.hrms.pojo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 薪资列表项视图对象
 *
 * @author byx
 */
@Getter @Setter @ToString
public class SalaryItemVO {
    private Integer empId;
    private String empNo;
    private String empName;
    private Integer salary;
    private String time;
    private String deptName;
}