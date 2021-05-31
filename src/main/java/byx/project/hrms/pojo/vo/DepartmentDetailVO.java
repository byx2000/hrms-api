package byx.project.hrms.pojo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 部门详情视图对象
 *
 * @author ztc
 */
@Getter @Setter @ToString
public class DepartmentDetailVO {
    private String deptNo;
    private String name;
    private String desc;
    private String managerName;
    private String managerEmpNo;
    private String managerContact;
    private List<PositionSelectItemVO> posList;
}
