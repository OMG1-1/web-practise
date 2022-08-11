package com.kobe.service;

import com.kobe.pojo.Emp;
import com.kobe.pojo.PageBean;

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

    /**
     * 根据id删除数据
     *
     * @param ids int[] ids
     * @return string
     */
    String deleteByIds(int[] ids);

    /**
     * 根据页面设置与查询条件动态获取表中数据
     *
     * @param currentPage 当前页码
     * @param pageSize 目前页的大小
     * @param emp 实体对象
     * @return 页面数据存储对象
     */
    PageBean<Emp> getPageAndConditionsData(int currentPage, int pageSize, Emp emp);

}
