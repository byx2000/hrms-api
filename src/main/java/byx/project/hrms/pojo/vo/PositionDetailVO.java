package byx.project.hrms.pojo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class PositionDetailVO {
    private String posNo;
    private String name;
    private String desc;
    private List<EmployeeVO> employees;

    public PositionDetailVO(DetailVO detailVO, List<EmployeeVO> employees) {
        this.posNo = detailVO.posNo;
        this.name = detailVO.name;
        this.desc = detailVO.desc;
        this.employees = employees;
    }

    @Getter
    @Setter
    @ToString
    public static class EmployeeVO {
        private String empNo;
        private String name;
        private String contact;
    }

    @Getter
    @Setter
    @ToString
    public static class DetailVO {
        private String posNo;
        private String name;
        private String desc;
    }
}
