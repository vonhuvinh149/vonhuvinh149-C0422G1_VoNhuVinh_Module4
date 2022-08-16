<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/16/2022
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/covert" method="post">
    <c:forEach var="list" items="${stringList}">
        <span>
            <input type="checkbox" name="condiments" value="${list}">${list}
        </span>
    </c:forEach>
    <p>
        <button type="submit">Save</button>
    </p>
</form>
<p>${condiments}</p>
</body>
</html>
