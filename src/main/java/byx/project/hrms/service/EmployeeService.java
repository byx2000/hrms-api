package byx.project.hrms.service;

import byx.project.hrms.pojo.dto.*;
import byx.project.hrms.pojo.vo.EmployeeDetailVO;
import byx.project.hrms.pojo.vo.EmployeeListItemVO;
import com.github.pagehelper.PageInfo;

/**
 * Employee服务接口
 *
 * @author byx
 */
public interface EmployeeService {
    /**
     * 获取员工列表
     */
    PageInfo<EmployeeListItemVO> getEmployeeList(EmployeeListQueryDTO dto);

    /**
     * 获取员工详情
     */
    EmployeeDetailVO getEmployeeDetail(EmployeeDetailQueryDTO dto);

    /**
     * 更新员工信息
     */
    void update(EmployeeUpdateDTO dto);

    /**
     * 删除员工
     */
    void delete(EmployeeDeleteDTO dto);

    /**
     * 插入员工
     */
    void insert(EmployeeInsertDTO dto);
}
