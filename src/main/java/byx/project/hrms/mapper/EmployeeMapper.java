package byx.project.hrms.mapper;

import byx.project.hrms.pojo.dto.*;
import byx.project.hrms.pojo.vo.EmployeeDetailVO;
import byx.project.hrms.pojo.vo.EmployeeListItemVO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * Employee数据访问接口
 *
 * @author byx
 */
@Mapper
public interface EmployeeMapper {
    /**
     * 查询员工列表
     */
    @SelectProvider(type = SqlProvider.class, method = "list")
    List<EmployeeListItemVO> list(EmployeeListQueryDTO dto);

    /**
     * 根据工号查询员工详情
     */
    @Select("SELECT e.empNo AS empNo, " +
            "e.name As name, " +
            "e.gender AS gender, " +
            "e.age AS age, " +
            "d.name AS deptName, " +
            "p.name AS posName, " +
            "e.type AS type, " +
            "e.contact AS contact, " +
            "e.desc AS desc, " +
            "e.deptId AS deptId, " +
            "e.posId AS posId " +
            "FROM employee e JOIN department d ON e.deptId = d.id " +
            "JOIN position p ON e.posId = p.id " +
            "WHERE empNo = #{empNo}")
    EmployeeDetailVO get(EmployeeDetailQueryDTO dto);

    /**
     * 更新员工信息
     */
    @UpdateProvider(type = SqlProvider.class, method = "update")
    void update(EmployeeUpdateDTO dto);

    /**
     * 删除员工
     */
    @Delete("DELETE FROM employee WHERE empNo = #{empNo}")
    void delete(EmployeeDeleteDTO dto);

    /**
     * 插入员工
     */
    @Insert("INSERT INTO employee(name, gender, age, contact, deptId, posId, type, desc) " +
            "VALUES(#{name}, #{gender}, #{age}, #{contact}, #{deptId}, #{posId}, #{type}, #{desc})")
    void insert(EmployeeInsertDTO dto);

    class SqlProvider {
        public String list(EmployeeListQueryDTO dto) {
            return new SQL(){
                {
                    SELECT("e.empNo AS empNo");
                    SELECT("e.name As name");
                    SELECT("d.name AS deptName");
                    SELECT("p.name AS posName");
                    SELECT("e.type AS type");
                    SELECT("e.contact AS contact");

                    FROM("employee e");
                    JOIN("department d ON e.deptId = d.id");
                    JOIN("position p ON e.posId = p.id");

                    if (dto.getEmpNo() != null && !dto.getEmpNo().isEmpty()) {
                        WHERE("e.empNo LIKE '%${empNo}%'");
                    }
                    if (dto.getName() != null && !dto.getName().isEmpty()) {
                        WHERE("e.name LIKE '%${name}%'");
                    }
                    if (dto.getDeptName() != null && !dto.getDeptName().isEmpty()) {
                        WHERE("d.name LIKE '%${deptName}%'");
                    }
                    if (dto.getPosName() != null && !dto.getPosName().isEmpty()) {
                        WHERE("p.name LIKE '%${posName}%'");
                    }
                    if (dto.getType() != null && dto.getType() >= 0 && dto.getType() <= 1) {
                        WHERE("e.type = #{type}");
                    }
                }
            }.toString();
        }

        public String update(EmployeeUpdateDTO dto) {
            return new SQL(){
                {
                    UPDATE("employee");

                    if (dto.getName() != null) {
                        SET("name = #{name}");
                    }
                    if (dto.getGender() != null) {
                        SET("gender = #{gender}");
                    }
                    if (dto.getAge() != null) {
                        SET("age = #{age}");
                    }
                    if (dto.getContact() != null) {
                        SET("contact = #{contact}");
                    }
                    if (dto.getDeptId() != null) {
                        SET("deptId = #{deptId}");
                    }
                    if (dto.getPosId() != null) {
                        SET("posId = #{posId}");
                    }
                    if (dto.getType() != null) {
                        SET("type = #{type}");
                    }
                    if (dto.getDesc() != null) {
                        SET("desc = #{desc}");
                    }

                    WHERE("empNo = #{empNo}");
                }
            }.toString();
        }
    }
}
