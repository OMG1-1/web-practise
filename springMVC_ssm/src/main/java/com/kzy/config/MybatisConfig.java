package com.kzy.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * Created by IntelliJ IDEA.
 *
 * @author kobe
 * @date 2022/8/10
 * @time 19:13
 * @note MyBatis配置类
 */
public class MybatisConfig {
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        // 配置数据源与sessionFactory管理
        ssfb.setDataSource(dataSource);
        // 类型别名扫描包声明
        ssfb.setTypeAliasesPackage("com.kzy.domain");
        return ssfb;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        // 配置映射扫描的包位置
        msc.setBasePackage("com.kzy.dao");
        return msc;
    }
}
