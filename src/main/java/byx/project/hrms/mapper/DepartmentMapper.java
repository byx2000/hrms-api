package byx.project.hrms.mapper;

import byx.project.hrms.pojo.dto.*;
import byx.project.hrms.pojo.vo.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

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

    /**
     * 查询部门列表
     */
    @SelectProvider(type = DepartmentMapper.SqlProvider.class, method = "list")
    List<DepartmentListItemVO> list(DepartmentListQueryDTO dto);

    /**
     * 根据部门编号查询部门详情
     */
    @Select("SELECT d.deptNo AS deptNo, " +
            "d.name AS name, "+
            "d.desc AS desc, "+
            "e.name AS managerName, "+
            "e.empNo AS managerEmpNo, "+
            "e.contact AS managerContact "+
            "FROM department d JOIN manager m ON d.id = m.deptId " +
            "JOIN employee e ON e.id = m.empId " +
            "WHERE deptNo = #{deptNo}")
    DepartmentDetailVO get(DepartmentDetailQueryDTO dto);

    /**
     * 更新部门信息
     */
    @UpdateProvider(type = DepartmentMapper.SqlProvider.class, method = "update")
    void update(DepartmentUpdateDTO dto);

    /**
     * 删除部门
     */
    @Delete("DELETE FROM department WHERE deptNo = #{deptNo}")
    void delete(DepartmentDeleteDTO dto);

    /**
     * 插入部门
     */
    @Insert("INSERT INTO department(name, desc) " +
            "VALUES(#{name}, #{desc})")
    void insert(DepartmentInsertDTO dto);


    class SqlProvider {
        public String list(DepartmentListQueryDTO dto) {
            return new SQL(){
                {
                    SELECT("d.deptNo AS deptNo");
                    SELECT("d.name As name");
                    SELECT("e.name AS managerName");
                    SELECT("e.empNo AS managerEmpNo");
                    SELECT("e.contact AS managerContact");

                    FROM("department d");
                    LEFT_OUTER_JOIN("manager m ON m.deptId = d.id");
                    LEFT_OUTER_JOIN("employee e ON e.id = m.empId");

                    if (dto.getDeptNo() != null && !dto.getDeptNo().isEmpty()) {
                        WHERE("d.deptNo LIKE '%${deptNo}%'");
                    }
                    if (dto.getName() != null && !dto.getName().isEmpty()) {
                        WHERE("d.name LIKE '%${name}%'");
                    }
                    if (dto.getManagerName() != null && !dto.getManagerName().isEmpty()) {
                        WHERE("e.name LIKE '%${managerName}%'");
                    }
                    if (dto.getManagerEmpNo() != null && !dto.getManagerEmpNo().isEmpty()) {
                        WHERE("e.empNo LIKE '%${managerEmpNo}%'");
                    }
                }
            }.toString();
        }

        public String update(DepartmentUpdateDTO dto) {
            return new SQL(){
                {
                    UPDATE("department");

                    if (dto.getName() != null) {
                        SET("name = #{name}");
                    }
                    if (dto.getDesc() != null) {
                        SET("desc = #{desc}");
                    }

                    WHERE("deptNo = #{deptNo}");
                }
            }.toString();
        }
    }

}
