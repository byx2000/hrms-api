package byx.project.hrms.pojo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * 插入部门传输对象
 *
 * @author byx
 */
@Getter @Setter @ToString
public class DepartmentInsertDTO {
    @NotNull(message = "name不能为空")
    private String name;

    @NotNull(message = "desc不能为空")
    private String desc;
}
