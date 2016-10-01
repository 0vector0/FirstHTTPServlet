<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h1>List of users</h1>
<h2>hello</h2>


<c:forEach var="user"  items="${sessionScope.users}">
    <li>${user.login}</li>
</c:forEach>


</body>
</html>
