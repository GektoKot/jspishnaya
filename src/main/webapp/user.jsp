
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Set"%>
<%@ page import="entity.User"%>
<%@ page import="entity.Pet"%>
<%@ page import="entity.Hobby"%>

<html>
<head>
   <title>Users</title>
</head>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<body>
   <h1>User</h1>

   <% User user = (User) request.getAttribute("user");%>
   <% Set<Pet> pets = (Set) user.getPet(); %>
   <% List<Hobby> hobbies = (List) user.getHobby(); %>
       <table>
           <thead>
               <tr>
                   <th>id</th>
                   <th>name</th>
                   <th>surname</th>
                   <th>pet</th>
                   <th>hobby</th>
               </tr>
           </thead>

               <tr>
                  <td><%= user.getId() %></td>
                  <td><%= user.getName() %></td>
                  <td><%= user.getSurname() %></td>
                  <% for (Pet pet : pets) { %>
                    <td><%= pet.getName() %></td>
                  <% } %>
                  <% for (Hobby hobby : hobbies) { %>
                    <td><%= hobby.getName() %></td>
                  <% } %>
               </tr>

       </table>
    <form action="${pageContext.request.contextPath}/user" method="post">
        <fieldset>
            <legend>update user</legend>
            <input type="hidden" name="user_id" value="<%= user.getId() %>"  type="text">
            <label>name<input name="name" value="<%= user.getName() %>"  type="text"></label>
            <label>surname<input name="surname" value="<%= user.getSurname() %>" type="text"></label>
            <label><input type="submit" name="button" value="update"></label>
            <label><input type="submit" name="button" value="delete"></label>
        </fieldset>

    </form>
    <form action="${pageContext.request.contextPath}/user" method="post">
       <fieldset>
          <legend>add hobby</legend>
          <input type="hidden" name="user_id" value="<%= user.getId() %>"  type="text">
          <label>hobby<input name="name" placeholder="hobby"  type="text"></label>
          <label><input type="submit" name="button" value="add_hobby"></label>
        </fieldset>
    </form>

    <form action="${pageContext.request.contextPath}/user" method="post">
            <fieldset>
                     <legend>add pet</legend>
                     <input type="hidden" name="user_id" value="<%= user.getId() %>"  type="text">
                     <label>pet name<input name="pet_name" placeholder="pet name"  type="text"></label>
                     <label><input type="submit" name="button" value="add_pet"></label>
            </fieldset>
    </form>

    <a href="/jspishnaya/users-list"> users-list</a>



</body>
</html>

