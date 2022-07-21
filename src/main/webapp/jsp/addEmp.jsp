<%--
  Created by IntelliJ IDEA.
  User: 寇帅帅
  Date: 2022/7/14
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/baseWebApp/empAddOne" method="post">
        <label>name:</label><span style="width: 100px"></span>
        <input name="name">
        <br>
        <label>age:</label><span style="width: 100px"></span>
        <input name="age">
        <br>
        <label>job:</label><span style="width: 100px"></span>
        <input name="job">
        <br>
        <label>salary:</label><span style="width: 100px"></span>
        <input name="salary">
        <br>
        <label>entryDate:</label><span style="width: 100px"></span>
        <input type="date" name="entryDate"/>
        <br>
        <label>manageId:</label><span style="width: 100px"></span>
        <input name="manageId">
        <br>
        <label>deptId:</label><span style="width: 100px"></span>
        <input name="deptId">
        <br>
        <button type="submit">commit</button>
        <span style="width: 100px"></span>
        <button type="reset">reset</button>
    </form>
</body>
</html>
