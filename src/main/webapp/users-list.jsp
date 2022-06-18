<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List"%>
<%@ page import="servletnaya.User"%>


<html>
<head>
   <title>Users</title>
</head>
<body>
   <h1>Users</h1>

<% List<User> users = (List) request.getAttribute("users"); %>
    <table>
    <% for (User user : users) {%>
        <tr>
           <td><%= user.getName() %></td>
           <td><%= user.getSureName() %></td>
        </tr>
    <% } %>
    </table>

</body>
</html>

