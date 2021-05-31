package byx.project.hrms.pojo.dto;

import lombok.*;
/**
 * 部门列表查询对象
 *
 * @author byx ztc
 */
@Getter @Setter @ToString
public class DepartmentListQueryDTO extends PagingQueryDTO{
    private String deptNo;
    private String name;
    private String managerName;
    private String managerEmpNo;
}
