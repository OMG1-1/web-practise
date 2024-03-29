package com.kobe.service.impl;

import com.kobe.dao.EmpMapper;
import com.kobe.pojo.Emp;
import com.kobe.pojo.PageBean;
import com.kobe.service.EmpService;
import com.kobe.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 *
 * @author kobe
 * @Date 2022/7/14
 * @Time 12:15
 * @Note ……
 */
public class EmpServiceImpl implements EmpService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSession();

    @Override
    public List<Emp> selectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = mapper.selectAll();
        sqlSession.close();
        return emps;
    }

    @Override
    public Emp selectById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp byId = mapper.selectById(id);
        sqlSession.close();
        return byId;
    }

    @Override
    public String addOne(Emp emp) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        mapper.insertOne(emp);
        sqlSession.commit();
        sqlSession.close();
        return "success";
    }

    @Override
    public String updateById(Emp byId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        if (mapper.selectById(byId.getId()) != null) {
            mapper.updateById(byId);
            sqlSession.commit();
            sqlSession.close();
            return "success";
        } else {
            sqlSession.close();
            return "this id not found, failed!";
        }
    }

    @Override
    public String deleteById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        if (mapper.deleteById(id) != 0) {
            sqlSession.commit();
            sqlSession.close();
            return "success";
        } else {
            sqlSession.close();
            return "this id not found, nothing optional!";
        }
    }

    @Override
    public String deleteByIds(int[] ids) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        if (mapper.deleteByIds(ids) != 0) {
            sqlSession.commit();
            sqlSession.close();
            return "success";
        } else {
            sqlSession.close();
            return "nothing optional!";
        }
    }

    @Override
    public PageBean<Emp> getPageAndConditionsData(int currentPage, int pageSize, Emp emp) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        int pageStartIndex = (currentPage - 1) * pageSize;
        PageBean<Emp> pageBean = new PageBean<>();
        if (null != emp) {
            emp.setName("%" + emp.getName() + "%");
            pageBean.setPageData(mapper.selectByPageAndConditionsData(pageStartIndex, pageSize, emp));
            pageBean.setCountData(mapper.selectByPageAndConditionsCount(pageStartIndex, pageSize, emp));
        } else {
            pageBean.setPageData(mapper.selectByPageData(pageStartIndex, pageSize));
            pageBean.setCountData(mapper.selectByPageCount());
        }
        sqlSession.close();
        return pageBean;
    }
}
