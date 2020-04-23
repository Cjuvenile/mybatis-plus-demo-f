package cn.kgc.test;


import cn.kgc.entity.Employee5;
import cn.kgc.mapper.EmployeeMapper5;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class PageTest {

        /**
         * 测试分页插件
         */
        @Test
        public void testPage() {
            Employee5 employee5 = new Employee5();
            Page<Employee5> page = employee5.selectPage(new Page<Employee5>(1,2),null);
            List<Employee5> emps = page.getRecords();
            System.out.println(emps.size());
            System.out.println("===============获取分页相关的一些信息======================");
            System.out.println("总条数:" +page.getTotal());
            System.out.println("当前页码: "+  page.getCurrent());
            System.out.println("总页码:" + page.getPages());
            System.out.println("每页显示的条数:" + page.getSize());
            System.out.println("是否有上一页: " + page.hasPrevious());
            System.out.println("是否有下一页: " + page.hasNext());
            //将查询的结果封装到page对象中
            page.setRecords(emps);
        }
    /**
     * 测试分页插件
     */
    @Autowired
    private EmployeeMapper5 employeeMapper5;
    @Test
    public void testPageE() {
        Page<Employee5> page = new Page<Employee5>(1,2);
        List<Employee5> emps=employeeMapper5.selectPage(page,null);
        System.out.println(emps.size());
        System.out.println("===============获取分页相关的一些信息======================");
        System.out.println("总条数:" +page.getTotal());
        System.out.println("当前页码: "+  page.getCurrent());
        System.out.println("总页码:" + page.getPages());
        System.out.println("每页显示的条数:" + page.getSize());
        System.out.println("是否有上一页: " + page.hasPrevious());
        System.out.println("是否有下一页: " + page.hasNext());
        //将查询的结果封装到page对象中
        page.setRecords(emps);
    }
    }
