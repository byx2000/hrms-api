package byx.project.hrms.pojo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 员工类型报表视图对象
 *
 * @author byx
 */
@Getter @Setter @ToString
public class EmployeeTypeReportVO {
    private Integer internCount;
    private Integer fullTimeCount;
}
