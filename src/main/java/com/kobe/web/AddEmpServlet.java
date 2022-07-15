package com.kobe.web; /**
 * Created by IntelliJ IDEA.
 *
 * @author kobe
 * @Date 2022/7/14
 * @Time 16:54
 * @Note ……
 */

import com.kobe.pojo.Emp;
import com.kobe.service.impl.EmpServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddEmpServlet extends HttpServlet {
    EmpServiceImpl service = new EmpServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        System.out.println("lai la");
        Emp emp = new Emp();
        emp.setName("'" + request.getParameter("name") + "'");
        emp.setJob("'" + request.getParameter("job") + "'");
        emp.setAge(Integer.parseInt(request.getParameter("age")));
        emp.setDeptId(Integer.parseInt(request.getParameter("deptId")));
        emp.setManageId(Integer.parseInt(request.getParameter("manageId")));
        emp.setSalary(Integer.parseInt(request.getParameter("salary")));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            emp.setEntryDate((Date) formatter.parseObject(request.getParameter("entryDate")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String s = service.addOne(emp);
        request.setAttribute("result", s);
        System.out.println(s);
        request.getRequestDispatcher("/resultEmpOptional.jsp").forward(request, response);

    }
}
