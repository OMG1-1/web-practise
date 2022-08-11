package com.kzy.controller;

import com.kzy.domain.Emp;
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
    public boolean save(@RequestBody Emp emp) {
        return empService.save(emp);
    }

    /**
     * 按id删除emp表中数据
     *
     * @param id id
     * @return boolean
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Integer id) {
        return empService.delete(id);
    }

    /**
     * 更新emp表中的数据（按照id覆盖原始数据）
     *
     * @param emp emp对象
     * @return boolean
     */
    @PutMapping()
    public boolean update(@RequestBody Emp emp) {
        return empService.update(emp);
    }

    /**
     * 获取emp表中所有数据
     *
     * @return emp对象列表
     */
    @GetMapping()
    public List<Emp> getAll() {
        return empService.getAll();
    }

    /**
     * 获取emp表中数据（按照id精准查找）
     *
     * @param id id
     * @return emp对象
     */
    @GetMapping("/{id}")
    public Emp getById(@PathVariable Integer id) {
        return empService.getById(id);
    }
}
