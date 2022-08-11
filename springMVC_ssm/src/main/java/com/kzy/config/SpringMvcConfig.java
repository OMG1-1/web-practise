package com.kzy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by IntelliJ IDEA.
 *
 * @author kobe
 * @date 2022/8/10
 * @time 21:59
 * @note SpringMVC配置类
 */
@Configuration
@ComponentScan("com.kzy.controller")
@EnableWebMvc  // 该注解十分强大（有 开启类型转换、…… 等功能）
public class SpringMvcConfig {
}
