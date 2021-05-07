package byx.project.hrms.pojo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 薪资查询对象
 *
 * @author byx
 */
@Getter @Setter @ToString
public class SalaryQueryDTO extends PagingQueryDTO {
    private String time;
    private String empNo;
    private String empName;
    private String orderBy;
    private Boolean isDesc;
}
