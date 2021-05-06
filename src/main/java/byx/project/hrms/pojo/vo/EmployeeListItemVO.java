package byx.project.hrms.pojo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 员工列表项视图对象
 *
 * @author byx
 */
@Getter @Setter @ToString
public class EmployeeListItemVO {
    private String empNo;
    private String name;
    private String deptName;
    private String posName;
    private Integer type;
    private String contact;
}
