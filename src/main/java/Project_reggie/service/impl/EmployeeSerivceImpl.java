package Project_reggie.service.impl;

import Project_reggie.entity.Employee;
import Project_reggie.mapper.EmployeeMapper;
import Project_reggie.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EmployeeSerivceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
