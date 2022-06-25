
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List"%>
<%@ page import="entity.User"%>

<html>
<head>
   <title>Users</title>
</head>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<body>
   <h1>User</h1>

   <% User user = (User) request.getAttribute("user");%>
    <form action="${pageContext.request.contextPath}/user" method="post">
    <fieldset>
        <legend>update user</legend>
        <input type="hidden" name="user_id" value="<%= user.getId() %>"  type="text">
        <label>name<input name="name" value="<%= user.getName() %>"  type="text"></label>
        <label>surname<input name="surname" value="<%= user.getSurname() %>" type="text"></label>
        <label>age<input name="age" value="<%= user.getAge() %>" type="number"></label>
        <label><input type="submit" name="button" value="update"></label>
        <label><input type="submit" name="button" value="delete"></label>
    </fieldset>
    </form>

    <a href="/jspishnaya/users-list"> users-list</a>



</body>
</html>

