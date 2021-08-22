<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/calculate">
    <input type="text" name="usd">
    <button type="submit">Convert</button>
</form>
<h1>${usdCurrency}</h1>
</body>
</html>
