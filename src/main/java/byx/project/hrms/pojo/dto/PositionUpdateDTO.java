package byx.project.hrms.pojo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class PositionUpdateDTO {
    @NotNull(message = "posNo不能为空")
    private String posNo;

    private String name;
    private String desc;
    private Integer deptId;
}
