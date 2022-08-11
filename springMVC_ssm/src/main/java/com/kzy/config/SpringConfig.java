package com.kzy.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by IntelliJ IDEA.
 *
 * @author kobe
 * @date 2022/8/10
 * @time 19:11
 * @note spring配置文件
 */
@Configuration  //声明此类为配置类
@ComponentScan({"com.kzy.service"})  //该包目录下扫描出的bean放入容器
@PropertySource("classpath:jdbc.properties")  //加载配置文件
@Import({JdbcConfig.class, MybatisConfig.class})  //导入配置类
@EnableTransactionManagement  // 开启事务管理
public class SpringConfig {
}
