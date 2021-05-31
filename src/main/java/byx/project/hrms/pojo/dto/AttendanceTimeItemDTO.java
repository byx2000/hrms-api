package byx.project.hrms.pojo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 考勤时间列表项
 *
 * @author byx
 */
@Getter @Setter @ToString
public class AttendanceTimeItemDTO {
    private String date;
    private String time;
}
