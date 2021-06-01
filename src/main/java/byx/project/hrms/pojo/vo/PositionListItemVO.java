package byx.project.hrms.pojo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PositionListItemVO {
    private String posNo;
    private String name;
    private String deptName;
    private String deptNo;
    private Integer numEmployees;
}
