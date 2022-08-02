package com.kobe.web; /**
 * Created by IntelliJ IDEA.
 *
 * @author kobe
 * @Date 2022/7/14
 * @Time 12:06
 * @Note ……
 */


import com.alibaba.fastjson.JSON;
import com.kobe.pojo.Emp;
import com.kobe.service.impl.EmpServiceImpl;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listEmpAxiosServlet")
public class QueryListEmpByAxiosServlet extends HttpServlet {
    EmpServiceImpl service = new EmpServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Emp> empList = service.selectAll();
        // 序列化
        String s = JSON.toJSONString(empList);
        System.out.println("s = " + s);
        // 中文数据处理，响应数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
