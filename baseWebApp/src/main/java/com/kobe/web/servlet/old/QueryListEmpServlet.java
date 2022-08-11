package com.kobe.web.servlet.old; /**
 * Created by IntelliJ IDEA.
 *
 * @author kobe
 * @Date 2022/7/14
 * @Time 12:06
 * @Note ……
 */


import com.kobe.pojo.Emp;
import com.kobe.service.impl.EmpServiceImpl;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class QueryListEmpServlet extends HttpServlet {
    EmpServiceImpl service = new EmpServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Emp> empList = service.selectAll();
        request.setAttribute("emps", empList);
        System.out.println(empList);
        request.getRequestDispatcher("/jsp/queryEmp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
