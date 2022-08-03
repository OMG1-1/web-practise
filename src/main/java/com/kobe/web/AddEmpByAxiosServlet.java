package com.kobe.web;

import com.alibaba.fastjson.JSON;
import com.kobe.pojo.Emp;
import com.kobe.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 *
 * @author kobe
 * @Date 2022/7/21
 * @Time 23:46
 * @Note ……
 */

@WebServlet("/addEmpAxiosServlet")
public class AddEmpByAxiosServlet extends HttpServlet {
    EmpServiceImpl service = new EmpServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        // 用request.getParameter()接收不到数据，换用字符流的方式获取
        BufferedReader reader = request.getReader();
        String readLine = reader.readLine();
        // 序列化
        Emp emp = JSON.parseObject(readLine, Emp.class);
        System.out.println("emp = " + emp);
        // 结果返回
        String s = service.addOne(emp);
        response.getWriter().write(s);
        System.out.println("s = " + s);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
