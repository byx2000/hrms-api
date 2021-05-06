package byx.project.hrms.mapper;

import byx.project.hrms.pojo.vo.DepartmentSelectItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Department数据访问接口
 *
 * @author byx
 */
@Mapper
public interface DepartmentMapper {
    /**
     * 获取所有部门信息
     */
    @Select("SELECT id, name FROM department")
    List<DepartmentSelectItemVO> listAll();
}
