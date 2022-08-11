package com.kzy.service;

import com.kzy.config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by IntelliJ IDEA.
 *
 * @author kobe
 * @date 2022/8/10
 * @time 20:32
 * @note emp业务层测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)  //Spring整合Junit的测试
@ContextConfiguration(classes = SpringConfig.class)  // 指定配置类，在spring环境中测试的所以选择SpringConfig
public class EmpServiceTest {
    @Autowired
    private EmpService empService;

    @Test
    public void testGetById() {
        /*↓正规测试需做<p>断言匹配</p>*/
        System.out.println(empService.getById(1));
    }

    @Test
    public void testGetAll() {
        System.out.println(empService.getAll());
    }
}
