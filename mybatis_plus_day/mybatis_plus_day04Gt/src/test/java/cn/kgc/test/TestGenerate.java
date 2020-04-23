package cn.kgc.test;

import com.baomidou.mybatisplus.enums.IdType;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;

import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//类名如果出现波浪线是写错
//快速查找类 知道类名查找类:Ctrl+Shift+Alt+N;
//Ctrl+Shift+Alt+s;新建工程
public class TestGenerate {
    /*
    *测试代码生成
     */
    @Test
    public void testGenerate(){
        //1.全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true)//是否支持AR
        .setAuthor("fd")//作者
        .setOutputDir("D:/idea/mybatis_plus/mybatis_plus_day/mybatis_plus_day04Gt/SRC/main/java")//生成路径
        .setFileOverride(true)//文件覆盖
        .setIdType(IdType.AUTO)//主键策略
        .setServiceName("%sService");//设置生成的Service首字母是否为I
        //数据源配置
        DataSourceConfig dsConfig= new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql:///jpa_study?serverTimezone=UTC")
                .setUsername("root")
                .setPassword("root");
        //策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true)    // 全局大写命名
                .setDbColumnUnderline(true)    //表名 字段名 是否使用下滑线命名--驼峰命名规则
                .setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
                .setInclude("tbl_employee")    //生成的表，想要生成多张表
                .setTablePrefix("tbl_"); // 表前缀
        //包名策略
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("cn.kgc")
                .setController("controller")
                .setEntity("pojo")
                .setService("service")
                .setServiceImpl("service.impl");
        //整合
        AutoGenerator ag = new AutoGenerator()
                .setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setStrategy(stConfig)
                .setPackageInfo(pkConfig);
        //执行
        ag.execute();
    }
}
