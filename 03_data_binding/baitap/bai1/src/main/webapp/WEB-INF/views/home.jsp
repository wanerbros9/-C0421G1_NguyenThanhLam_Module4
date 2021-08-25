<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="" method="post">
    <table>
        <tr>
            <td>Languages:</td>
            <td>${email.languages}</td>
        </tr>
        <tr>
            <td>Page Size:</td>
            <td>${email.pageSize}</td>
        </tr>
        <tr>
            <td>Spam Filter:</td>
            <td>${email.spamsFilter}</td>
        </tr>
        <tr>
            <td>Signature:</td>
            <td>${email.signature}</td>
        </tr>
    </table>
    <input type="submit" value="Update">
</form>
</body>
</html>
