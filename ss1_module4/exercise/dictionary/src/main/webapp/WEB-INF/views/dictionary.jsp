<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/15/2022
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/view" method="post">
    <input type="text" name="word" placeholder="nhập ......">
    <button type="submit">Dịch</button>
</form>
<h2>${result}</h2>
</body>
</html>
