package byx.project.hrms.pojo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * 获取最近一周考勤信息的查询对象
 *
 * @author byx
 */
@Getter @Setter @ToString
public class LatestWeekAttendanceQueryDTO {
    @NotNull(message = "empId不能为空")
    private Integer empId;
}
