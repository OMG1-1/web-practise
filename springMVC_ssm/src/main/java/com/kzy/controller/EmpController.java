package com.kzy.controller;

import com.kzy.common.CommonConstant;
import com.kzy.domain.Emp;
import com.kzy.exception.BusinessException;
import com.kzy.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by IntelliJ IDEA.
 *
 * @author kobe
 * @date 2022/8/10
 * @time 19:08
 * @note 展现层：用来请求和响应的数据处理
 */
@RestController  //替代了@Controller与@ResponseBody
@RequestMapping("/emps")  //设置请求路径根路径
public class EmpController {
    @Autowired
    private EmpService empService;

    /**
     * 保存数据到emp表中
     *
     * @param emp emp对象
     * @return boolean
     */
    @PostMapping()
    public Result save(@RequestBody Emp emp) {
        boolean flag = empService.save(emp);
        return new Result(flag ? CommonConstant.SAVE_OK : CommonConstant.SAVE_ERR, String.valueOf(flag));
    }

    /**
     * 按id删除emp表中数据
     *
     * @param id id
     * @return boolean
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Integer id) {
        boolean flag = empService.delete(id);
        return new Result(flag ? CommonConstant.DELETE_OK : CommonConstant.DELETE_ERR, String.valueOf(flag));
    }

    /**
     * 更新emp表中的数据（按照id覆盖原始数据）
     *
     * @param emp emp对象
     * @return boolean
     */
    @PutMapping()
    public Result update(@RequestBody Emp emp) {
        boolean flag = empService.update(emp);
        return new Result(flag ? CommonConstant.UPDATE_OK : CommonConstant.UPDATE_ERR, String.valueOf(flag));
    }

    /**
     * 获取emp表中所有数据
     *
     * @return emp对象列表
     */
    @GetMapping()
    public Result getAll() {
        List<Emp> data = empService.getAll();
        int code = CommonConstant.GET_ERR;
        String msg = "查询失败，请稍后重新查询！";
        if ((null != data) && !"".equals(data.toString())) {
            msg = "查询成功！";
            code = CommonConstant.GET_OK;
        }
        return new Result(data, code, msg);
    }

    /**
     * 获取emp表中数据（按照id精准查找）
     *
     * @param id id
     * @return emp对象
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Emp data = empService.getById(id);
        int code = CommonConstant.GET_ERR;
        String msg = "查询失败，请检查查询的id是否存在！";
        if ((null != data) && !"".equals(data.toString())) {
            msg = "查询成功！";
            code = CommonConstant.GET_OK;
        }
        return new Result(data, code, msg);
    }

    /**
     * 获取emp表中数据（按照id精准查找、错误异常测试方法）
     * 示例：<a href="http://localhost:8080/ssm/emp/errortest/-1">...</a>
     * @param id id
     * @return emp对象
     */
    @GetMapping("/errortest/{id}")
    public Result getByIdTestError(@PathVariable Integer id) {
        Emp data = empService.getByIdTestError(id);
        int code = CommonConstant.GET_ERR;
        String msg = "查询失败，请检查查询的id是否存在！";
        if ((null != data) && !"".equals(data.toString())) {
            msg = "查询成功！";
            code = CommonConstant.GET_OK;
        }
        return new Result(data, code, msg);
    }
}
