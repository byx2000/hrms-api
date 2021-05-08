package byx.project.hrms.mapper;

import byx.project.hrms.pojo.dto.EmployeeSalaryListQueryDTO;
import byx.project.hrms.pojo.dto.SalaryQueryDTO;
import byx.project.hrms.pojo.vo.EmployeeSalaryListItemVO;
import byx.project.hrms.pojo.vo.SalaryItemVO;
import byx.project.hrms.util.DateUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * Salary数据访问接口
 *
 * @author byx
 */
@Mapper
public interface SalaryMapper {
    /**
     * 查询薪资记录
     */
    @SelectProvider(type = SqlProvider.class, method = "list")
    List<SalaryItemVO> list(SalaryQueryDTO dto);

    /**
     * 查询指定员工的薪资记录
     */
    @Select("SELECT s.salary AS salary, s.time AS time " +
            "FROM salary s JOIN employee e ON s.empId = e.id " +
            "WHERE e.empNo = #{empNo} " +
            "ORDER BY s.time")
    List<EmployeeSalaryListItemVO> query(EmployeeSalaryListQueryDTO dto);

    class SqlProvider {
        public String list(SalaryQueryDTO dto)
        {
            return new SQL(){
                {
                    if (dto.getTime() == null) {
                        dto.setTime(DateUtils.now());
                    }

                    SELECT("e.empNo AS empNo, e.name AS empName, s.salary AS salary, t.time AS time, d.name AS deptName");
                    FROM("(SELECT empId AS empId, MAX(time) AS time FROM salary WHERE time <= #{time} GROUP BY empId) t");
                    JOIN("employee e ON t.empId = e.id");
                    JOIN("salary s ON s.empId = t.empId AND s.time = t.time");
                    JOIN("department d ON e.deptId = d.id");

                    if (dto.getEmpNo() != null) {
                        WHERE("e.empNo LIKE '%${empNo}%'");
                    }
                    if (dto.getEmpName() != null) {
                        WHERE("e.name LIKE '%${empName}%'");
                    }

                    if (dto.getOrderBy() != null && !dto.getOrderBy().isEmpty()) {
                        if (dto.getIsDesc() == null || !dto.getIsDesc()) {
                            ORDER_BY("${orderBy}");
                        } else {
                            ORDER_BY("${orderBy} DESC");
                        }
                    }
                }
            }.toString();
        }
    }
}
