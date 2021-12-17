package byx.project.hrms.mapper;

import byx.project.hrms.pojo.vo.DepartmentEmployeeCountVO;
import byx.project.hrms.pojo.vo.DepartmentPositionCountVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 部门报表数据访问接口
 *
 * @author byx
 */
@Mapper
public interface DepartmentReportMapper {
    /**
     * 获取每个部门的员工数量
     */
    @Select("select d.name AS deptName, " +
            "count(0) AS empCount " +
            "from department d join employee e on d.id = e.deptId " +
            "group by d.id, d.name " +
            "order by d.id")
    List<DepartmentEmployeeCountVO> getDepartmentEmployeeCount();

    /**
     * 获取每个部门的职位数量
     */
    @Select("select d.name as deptName, count(0) as posCount " +
            "from department d " +
            "join position p on d.id = p.deptId " +
            "group by d.id, d.name")
    List<DepartmentPositionCountVO> getDepartmentPositionCount();
}
