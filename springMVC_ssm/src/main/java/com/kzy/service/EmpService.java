package com.kzy.service;

import com.kzy.domain.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author kobe
 * @date 2022/8/10
 * @time 19:09
 * @note emp业务层接口
 */
@Transactional(rollbackFor = Exception.class)
//开启事务， rollbackFor属性可以解决“该注解默认只在遇到运行时异常和Error时才会回滚，非运行时异常不回滚的问题”， rollbackFor = Exception.class表示Exception及其子类的异常都会触发回滚，同时不影响Error的回滚。详情见链接: https://www.jianshu.com/p/c5988db897fc
public interface EmpService {
    /**
     * 保存数据到emp表中
     *
     * @param emp emp对象
     * @return boolean
     */
    boolean save(Emp emp);

    /**
     * 按id删除emp表中数据
     *
     * @param id id
     * @return boolean
     */
    boolean delete(Integer id);

    /**
     * 更新emp表中的数据（按照id覆盖原始数据）
     *
     * @param emp emp对象
     * @return boolean
     */
    boolean update(Emp emp);

    /**
     * 获取emp表中所有数据
     *
     * @return emp对象列表
     */
    List<Emp> getAll();

    /**
     * 获取emp表中数据（按照id精准查找）
     *
     * @param id id
     * @return emp对象
     */
    Emp getById(Integer id);

    /**
     * 获取emp表中数据（按照id精准查找、错误异常测试方法）
     *
     * @param id id
     * @return emp对象
     */
    Emp getByIdTestError(Integer id);
}
