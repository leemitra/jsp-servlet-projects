<%@page import="com.test.entity.UserDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update user</title>

<!-- <link rel="stylesheet" type="text/css" href="css/style.css" /> -->
<style type="text/css">
	<%@include file="../css/style.css"  %>
</style>
</head>
<body>
<div class="container">

<%
UserDetails user= (UserDetails)request.getAttribute("user");

%>
<form action="updateAction.jsp" method="post" >
<table>
<tr><td>Id</td><td> <%=user.getId()%> <input type="hidden" value="<%=user.getId()%>" name="id"> </td> </tr>
<tr><td>Full name</td><td><input type="text" name="fullName" value="<%=user.getFullName()%>" >  </td> </tr>
<tr><td>user name</td><td><input type="text" name="username" value="<%=user.getUsername()%>"> </td> </tr>
<tr><td>password:</td><td><input type="text" name="password" value="<%=user.getPassword()%>" >  </td> </tr>
<tr><td>Phone:</td><td><input type="text" name="phone" value="<%=user.getPhone()%>" > </td> </tr>
<tr><td>Email:</td><td> <input type="text" name="email" value="<%=user.getEmail()%>" > </td> </tr>
<tr><td></td><td> <input type="submit" value="update"></td> </tr>
</table>
</form>
</div>
</body>
</html>