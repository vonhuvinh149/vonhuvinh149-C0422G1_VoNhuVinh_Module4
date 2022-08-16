<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/15/2022
  Time: 9:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
    <style>
        #validate:before {
            font-family: fontAwesome;
            content: 'vd:abcdxyz@gmail.com';
        }

        #validate.vld:before {
            font-family: fontAwesome;
            content: '\f00c';
            color: green;
        }
    </style>
</head>
<body>
<h3 style="color: red">${message}</h3>
<form action="/validate" method="post">
    <input type="text" name="email" onkeyup="validateEmail(this.value)" id="email">
    <span id="validate"></span>
    <p>
        <button type="submit">validate</button>
    </p>
</form>
<script>
    let validate = document.getElementById("validate");
    const valid = new RegExp('(?=.[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+))')

    function validateEmail(data) {
        if (valid.test(data)) {
            validate.classList.add('vld')
        } else {
            validate.classList.remove('vld')
        }
    }
</script>
</body>
</html>
