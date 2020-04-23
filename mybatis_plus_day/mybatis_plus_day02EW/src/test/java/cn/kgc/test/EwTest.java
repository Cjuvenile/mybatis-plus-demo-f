package cn.kgc.test;

import cn.kgc.entity.Employee2;
import cn.kgc.mapper.EmployeeMapper2;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
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
public class EwTest {

    @Autowired
    private EmployeeMapper2 employeeMapper2;

    @Test
    public void testEwSelectList(){

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("last_name","aDFDFq");
        map.put("age",4);
        ArrayList<Integer> integers = new ArrayList<Integer>();
        integers.add(17);
        integers.add(18);
        integers.add(19);

        List<Employee2> list= employeeMapper2.selectPage(new Page<Employee2>(1,3),
                new EntityWrapper<Employee2>()
//                 .eq("gender","2")//SELECT id AS id,last_name,email,gender,age FROM tbl_employee WHERE (gender = ?)
//                 .where("gender","2")// SELECT id AS id,last_name,email,gender,age FROM tbl_employee WHERE (gender)
//                 .and("age",4) //SELECT id AS id,last_name,email,gender,age FROM tbl_employee WHERE (gender = ? AND age)
//                 .andNew("age",4) // SELECT id AS id,last_name,email,gender,age FROM tbl_employee WHERE (gender = ?) AND (age)
//                 .or("age",4)// SELECT id AS id,last_name,email,gender,age FROM tbl_employee WHERE (gender = ? OR age)
//                 .orNew("age",4)//SELECT id AS id,last_name,email,gender,age FROM tbl_employee WHERE (gender = ?) OR (age)
//                 .allEq(map)//SELECT id AS id,last_name,email,gender,age FROM tbl_employee WHERE (last_name = ? AND age = ?)
//                 .ne("age",5)//SELECT id AS id,last_name,email,gender,age FROM tbl_employee WHERE (age <> ?)
//                 .ge("age",3)//SELECT id AS id,last_name,email,gender,age FROM tbl_employee WHERE (age >= ?)
//                 .gt("age",3)//SELECT id AS id,last_name,email,gender,age FROM tbl_employee WHERE (age > ?)
//                 .le("age",5)// SELECT id AS id,last_name,email,gender,age FROM tbl_employee WHERE (age <= ?)
//                 .lt("age",5)//SELECT id AS id,last_name,email,gender,age FROM tbl_employee WHERE (age < ?)
//                 .like("last_name","%a%")//SELECT id AS id,last_name,email,gender,age FROM tbl_employee WHERE (last_name LIKE ?)
//                 .notLike("last_name","%a%")//SELECT id AS id,last_name,email,gender,age FROM tbl_employee WHERE (last_name NOT LIKE ?)
//                 .in("id",integers)// SELECT id AS id,last_name,email,gender,age FROM tbl_employee WHERE (id IN (?,?,?))
//                 .notIn("id",integers)// SELECT id AS id,last_name,email,gender,age FROM tbl_employee WHERE (id NOT IN (?,?,?))
//                 .isNull("age")//SELECT id AS id,last_name,email,gender,age FROM tbl_employee WHERE (age IS NULL)
//                 .isNotNull("age")//SELECT id AS id,last_name,email,gender,age FROM tbl_employee WHERE (age IS NOT NULL)
//                 .groupBy("id")//SELECT id AS id,last_name,email,gender,age FROM tbl_employee GROUP BY id
//                 .having("age",4)// SELECT id AS id,last_name,email,gender,age FROM tbl_employee GROUP BY id HAVING (age)
//                 .orderBy("age")//SELECT id AS id,last_name,email,gender,age FROM tbl_employee ORDER BY age
//                 .orderAsc(Arrays.asList(new String[]{"id"}))//SELECT id AS id,last_name,email,gender,age FROM tbl_employee ORDER BY id ASC
//                 .orderDesc(Arrays.asList(new String[]{"id"}))//SELECT id AS id,last_name,email,gender,age FROM tbl_employee ORDER BY  id DESC
//                 .exists("select * from tbl_employee where age=4")// SELECT id AS id,last_name,email,gender,age FROM tbl_employee WHERE ( EXISTS (select * from tbl_employee where age=4 ))
//                 .notExists("select * from tbl_employee where age=4")//DEBUG 04-12 21:32:48,260 ==>  Preparing: SELECT id AS id,last_name,email,gender,age FROM tbl_employee WHERE ( NOT EXISTS (select * from tbl_employee where age=4))
//                 .between("id",17,19)//SELECT id AS id,last_name,email,gender,age FROM tbl_employee WHERE (id BETWEEN ? AND ?)
//                 .notBetween("id",1,2)//SELECT id AS id,last_name,email,gender,age FROM tbl_employee WHERE (id NOT BETWEEN ? AND ?)
//                 .addFilter("age=4")//SELECT id AS id,last_name,email,gender,age FROM tbl_employee WHERE (age=4)
//                 .last("where age = 4")// SELECT id AS id,last_name,email,gender,age FROM tbl_employee where age = 4

       );
       for(Employee2 emp:list){
           System.out.println("emp.getId() = " + emp.getId());
       }


    }


}
