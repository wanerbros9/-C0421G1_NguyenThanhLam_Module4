<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="calculate">
    <label>Left Operand</label>
    <input type="text" name="leftOperand" value="0"><br>
    <label>Operator: </label>
    <select name="operator">
        <option value="addition">Addition</option>
        <option value="subtraction">Subtraction</option>
        <option value="multiple">Multiple</option>
        <option value="division">Division</option>
    </select><br>
    <label>Right Operand</label>
    <input type="text" name="rightOperand" value="0"><br>
    <input type="submit" value="Calculate">
</form>
<h3>
    <c:if test="${result != null}">
        Result : ${result};
    </c:if>
</h3>
</body>
</html>
