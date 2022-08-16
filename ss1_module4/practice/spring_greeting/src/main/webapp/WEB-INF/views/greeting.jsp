<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/15/2022
  Time: 10:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/view" method="post">
    <input type="text" name="name" placeholder="nhập tên">
    <button type="submit">display</button>
</form>
<h2>${name}</h2>
</body>
</html>
