package byx.project.hrms.pojo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 最近一周考勤信息列表项
 *
 * @author byx
 */
@Getter @Setter @ToString
public class LatestWeekAttendanceItemVO {
    private String date;
    private String arriveTime;
    private String leaveTime;
}
