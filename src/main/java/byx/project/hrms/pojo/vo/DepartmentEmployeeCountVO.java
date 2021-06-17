package byx.project.hrms.pojo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 部门员工人数视图对象
 *
 * @author byx
 */
@Getter @Setter @ToString
public class DepartmentEmployeeCountVO {
    private String deptName;
    private Integer empCount;
}
