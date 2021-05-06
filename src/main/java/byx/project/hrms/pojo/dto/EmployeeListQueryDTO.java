package byx.project.hrms.pojo.dto;

import lombok.*;

/**
 * 员工列表查询对象
 *
 * @author byx
 */
@Getter @Setter @ToString
public class EmployeeListQueryDTO extends PagingQueryDTO {
    private String empNo;
    private String name;
    private String deptName;
    private String posName;
    private Integer type;
}
