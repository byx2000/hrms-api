package byx.project.hrms.pojo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * 职位下拉选项查询对象
 *
 * @author byx
 */
@Getter @Setter @ToString
public class PositionSelectQueryDTO {
    @NotNull(message = "deptId不能为空")
    private Integer deptId;
}
