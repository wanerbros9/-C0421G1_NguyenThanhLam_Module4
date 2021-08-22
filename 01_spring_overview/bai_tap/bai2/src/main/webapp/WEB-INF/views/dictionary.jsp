<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Dictionary</h1>
<form method="post" action="/dictionary">
    <input type="text" name="word">
    <button type="submit">Convert</button>
</form>
<h1>
    <c:if test="${result != null}">
        ${result}
    </c:if>
</h1>
</body>
</html>
