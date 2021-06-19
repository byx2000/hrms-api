package byx.project.hrms.pojo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 部门职位数VO
 *
 * @author byx
 */
@Getter @Setter @ToString
public class DepartmentPositionCountVO {
    private String deptName;
    private Integer posCount;
}
