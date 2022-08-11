<%--
  Created by IntelliJ IDEA.
  User: 寇帅帅
  Date: 2022/7/14
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addEmpResult</title>
</head>
<body>
<h1>${result}</h1>
<a href='/baseWebApp/empSelectAll'></a>
<script>
    var a = document.querySelector('a');
    var time = 5;
    timer();
    setInterval(timer, 1000)

    function timer() {
        if (time === 0) {
            location.href = '/baseWebApp/empSelectAll'
        } else {
            a.innerHTML = '将在' + time + '秒后跳转到EMP查询页面';
            time--;
        }
    }
</script>
</body>
</html>
