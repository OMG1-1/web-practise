package com.kobe.web; /**
 * Created by IntelliJ IDEA.
 *
 * @author kobe
 * @Date 2022/7/15
 * @Time 12:47
 * @Note ……
 */

import com.kobe.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveByIdServlet extends HttpServlet {
    EmpServiceImpl service = new EmpServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result = service.deleteById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("result", result);
        System.out.println(result);
        request.getRequestDispatcher("/jsp/resultEmpOptional.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
