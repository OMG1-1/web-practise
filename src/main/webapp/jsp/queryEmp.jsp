<%--
  Created by IntelliJ IDEA.
  User: 寇帅帅
  Date: 2022/7/14
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>selectEmpAllDataSet</title>
</head>
<body>
<input type="button" onclick='location.href=("/baseWebApp/jsp/addEmp.jsp")' value="add"/>
<br>
<hr>
<table border="1" cellspacing="0" width="1200">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>age</th>
        <th>job</th>
        <th>salary</th>
        <th>entryDate</th>
        <th>manageId</th>
        <th>deptId</th>
        <th>UPDATE</th>
        <th>DELETE</th>
    </tr>
    <c:forEach items="${emps}" var="e" varStatus="status">
        <tr align="center">
            <td>${status.count}</td>
            <td>${e.name}</td>
            <td>${e.age}</td>
            <td>${e.job}</td>
            <td>${e.salary}</td>
            <td>${e.entryDate}</td>
            <td>${e.manageId}</td>
            <td>${e.deptId}</td>
            <td>
                <input type="button" onclick='location.href=("/baseWebApp/empSelectById?id=${e.id}")' value="update"/>
            </td>
            <td>
                <input type="button" onclick='location.href=("/baseWebApp/empRemoveById?id=${e.id}")' value="delete"/>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<hr/>
</body>
</html>
