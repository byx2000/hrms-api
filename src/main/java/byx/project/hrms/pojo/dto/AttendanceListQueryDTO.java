package byx.project.hrms.pojo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * 考勤列表查询对象
 *
 * @author byx
 */
@Getter @Setter @ToString
public class AttendanceListQueryDTO extends PagingQueryDTO {
    @NotNull(message = "date不能为空")
    private String date;

    private String empNo;
    private String empName;

    /**
     * 0为全部，1为迟到，2为早退
     */
    @NotNull(message = "type不能为空")
    private Integer type;
}
