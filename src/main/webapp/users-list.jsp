
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List"%>
<%@ page import="entity.User"%>

<html>
<head>
   <title>Users</title>
</head>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<body>
   <h1>Users</h1>

<% List<User> users = (List) request.getAttribute("users"); %>
    <table>
        <thead>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>surname</th>
            </tr>
        </thead>
        <% for (User user : users) {%>
            <tr>
               <td><%= user.getId() %></td>
               <td><%= user.getName() %></td>
               <td><%= user.getSurname() %></td>
               <td><a href="/jspishnaya/user?user_id=<%= user.getId() %>"> settings</a></td>
            </tr>
        <% } %>
    </table>


    <form action="${pageContext.request.contextPath}/users-list" method="post">
    <fieldset>
        <legend>new user</legend>
        <label>name<input name="name" type="text" required></label>
        <label>surname<input name="surname" type="text" required></label>
        <input type="submit" name="save" value="save">
    </fieldset>
    </form>


</body>
</html>

