<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: HOME
  Date: 24/08/2021
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form:form modelAttribute="edit" action="/edit" method="post">
    <table>
        <tr>
            <td>Languages:</td>
            <td>
                <form:select path="languages">
                    <form:option value="English"></form:option>
                    <form:option value="Vietnamese"></form:option>
                    <form:option value="Japanese"></form:option>
                    <form:option value="Chinese"></form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Page Size:</td>
            <td>
                <form:select path="pageSize">
                    <form:option value="5"></form:option>
                    <form:option value="10"></form:option>
                    <form:option value="15"></form:option>
                    <form:option value="25"></form:option>
                    <form:option value="50"></form:option>
                    <form:option value="100"></form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Spams filter:</td>
            <td>
                <form:checkbox path="spamsFilter" value="true" />Enable spams filter
            </td>
        </tr>
        <tr>
            <td>Signature:</td>
            <td>
                <form:textarea path="signature"/>
            </td>
        </tr>
    </table>
    <input type="submit" value="Update">
    <input type="submit" value="Cancel">
</form:form>
</body>
</html>
