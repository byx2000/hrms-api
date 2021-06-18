package byx.project.hrms.pojo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 考勤报表视图对象
 *
 * @author byx
 */
@Getter @Setter @ToString
public class AttendanceReportVO {
    private String date;
    private Integer normalCount;
    private Integer arriveLateCount;
    private Integer leaveEarlyCount;
}
