package com.kzy.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;


/**
 * Created by IntelliJ IDEA.
 *
 * @author kobe
 * @date 2022/8/10
 * @time 19:13
 * @note JDBC配置类
 */
public class JdbcConfig {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String userName;
    @Value("${jdbc.password}")
    private String password;

    /**
     * 将dataSource对象交给spring管理
     *
     * @return 数据源对象
     */
    @Bean
    private DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        // 配置数据源的核心内容
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

        return dataSource;
    }

    /**
     * 开启事务处理
     *
     * @param dataSource 数据源对象
     * @return 实现定义的传播行为并负责事务同步处理的接口
     */
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
