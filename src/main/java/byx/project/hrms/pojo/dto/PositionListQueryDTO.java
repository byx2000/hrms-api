package byx.project.hrms.pojo.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 职位列表查询对象
 * @author Jiang Yinzuo
 */
@Getter
@Setter
@ToString
public class PositionListQueryDTO extends PagingQueryDTO {
    /**
     * 职位编号
     */
    private String posNo;
    /**
     * 职位名称
     */
    private String name;
    /**
     * 所属部门
     */
    private String deptName;
    /**
     * 所属部门编号
     */
    private String deptNo;

}
