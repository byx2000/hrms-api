package byx.project.hrms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

/**
 * 员工报表数据访问接口
 *
 * @author byx
 */
@Mapper
public interface EmployeeReportMapper {
    /**
     * 获取指定年龄区间的员工数量
     */
    @SelectProvider(type = SqlProvider.class, method = "countByAge")
    int countByAge(Integer min, Integer max);

    /**
     * 获取指定性别的员工数量（0为男，1为女）
     */
    @Select("SELECT COUNT(0) FROM employee WHERE gender = #{gender}")
    int countByGender(Integer gender);

    /**
     * 获取指定类型的员工数量（0为实习生，1为正式员工）
     */
    @Select("SELECT COUNT(0) FROM employee WHERE type = #{type}")
    int countByType(Integer type);

    class SqlProvider {
        public String countByAge(Integer min, Integer max) {
            return new SQL(){
                {
                    SELECT("COUNT(0)");
                    FROM("employee");
                    if (min != null) {
                        WHERE("age >= #{min}");
                    }
                    if (max != null) {
                        WHERE("age <= #{max}");
                    }
                }
            }.toString();
        }
    }
}
