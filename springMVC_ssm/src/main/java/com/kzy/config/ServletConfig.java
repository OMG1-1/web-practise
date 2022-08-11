package com.kzy.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by IntelliJ IDEA.
 *
 * @author kobe
 * @date 2022/8/10
 * @time 21:58
 * @note servlet配置类
 */
public class ServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 应用程序的根处理类
     * 读取Spring配置进应用程序
     *
     * @return SpringConfig.class
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    /**
     * 应用程序的web请求处理类
     * 读取SpringMVC配置
     * tip: 可以将上面的Spring配置信息放进SpringMVC中，但是一般分开管理较好一些
     * SpringMVC容器可以访问Spring容器（相当于父子容器，过程不可逆访问）
     *
     * @return SpringMvcConfig.class
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    /**
     * 拦截Tomcat的所有请求交给SpringMVC处理
     *
     * @return String[]
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
