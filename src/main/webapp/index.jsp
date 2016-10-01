<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FirstWebApp</title>

</head>
<body>
<p><%= request.getAttribute("userName")%></p>
<form action="formHandler" method="get">
    <input type="text" name="userName" value=""/>
    <input type="submit" name="ok" value="SEND"/>
</form>
</body>
</html>