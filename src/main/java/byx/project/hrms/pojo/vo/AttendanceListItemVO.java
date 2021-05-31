package byx.project.hrms.pojo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 考勤列表项视图对象
 *
 * @author byx
 */
@Getter @Setter @ToString
public class AttendanceListItemVO {
    private Integer empId;
    private String empNo;
    private String empName;
    private Integer type;
    private String date;
    private String time;
}
