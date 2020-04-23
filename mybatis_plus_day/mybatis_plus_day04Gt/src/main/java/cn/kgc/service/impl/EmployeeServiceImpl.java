package cn.kgc.service.impl;

import cn.kgc.pojo.Employee;
import cn.kgc.mapper.EmployeeMapper4;
import cn.kgc.service.EmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fd
 * @since 2020-04-13
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper4, Employee> implements EmployeeService {

}
