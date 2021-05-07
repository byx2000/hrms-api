package byx.project.hrms.service.impl;

import byx.project.hrms.mapper.SalaryMapper;
import byx.project.hrms.pojo.dto.SalaryQueryDTO;
import byx.project.hrms.pojo.vo.SalaryItemVO;
import byx.project.hrms.service.SalaryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Salary服务实现类
 *
 * @author byx
 */
@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryMapper salaryMapper;

    @Override
    public PageInfo<SalaryItemVO> getSalaryList(SalaryQueryDTO dto) {
        PageHelper.startPage(dto.getCurrentPage(), dto.getPageSize());
        return new PageInfo<>(salaryMapper.list(dto));
    }
}
