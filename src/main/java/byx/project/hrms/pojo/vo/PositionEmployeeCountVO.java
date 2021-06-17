package byx.project.hrms.pojo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 部门员工数量VO
 *
 * @author byx
 */
@Getter @Setter @ToString
public class PositionEmployeeCountVO {
    private String posName;
    private Integer empCount;
}
