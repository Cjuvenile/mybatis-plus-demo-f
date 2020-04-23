package cn.kgc.test;

import cn.kgc.entity.Employee;
import cn.kgc.mapper.EmployeeMapper;
import cn.kgc.mapper.EmployeeMapper4;
import com.baomidou.mybatisplus.plugins.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MpTest {

    @Autowired
    private EmployeeMapper employeeMapper;
    /*
     * 新增
     * */
    @Test
    public void testInsert(){
        Employee employee=new Employee();
        employee.setLast_name("aDFDFq");
        employee.setAge(4);
        employee.setEmail("1231232@163.com");
        employee.setGender("2");
        Integer result = employeeMapper.insert(employee);
        System.out.println("result = " + result);
    }
    /*
     *更新
     * 如果没有传id不做更新操作
     * Integer updateAllColumnById(@Param("et") T entity)
     * Integer updateById(@Param("et") T entity);
     * */
    @Test
    public void testUpdate(){
      Employee employee= new Employee();
        employee.setLast_name("aDFDFq");
        employee.setAge(4);
        employee.setEmail("1234@163.com");
        employee.setGender("1");
        employee.setId(12);
        Integer result = employeeMapper.updateById(employee);
        System.out.println("result = " + result);
    }

    /*
     * 删除
     * */
    @Test
    public void testdelete1(){
        Integer result = employeeMapper.deleteById(12);
        System.out.println("result = " + result);
    }
    //条件删除
    @Test
    public void testDelete2(){
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("last_name","丽水");
        map.put("age",12);
        Integer result = employeeMapper.deleteByMap(map);
        System.out.println("result = " + result);
    }
    //批量删除
    @Test
    public void testDeleteList(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(14);
        list.add(15);
        list.add(16);
        Integer result = employeeMapper.deleteBatchIds(list);
        System.out.println("result = " + result);
    }

    //根据id查询
    @Test
    public void testSelectid(){
        Employee result = employeeMapper.selectById(17);
        System.out.println("result = " + result);
    }
//根据条件查询
    @Test
    public void testSelectone(){
        Employee employee = new Employee();
        employee.setId(17);
        employee.setAge(4);
        Employee one = employeeMapper.selectOne(employee);
        System.out.println("one = " + one);
    }
    //查询多条数据操作
    @Test
    public void testSelectList(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(17);
        list.add(18);
        list.add(19);
        List<Employee> employees = employeeMapper.selectBatchIds(list);
        for(Employee em:employees){
            System.out.println("em.getLast_name() = " + em.getLast_name());
            System.out.println("em.getId() = " + em.getId());
        }
    }

    //按条件查询
    @Test
    public void testSelectByMap(){
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("last_name","aDFDFq");
        map.put("age",4);

        List<Employee> employees = employeeMapper.selectByMap(map);

        for(Employee em:employees){
            System.out.println("em.getLast_name() = " + em.getLast_name());
            System.out.println("em.getId() = " + em.getId());
        }
    }
    //分业查询
    /*
     *  Page<Employee>(current,size),wrapper
    * current 当前页 ，size 显示行数 ，wrapper 分页条件
    * */
    @Test
    public void SelectPagetest(){
        List<Employee> employees = employeeMapper.selectPage(new
                Page<Employee>(2,2),null);
        for(Employee em:employees){
            System.out.println("em.getLast_name() = " + em.getLast_name());
            System.out.println("em.getId() = " + em.getId());
        }

    }

}
