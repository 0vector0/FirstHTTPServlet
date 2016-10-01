<%@ page import="entity.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h1>List of users</h1>
<h2>hello</h2>

<%

    List<User> list = (List<User>) request.getSession().getAttribute("users");
    for (User user : list) {
        out.println(user.getLogin());
    }


%>

<%--<p>${users}</p>--%>


<%--@elvariable id="users" type="java.util.List"--%>
<c:forEach var="user"  items="${sessionScope.users}">
    <p>${user.login}</p>
</c:forEach>


</body>
</html>
