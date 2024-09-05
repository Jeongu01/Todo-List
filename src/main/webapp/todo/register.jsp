<%--
  Created by IntelliJ IDEA.
  User: kimjeongu
  Date: 9/4/24
  Time: 5:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register 등록 화면</title>
</head>
<body>
    <form action="/todo/register" method="post">
        <div><input type="text" placeholder="INSERT TITLE" name="title"/></div>
        <div><input type="date" name="date"/></div>
        <div><button type="reset">RESET</button>
        <button type="submit">REGISTER</button></div>
    </form>
</body>
</html>
