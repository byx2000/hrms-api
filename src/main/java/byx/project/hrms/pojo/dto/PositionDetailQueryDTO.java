package byx.project.hrms.pojo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * 职位详情查询对象
 * @author Jiang Yinzuo
 */
@Getter
@Setter
@ToString
public class PositionDetailQueryDTO {
    @NotNull(message = "posNo不能为空")
    private String posNo;
}
