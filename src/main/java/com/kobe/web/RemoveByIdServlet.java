package com.kobe.web; /**
 * Created by IntelliJ IDEA.
 *
 * @author kobe
 * @Date 2022/7/15
 * @Time 12:47
 * @Note ……
 */

import com.kobe.pojo.Emp;
import com.kobe.service.impl.EmpServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

public class RemoveByIdServlet extends HttpServlet {
    EmpServiceImpl service = new EmpServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result = service.deleteById(Integer.parseInt(request.getParameter("id")));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
