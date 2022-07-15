package com.kobe.service;

import com.kobe.pojo.Emp;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author kobe
 * @Date 2022/7/14
 * @Time 12:06
 * @Note ……
 */
public interface EmpService {
    /**
     * 查询Emp表所有数据
     *
     * @return 列表集合
     */
    List<Emp> selectAll();

    /**
     * 查询Emp表所有数据
     *
     * @param id Emp表 id
     * @return 列表集合
     */
    Emp selectById(int id);

    /**
     * 插入数据
     *
     * @param emp emp
     * @return string
     */
    String addOne(Emp emp);

    /**
     * 根据id修改数据
     *
     * @param byId emp
     * @return string
     */
    String updateById(Emp byId);

    /**
     * 根据id删除数据
     *
     * @param id id
     * @return string
     */
    String deleteById(int id);
}
