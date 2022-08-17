<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/17/2022
  Time: 9:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Settings</h1>
<form:form action="/saves" method="post" modelAttribute="email">
    <table>
        <tr>ll
            <td>Languages</td>
            <td><form:select path="languages" items="${language}">
            </form:select>
            </td>
        </tr>
        <tr>
            <td>Page Size</td>
            <td>Show
                <form:select path="pageSize" items="${pageSize}"></form:select>
                email per page
            </td>
        </tr>
        <tr>
            <td>Spam filter</td>
            <td>
                <form:checkbox path="spamsFilter" value="enable span filter"></form:checkbox>enable span filter
            </td>
        </tr>
        <tr>
            <td>signature</td>
            <td><form:textarea path="signature"></form:textarea></td>

        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit">save</button>
                <button type="button">cancel</button>
            </td>
        </tr>
    </table>

</form:form>
</body>
</html>
