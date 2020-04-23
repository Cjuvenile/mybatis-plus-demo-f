package cn.kgc.test;


import cn.kgc.entity.Employee5;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ArTest {

//1)插入操作 public boolean insert()
    @Test
    public void  ARInsert(){
        Employee5 employee = new Employee5();
        employee.setLast_name("金刚狼");
        employee.setAge(23);
        employee.setEmail("1231232@163.com");
        employee.setGender("0");
        boolean  result=employee.insert();
        System.out.println("result = " + result);
    }
//2)修改操作 public boolean updateById()
    @Test
    public void ARUpdate(){
        Employee5 employee3 = new Employee5();
        employee3.setId(20);
        employee3.setLast_name("X教授");
        boolean result = employee3.updateById();
        System.out.println("result = " + result);
    }
/*3)查询操作
    public void selectById(){}
    public void selectById(Serializable id)｛｝
    public List<T> selectAll()
    public List<T> selectList(Wrapper wrapper)
    public int selectCount(Wrapper wrapper)*/
@Test
    public void ARSelectById(){
        Employee5 employee3 = new Employee5();
        Employee5 result = employee3.selectById(20);
        System.out.println(result.getLast_name());
}
@Test
    public void ARSelectAll(){
        Employee5 employee3 = new Employee5();
        List<Employee5> result = employee3.selectAll();
        for(Employee5 em:result){
            System.out.println(em.getLast_name());
        }
}
    @Test
    public void ARSelectList(){
        Employee5 employee3 = new Employee5();
        List<Employee5> result = employee3.selectList(new EntityWrapper().eq("age",4));
        for(Employee5 em:result){
            System.out.println(em.getLast_name());
        }
    }
    @Test
    public void ARSelectCount(){
        Employee5 employee3 = new Employee5();
        Integer result = employee3.selectCount(new EntityWrapper().eq("age",4));
        System.out.println("result = " + result);
    }


/*4)删除操作
    public boolean deleteById()
    public boolean deleteById(Serializable id)
    public boolean delete(Wrapper wrapper)*/
@Test
public void ARDelete(){
    Employee5 employee3 = new Employee5();
    boolean result = employee3.delete(new EntityWrapper().gt("age",4));
    System.out.println("result = " + result);
}
    @Test
    public void ARDeleteById(){
        Employee5 employee3 = new Employee5();
        boolean result = employee3.delete(new EntityWrapper().gt("age",4));
        System.out.println("result = " + result);
    }
//分页的复杂查询
    @Test
    public void ARPage(){
        Employee5 employee3 = new Employee5();
        Page<Employee5> page=employee3.selectPage(new Page<Employee5>(1,2),
                new EntityWrapper<Employee5>().eq("age",4));

        List<Employee5> result = page.getRecords();
        for(Employee5 em:result){
            System.out.println(em.getLast_name());
        }

    }

}
