package byx.project.hrms.mapper;

import byx.project.hrms.pojo.dto.PositionSelectQueryDTO;
import byx.project.hrms.pojo.vo.PositionSelectItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Position数据访问接口
 *
 * @author byx
 */
@Mapper
public interface PositionMapper {
    /**
     * 根据部门查询所有职位选项
     */
    @Select("SELECT id, name FROM position WHERE deptId = #{deptId}")
    List<PositionSelectItemVO> list(PositionSelectQueryDTO dto);
}
