package com.kzy.service.impl;

import com.kzy.dao.EmpDao;
import com.kzy.domain.Emp;
import com.kzy.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author kobe
 * @date 2022/8/10
 * @time 19:10
 * @note 业务层实现业务：业务的逻辑代码编写在此处书写
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;

    @Override
    public boolean save(Emp emp) {
        empDao.save(emp);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        empDao.delete(id);
        return true;
    }

    @Override
    public boolean update(Emp emp) {
        empDao.update(emp);
        return true;
    }

    @Override
    public List<Emp> getAll() {
        return empDao.getAll();
    }

    @Override
    public Emp getById(Integer id) {
        return empDao.getById(id);
    }
}
