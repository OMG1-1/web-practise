package com.kobe.web.servlet.old; /**
 * Created by IntelliJ IDEA.
 *
 * @author kobe
 * @Date 2022/7/15
 * @Time 10:46
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

public class ModifyOneEmpServlet extends HttpServlet {
    EmpServiceImpl service = new EmpServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Emp byId = service.selectById(Integer.parseInt(request.getParameter("id")));
        byId.setName(request.getParameter("name"));
        byId.setJob(request.getParameter("job"));
        byId.setAge(Integer.parseInt(request.getParameter("age")));
        byId.setDeptId(Integer.parseInt(request.getParameter("deptId")));
        byId.setManageId(Integer.parseInt(request.getParameter("manageId")));
        byId.setSalary(Integer.parseInt(request.getParameter("salary")));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            byId.setEntryDate((Date) formatter.parseObject(request.getParameter("entryDate")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String s = service.updateById(byId);
        request.setAttribute("result", s);
        System.out.println(s);
        request.getRequestDispatcher("/jsp/resultEmpOptional.jsp").forward(request, response);
    }
}
