package byx.project.hrms.pojo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * 分页查询对象基类
 *
 * @author byx
 */
@Getter @Setter
public abstract class PagingQueryDTO {
    @NotNull(message = "pageSize不能为空")
    private Integer pageSize;

    @NotNull(message = "currentPage不能为空")
    private Integer currentPage;
}
