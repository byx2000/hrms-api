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
     * 根据年龄区间和性别获取员工数量
     */
    @SelectProvider(type = SqlProvider.class, method = "countByAgeAndGender")
    int countByAgeAndGender(Integer minAge, Integer maxAge, Integer gender);

    /**
     * 获取指定类型的员工数量（0为实习生，1为正式员工）
     */
    @Select("SELECT COUNT(0) FROM employee WHERE type = #{type}")
    int countByType(Integer type);

    class SqlProvider {
        public String countByAgeAndGender(Integer minAge, Integer maxAge, Integer gender) {
            return new SQL(){
                {
                    SELECT("COUNT(0)");
                    FROM("employee");
                    if (minAge != null) {
                        WHERE("age >= #{minAge}");
                    }
                    if (maxAge != null) {
                        WHERE("age <= #{maxAge}");
                    }
                    if (gender != null) {
                        WHERE("gender = #{gender}");
                    }
                }
            }.toString();
        }
    }
}
