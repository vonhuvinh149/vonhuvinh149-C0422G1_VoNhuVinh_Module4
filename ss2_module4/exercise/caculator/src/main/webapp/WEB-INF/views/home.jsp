<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/16/2022
  Time: 4:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/convert" method="post">
    <input type="number" name="number1" value="${number1}">
    <input type="number" name="number2" value="${number2}">
    <select name="select" id="">
        <option value="+">Addition(+)</option>
        <option value="-">Subtraction(-)</option>
        <option value="*">Multiplication(*)</option>
        <option value="/">Division(/)</option>
    </select>
    <button type="submit">Result</button>
</form>
<h3>Result: ${result}</h3>
</body>
</html>
