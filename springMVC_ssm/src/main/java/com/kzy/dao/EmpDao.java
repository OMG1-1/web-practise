package com.kzy.dao;

import com.kzy.domain.Emp;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author kobe
 * @date 2022/8/10
 * @time 19:10
 * @note 数据层接口方法定义与sql书写
 */
@Repository
public interface EmpDao {
    /**
     * 保存数据到emp表中
     *
     * @param emp emp对象
     */
    @Insert("insert into emp values (null,#{name},#{age},#{job},#{salary},#{entryDate},#{manageId},#{deptId})")
    void save(Emp emp);

    /**
     * 按id删除emp表中数据
     *
     * @param id id
     */
    @Delete("delete from emp where `id`= #{id}")
    void delete(Integer id);

    /**
     * 更新emp表中的数据（按照id覆盖原始数据）
     *
     * @param emp emp对象
     */
    @Update("update emp set `name`=#{name}, `age`=#{age}, `job`=#{job}, `salary`=#{salary}, `entrydate`=#{entryDate}, `manage_id`=#{manageId}, `dept_id`=#{deptId} where `id`=#{id}")
    void update(Emp emp);

    /**
     * 获取emp表中所有数据
     *
     * @return emp对象列表
     */
    @Select("select * from emp")
    List<Emp> getAll();

    /**
     * 获取emp表中数据（按照id精准查找）
     *
     * @param id id
     * @return emp对象
     */
    @Select("select * from emp where id = #{id}")
    Emp getById(Integer id);
}
