<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/7/26
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>

    ${error}

    <br/>

    <form action="/login.html" method="post">
        用户名 : <input name="name"/><br/>
        密码 : <input type="password" name="password"/><br/>
        <input type="submit" value="登录"/>
        <input type="reset" value="重置"/>
    </form>

</body>

<script type="application/javascript" src="/js/jquery-1.12.1.min.js"></script>

</html>
