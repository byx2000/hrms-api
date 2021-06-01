package byx.project.hrms.pojo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class PositionDeleteDTO {
    @NotNull(message = "posNo不能为空")
    private String posNo;
}
