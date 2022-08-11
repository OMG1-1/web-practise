package com.kobe.web.servlet.old; /**
 * Created by IntelliJ IDEA.
 *
 * @author kobe
 * @Date 2022/7/15
 * @Time 10:37
 * @Note ……
 */

import com.kobe.pojo.Emp;
import com.kobe.service.impl.EmpServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

public class QueryByIdEmpServlet extends HttpServlet {
    EmpServiceImpl service = new EmpServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Emp byId = service.selectById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("byId",byId);
        request.getRequestDispatcher("/jsp/modifyEmp.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
