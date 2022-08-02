<%--
  Created by IntelliJ IDEA.
  User: 寇帅帅
  Date: 2022/7/15
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <title>modifyEmp</title>
        <style>
            label {
                width: 200px;
            }
        </style>
    </head>
    <body>
        <form action="/baseWebApp/empUpdateOne" method="post">
            <%--隐藏提交id，否则服务器500，空指针--%>
            <input typy="hidden" name="id" value="${byId.id}"/>
            <label>name:</label>
            <input name="name" value="${byId.name}"/>
            <br>
            <label>age:</label>
            <input name="age" value="${byId.age}"/>
            <br>
            <label>job:</label>
            <input name="job" value="${byId.job}"/>
            <br>
            <label>salary:</label>
            <input name="salary" value="${byId.salary}"/>
            <br>
            <label>entryDate:</label>
            <input type="date" name="entryDate" value="<fmt:formatDate value="${byId.entryDate}" pattern="yyyy-MM-dd" />"/>
            <br>
            <label>manageId:</label>
            <input name="manageId" value="${byId.manageId}"/>
            <br>
            <label>deptId:</label>
            <input name="deptId" value="${byId.deptId}"/>
            <br>
            <button type="submit">commit</button>
            <span style="width: 80px"></span>
            <button type="reset">reset</button>
        </form>
    </body>
</html>
