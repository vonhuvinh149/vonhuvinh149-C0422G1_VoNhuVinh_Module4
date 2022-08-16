<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/12/2022
  Time: 3:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body{
            display: flex;
            justify-content: center;
            align-items: center;
            background-image: radial-gradient(cornflowerblue,pink);
        }
        div{
            border-radius: 3px;
            border:1px solid white;
            text-align: center;
        }
    </style>
</head>
<body>
<div>
<form action="/result" method="post">
    <label for="usd">Chuyển đổi tiền </label><br>
    <input type="number" id="usd" name="money" value="0">(USD)<br>
    <button type="submit">chuyen doi</button>
</form>
<h1>${result} (VND)</h1>
</div>
</body>
</html>
