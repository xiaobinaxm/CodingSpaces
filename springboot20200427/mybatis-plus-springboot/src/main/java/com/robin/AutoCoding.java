package com.robin;

import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

/**
 * @Description 代码自动生成  本例采用的mybatis-plus3.3.0版本
 * @Author Robin
 * @Date 2020/4/27 9:14
 */
public class AutoCoding {

    public static void main(String[] args) {
        //构建一个代码自动生成器
        AutoGenerator autoGenerator = new AutoGenerator();

        //全局配置
        GlobalConfig config = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        //config.setOutputDir(projectPath + "/src/main/java");//因为我这里用的是Module，不是project，所以需要加上模块名
        config.setOutputDir(projectPath + "/mybatis-plus-springboot/src/main/java");
        config.setAuthor("Robin");
        config.setOpen(false);
        config.setFileOverride(false);//是否覆盖
        config.setServiceName("%sService");//去掉Service的I开头
        //config.setIdType(IdType.ID_WORKER);//仅仅支持3.3.0版本
        autoGenerator.setGlobalConfig(config);

        //设置数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://127.0.0.1:3306/test2?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8");
        dataSourceConfig.setDriverName("com.alibaba.druid.pool.DruidDataSource");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("root");
//        dataSourceConfig.setDbType(DbType.MYSQL);////仅仅支持3.3.0版本
        autoGenerator.setDataSource(dataSourceConfig);

        //包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName("automp");
        packageConfig.setParent("com.robin");
        packageConfig.setEntity("entity");
        packageConfig.setMapper("mapper");
        packageConfig.setService("service");
        packageConfig.setController("controller");
        autoGenerator.setPackageInfo(packageConfig);



        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setInclude("mp_book", "mp_user", "mp_role", "mp_course");//设置需要映射的表名
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);//采用驼峰命名法
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityLombokModel(true);//自动lombok

        //设置逻辑删除
        strategyConfig.setLogicDeleteFieldName("dr");

/*        //设置自动填充，创建时间，修改时间  //仅仅支持3.3.0版本
        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);
        strategyConfig.setTableFillList(tableFills);
*/
        //乐观锁
        strategyConfig.setVersionFieldName("version");

        strategyConfig.setRestControllerStyle(true);
        //采用localhost:8080/hello_id_2
        strategyConfig.setControllerMappingHyphenStyle(true);


        autoGenerator.execute();
    }


}
































