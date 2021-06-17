package byx.project.hrms.pojo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * 查询部门职位员工数量的DTO
 *
 * @author byx
 */
@Getter @Setter @ToString
public class PositionEmployeeCountQueryDTO {
    @NotNull(message = "deptId不能为空")
    private Integer deptId;
}
