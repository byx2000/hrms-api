package byx.project.hrms.pojo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 员工详情视图对象
 *
 * @author byx
 */
@Getter @Setter @ToString
public class EmployeeDetailVO {
    private String empNo;
    private String name;
    private Integer gender;
    private Integer age;
    private String deptName;
    private String posName;
    private Integer deptId;
    private Integer posId;
    private String contact;
    private Integer type;
    private String desc;
}
