package byx.project.hrms.service;

import byx.project.hrms.pojo.dto.EmployeeSalaryListQueryDTO;
import byx.project.hrms.pojo.dto.SalaryQueryDTO;
import byx.project.hrms.pojo.vo.EmployeeSalaryListItemVO;
import byx.project.hrms.pojo.vo.SalaryItemVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Salary服务接口
 *
 * @author byx
 */
public interface SalaryService {
    /**
     * 获取薪资列表
     */
    PageInfo<SalaryItemVO> getSalaryList(SalaryQueryDTO dto);

    /**
     * 获取指定员工的薪资列表
     */
    List<EmployeeSalaryListItemVO> getEmployeeSalaryList(EmployeeSalaryListQueryDTO dto);
}
