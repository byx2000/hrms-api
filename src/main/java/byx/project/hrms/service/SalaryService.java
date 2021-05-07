package byx.project.hrms.service;

import byx.project.hrms.pojo.dto.SalaryQueryDTO;
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
}
