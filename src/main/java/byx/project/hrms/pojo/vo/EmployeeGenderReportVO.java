package byx.project.hrms.pojo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 员工性别报表视图对象
 *
 * @author byx
 */
@Getter @Setter @ToString
public class EmployeeGenderReportVO {
    private Integer maleCount;
    private Integer femaleCount;
}
