package byx.project.hrms.pojo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 薪资列表项视图对象
 *
 * @author byx
 */
@Getter @Setter @ToString
public class SalaryItemVO {
    private String empNo;
    private String empName;
    private Integer salary;
    private String time;
}

/*
SELECT e.empNo AS empNo, e.name AS empName, s.salary AS salary, t.time AS time
FROM (SELECT empId AS empId, MAX(time) AS time FROM salary WHERE time <= '2020-08-16' GROUP BY empId) t
JOIN employee e ON t.empId = e.id
JOIN salary s ON s.empId = t.empId AND s.time = t.time
WHERE e.empNo LIKE '%12%'
AND e.name LIKE '%13%'
* */