package byx.project.hrms.service.impl;

import byx.project.hrms.mapper.EmployeeMapper;
import byx.project.hrms.pojo.dto.*;
import byx.project.hrms.pojo.vo.EmployeeDetailVO;
import byx.project.hrms.pojo.vo.EmployeeListItemVO;
import byx.project.hrms.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Employee服务实现类
 *
 * @author byx
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public PageInfo<EmployeeListItemVO> getEmployeeList(EmployeeListQueryDTO dto) {
        PageHelper.startPage(dto.getCurrentPage(), dto.getPageSize());
        return new PageInfo<>(employeeMapper.list(dto));
    }

    @Override
    public EmployeeDetailVO getEmployeeDetail(EmployeeDetailQueryDTO dto) {
        return employeeMapper.get(dto);
    }

    @Override
    public void update(EmployeeUpdateDTO dto) {
        employeeMapper.update(dto);
    }

    @Override
    public void delete(EmployeeDeleteDTO dto) {
        employeeMapper.delete(dto);
    }

    @Override
    public void insert(EmployeeInsertDTO dto) {
        employeeMapper.insert(dto);
    }
}
