package byx.project.hrms.mapper;

import byx.project.hrms.pojo.dto.PositionEmployeeCountQueryDTO;
import byx.project.hrms.pojo.vo.PositionEmployeeCountVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 职位报表数据访问接口
 *
 * @author byx
 */
@Mapper
public interface PositionReportMapper {
    /**
     * 获取指定部门的所有职位员工数量
     */
    @Select("select p.name AS posName, count(0) AS empCount " +
            "from position p " +
            "join employee e on p.id = e.posId " +
            "where p.deptId = #{deptId} " +
            "group by p.id, p.name")
    List<PositionEmployeeCountVO> getPositionEmployeeCount(PositionEmployeeCountQueryDTO dto);
}
