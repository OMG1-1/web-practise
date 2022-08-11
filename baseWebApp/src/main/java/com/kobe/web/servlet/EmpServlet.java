package com.kobe.web.servlet;

import com.alibaba.fastjson.JSON;
import com.kobe.pojo.Emp;
import com.kobe.pojo.PageBean;
import com.kobe.service.EmpService;
import com.kobe.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author kobe
 * @date 2022/8/4
 * @time 10:28
 * @note ……
 * todo 解决跨源问题
 */
@WebServlet("/emp/*")
public class EmpServlet extends BaseServlet {

    EmpService service = new EmpServiceImpl();

    /**
     * 查询所有记录
     *
     * @param request  an {@link HttpServletRequest} object that
     *                 contains the request the client has made
     *                 of the servlet
     * @param response an {@link HttpServletResponse} object that
     *                 contains the response the servlet sends
     *                 to the client
     * @throws ServletException
     * @throws IOException
     */
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Emp> empList = service.selectAll();

        // 序列化
        String s = JSON.toJSONString(empList);
        System.out.println("s = " + s);
        // 中文数据处理，响应数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }

    /**
     * 删除一条记录
     *
     * @param request  an {@link HttpServletRequest} object that
     *                 contains the request the client has made
     *                 of the servlet
     * @param response an {@link HttpServletResponse} object that
     *                 contains the response the servlet sends
     *                 to the client
     * @throws ServletException
     * @throws IOException
     */
    public void removeOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result = service.deleteById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("result", result);
        System.out.println(result);

    }

    /**
     * 新增一条记录
     *
     * @param request  an {@link HttpServletRequest} object that
     *                 contains the request the client has made
     *                 of the servlet
     * @param response an {@link HttpServletResponse} object that
     *                 contains the response the servlet sends
     *                 to the client
     * @throws ServletException
     * @throws IOException
     */
    public void addOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        Emp emp = JSON.parseObject(reader.readLine(), Emp.class);
        String msg = service.addOne(emp);
        response.getWriter().write(msg);
    }

    /**
     * 修改一条记录
     *
     * @param request  an {@link HttpServletRequest} object that
     *                 contains the request the client has made
     *                 of the servlet
     * @param response an {@link HttpServletResponse} object that
     *                 contains the response the servlet sends
     *                 to the client
     * @throws ServletException
     * @throws IOException
     */
    public void modifyOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    }

    /**
     * 删除多条记录
     *
     * @param request  an {@link HttpServletRequest} object that
     *                 contains the request the client has made
     *                 of the servlet
     * @param response an {@link HttpServletResponse} object that
     *                 contains the response the servlet sends
     *                 to the client
     * @throws ServletException
     * @throws IOException
     */
    public void removeMultiple(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getRequestURI());

        BufferedReader reader = request.getReader();
        int[] ids = JSON.parseObject(reader.readLine(), int[].class);
        String msg = service.deleteByIds(ids);
        response.getWriter().write(msg);

        System.out.println("msg = " + msg);
    }

    /**
     * 根据条件查询记录
     *
     * @param request  an {@link HttpServletRequest} object that
     *                 contains the request the client has made
     *                 of the servlet
     * @param response an {@link HttpServletResponse} object that
     *                 contains the response the servlet sends
     *                 to the client
     * @throws ServletException
     * @throws IOException
     */
    public void getRecordsByCond(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getRequestURI());

        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));

        BufferedReader reader = request.getReader();
        Emp emp = JSON.parseObject(reader.readLine(), Emp.class);

        PageBean<Emp> pageBean = service.getPageAndConditionsData(currentPage, pageSize, emp);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(pageBean));

        System.out.println(JSON.toJSONString(pageBean));
    }
}
