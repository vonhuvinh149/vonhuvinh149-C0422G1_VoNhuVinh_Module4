<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/17/2022
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="declaration" action="">
    <table>
        <tr>Ho Va Ten <br>
            <td colspan="3"><form:input path="name">
            </form:input></td>
        </tr>
        <tr>
            <td>
                Nam sinh <br>
                <form:select path="birth" items="${birth}">
                </form:select>
            </td>
            <td>
                Gioi tinh <br>
                <form:select path="gender" items="${gender}">
                </form:select>
            </td>
            <td>Quoc tich <br>
                <form:select path="nationality" items="${nationality}">
                </form:select>
            </td>
        </tr>
        <tr>
<%--            <td colspan="3">số hộ chiếu hoặc chứng minh nhân dân(*)<br>--%>
<%--                <form:input path="id">--%>
<%--                </form:input>--%>
<%--            </td>--%>
        </tr>
    </table>
</form:form>
</body>
</html>
