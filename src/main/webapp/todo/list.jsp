<%--
  Created by IntelliJ IDEA.
  User: kimjeongu
  Date: 9/4/24
  Time: 5:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Todo List</title>
</head>
<body>
<h1>Todo List</h1>
<h2>${appName}</h2>
<h2>${loginInfo}</h2>
<h3>${loginInfo.mname}</h3>
<%--    ${dtolist}--%>
<%--    ${dtolist[0].tno} --- ${dtolist[0].title} --- ${dtolist[0].dueDate}--%>
<ul>
    <c:forEach items="${dtoList}" var="dto">
        <li>
            <span><a href="/todo/read?tno=${dto.tno}">${dto.tno}</a></span>
            <span>${dto.title}</span>
            <span>${dto.dueDate}</span>
            <span>${dto.finished? "DONE": "NOT YET"}</span>
        </li>
    </c:forEach>
</ul>
<button type="button" name="logout">LOGOUT</button>
</body>
</html>
