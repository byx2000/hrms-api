package byx.project.hrms.mapper;

import byx.project.hrms.pojo.dto.*;
import byx.project.hrms.pojo.vo.PositionDetailVO;
import byx.project.hrms.pojo.vo.PositionListItemVO;
import byx.project.hrms.pojo.vo.PositionSelectItemVO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * Position数据访问接口
 *
 * @author byx
 */
@Mapper
public interface PositionMapper {

    @SelectProvider(type = PositionMapper.SqlProvider.class, method = "list")
    List<PositionListItemVO> list(PositionListQueryDTO dto);

    /**
     * 查询职位列表
     */
    @Select("SELECT id, name FROM position WHERE deptId = #{deptId}")
    List<PositionSelectItemVO> selectPositions(PositionSelectQueryDTO dto);

    @Select("SELECT posNo, name, desc FROM position WHERE posNo = #{posNo}")
    PositionDetailVO.DetailVO getDetail(PositionDetailQueryDTO dto);

    @UpdateProvider(type = PositionMapper.SqlProvider.class, method = "update")
    void update(PositionUpdateDTO dto);

    @DeleteProvider(type = PositionMapper.SqlProvider.class, method = "delete")
    void delete(PositionDeleteDTO dto);

    @InsertProvider(type = PositionMapper.SqlProvider.class, method = "insert")
    void insert(PositionInsertDTO dto);

    class SqlProvider {
        public String list(PositionListQueryDTO dto) {
            return new SQL(){
                {
                    SELECT("p.posNo AS posNo");
                    SELECT("p.name AS name");
                    SELECT("d.name AS deptName");
                    SELECT("d.deptNo AS deptNo");
                    SELECT("COUNT(e.id) AS numEmployees");

                    FROM("position p");
                    LEFT_OUTER_JOIN("employee e ON p.id = e.posId");
                    LEFT_OUTER_JOIN("department d ON p.deptId = d.id");

                    if (dto.getPosNo() != null && !dto.getPosNo().isEmpty()) {
                        WHERE("p.posNo LIKE '%${posNo}%'");
                    }
                    if (dto.getName() != null && !dto.getName().isEmpty()) {
                        WHERE("p.name LIKE '%${name}%'");
                    }
                    if (dto.getDeptName() != null && !dto.getDeptName().isEmpty()) {
                        WHERE("d.name LIKE '%${deptName}%'");
                    }
                    if (dto.getDeptNo() != null && !dto.getDeptNo().isEmpty()) {
                        WHERE("d.deptNo = #{deptNo}");
                    }
                    GROUP_BY("p.id");
                }
            }.toString();
        }

        public String update(PositionUpdateDTO dto) {
            return new SQL(){
                {
                    UPDATE("position");
                    if (dto.getName() != null) {
                        SET("name = #{name}");
                    }
                    if (dto.getDesc() != null) {
                        SET("desc = #{desc}");
                    }
                    if (dto.getDeptId() != null) {
                        SET("deptId = #{deptId}");
                    }
                    WHERE("posNo = #{posNo}");
                }
            }.toString();
        }

        public String insert(PositionInsertDTO dto) {
            return new SQL(){
                {
                    INSERT_INTO("position");
                    if (dto.getName() != null) {
                        VALUES("name", "#{name}");
                    }
                    if (dto.getDesc() != null) {
                        VALUES("desc","#{desc}");
                    }
                    if (dto.getDeptId() != null) {
                        VALUES("deptId", "#{deptId}");
                    }
                }
            }.toString();
        }

        public String delete(PositionDeleteDTO dto) {
            return new SQL() {
                {
                    DELETE_FROM("position");
                    WHERE("posNo = #{posNo}");
                }
            }.toString();
        }
    }
}
