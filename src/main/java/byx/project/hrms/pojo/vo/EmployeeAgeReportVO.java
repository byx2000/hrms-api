package byx.project.hrms.pojo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 员工年龄报表视图对象
 *
 * @author byx
 */
@Getter @Setter @ToString
public class EmployeeAgeReportVO {
    private String label;
    private Integer maleCount;
    private Integer femaleCount;
}
