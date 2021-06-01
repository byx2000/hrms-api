package byx.project.hrms.pojo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class PositionInsertDTO {
    @NotNull(message = "name不能为空")
    private String name;

    @NotNull(message = "desc不能为空")
    private String desc;

    @NotNull(message = "deptId不能为空")
    private Integer deptId;
}
