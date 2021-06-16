package byx.project.hrms.pojo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 员工年龄报表视图对象
 *
 * @author byx
 */
@Getter @Setter @ToString
public class EmployeeAgeReportVO {
    private List<String> labels;
    private List<Integer> values;
}
