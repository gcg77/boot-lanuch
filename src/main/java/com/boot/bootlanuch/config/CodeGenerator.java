package com.boot.bootlanuch.config;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;


public class CodeGenerator {
    @Test
    public void testGenerator() {
        // 代码生成器
        AutoGenerator ag = new AutoGenerator();
        // 1. 全局配置
        GlobalConfig config = new GlobalConfig();
        // 是否支持AR模式
        String projectPath = System.getProperty("user.dir");
        config.setActiveRecord(true).setAuthor("gcg") // 作者
                .setOutputDir(projectPath + "/src/main/java") // 生成路径
                .setFileOverride(true)// 是否文件覆盖，如果多次
                .setServiceName("%sService") // 设置生成的service接口名首字母是否为大写
                .setIdType(IdType.AUTO) // 主键策略
                .setServiceName("%sService")// 设置生成的service接口的名字的首字母是否为大写
                .setBaseResultMap(true).setBaseColumnList(true);
        ag.setGlobalConfig(config);
        // 2. 数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL).setUrl(
                "jdbc:mysql://121.36.104.193:3306/boot-lanuch?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC")
                .setDriverName("com.mysql.cj.jdbc.Driver").setUsername("root").setPassword("123456");
        ag.setDataSource(dsConfig);
        // 3.策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true) // 全局大写命名
                .setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
                .setColumnNaming(NamingStrategy.underline_to_camel).setInclude("sys_user") // 生成的表
                .setEntityLombokModel(true);
        // .setTablePrefix("tbl_"); // 表前缀
        ag.setStrategy(stConfig);
        // 4.包名策略
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.boot.bootlanuch")/// 父包名
                .setController("controller")
                .setEntity("entity")
                .setService("service")
                .setMapper("dao");
        ag.setPackageInfo(pkConfig);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper"
                        + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        ag.setCfg(cfg);
        ag.setTemplate(new TemplateConfig().setXml(null));

        // 5.整合配置
        ag.execute();
    }
}
