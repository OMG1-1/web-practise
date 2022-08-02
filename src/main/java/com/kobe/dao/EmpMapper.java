package com.kobe.dao;

import com.kobe.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author kobe
 * @Date 2022/7/14
 * @Time 12:05
 * @Note ……
 */
public interface EmpMapper {
    /**
     * 查询Emp表所有数据
     *
     * @return 列表集合
     */
    @Select("select * from emp")
    @ResultMap("emp")
    List<Emp> selectAll();

    /**
     * 查询Emp表所有数据
     *
     * @return 条数
     */
    @Select("select count(*) from emp where name = ${name}")
    int selectWithName(String name);

    /**
     * 向Emp表插入一条数据
     */
    @Insert("insert into emp values (null,#{name},#{age},#{job},#{salary},#{entryDate},#{manageId},#{deptId})")
    void insertOne(Emp emp);

    /**
     * 根据id查询Emp表中数据
     *
     * @param id emp表中id
     * @return 单个记录
     */
    @Select("select * from emp where id = ${id}")
    @ResultMap("emp")
    Emp selectById(int id);

    /**
     * 根据id修改Emp表中数据
     *
     * @param byId emp表要修改的记录
     */
    @Update("update emp set name=#{name},age=#{age},job=#{job},salary=#{salary},entrydate=#{entryDate},manage_id=#{manageId},dept_id=#{deptId} where id=#{id}")
    void updateById(Emp byId);

    /**
     * 根据id修改Emp表中数据
     *
     * @param id emp表中id
     * @return 删除记录数
     */
    @Delete("delete from emp where id = ${id}")
    int deleteById(int id);
}
