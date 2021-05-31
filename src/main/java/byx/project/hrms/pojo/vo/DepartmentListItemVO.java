package byx.project.hrms.pojo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 部门列表项视图对象
 *
 * @author ztc
 */
@Getter @Setter @ToString
public class DepartmentListItemVO {
    private String deptNo;
    private String name;
    private String managerName;
    private String managerEmpNo;
    private String managerContact;
}
