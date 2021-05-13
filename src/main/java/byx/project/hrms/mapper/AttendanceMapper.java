package byx.project.hrms.mapper;

import byx.project.hrms.pojo.dto.AttendanceListQueryDTO;
import byx.project.hrms.pojo.dto.AttendanceTimeItemDTO;
import byx.project.hrms.pojo.vo.AttendanceListItemVO;
import byx.project.hrms.pojo.vo.LatestWeekAttendanceItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * 考勤数据访问接口
 *
 * @author byx
 */
@Mapper
public interface AttendanceMapper {
    /**
     * 获取考勤列表
     */
    @SelectProvider(type = SqlProvider.class, method = "list")
    List<AttendanceListItemVO> list(AttendanceListQueryDTO dto);

    /**
     * 获取考勤时间列表
     */
    @Select("SELECT date, time " +
            "FROM attendance " +
            "WHERE empId = #{empId} " +
            "AND type = #{type} " +
            "AND date >= #{begin} " +
            "AND date <= #{end} " +
            "ORDER BY date")
    List<AttendanceTimeItemDTO> listTime(Integer empId, String begin, String end, Integer type);

    class SqlProvider {
        public String list(AttendanceListQueryDTO dto) {
            return new SQL(){
                {
                    SELECT("e.id AS empId, e.empNo AS empNo, e.name AS empName, a.type AS type, a.date AS date, a.time AS time");
                    FROM("employee e JOIN attendance a ON e.id = a.empId");

                    WHERE("a.date = #{date}");
                    if (dto.getEmpNo() != null && !dto.getEmpNo().isEmpty()) {
                        WHERE("e.empNo LIKE '%${empNo}%'");
                    }
                    if (dto.getEmpName() != null && !dto.getEmpName().isEmpty()) {
                        WHERE("e.name LIKE '%${empName}%'");
                    }
                    if (dto.getType() == 1) {
                        WHERE("a.type = 0 AND a.time > '09:00'");
                    } else if (dto.getType() == 2) {
                        WHERE("a.type = 1 AND a.time < '17:00'");
                    }

                    ORDER_BY("e.empNo, a.date DESC, a.type");
                }
            }.toString();
        }
    }
}
