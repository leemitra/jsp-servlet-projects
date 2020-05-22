<%@page import="java.util.List"%>
<%@page import="com.test.entity.UserDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home</title>
<style type="text/css">
<%@include file="../css/style.css" %>

</style>

</head>
<body>
<div class="container">
<%
String userid = (String)session.getAttribute("userid");
if(userid == null){
	response.sendRedirect("index.jsp");
}
%>
<h2>Welcome <%=userid%> to home page</h2>
<p> <a href="logout"> logout</a></p>

<table>
<tr><td>Sl.No </td><td>Name</td><td>Email</td><td>Phone</td> <td>Update/Delete</td>  </tr>
<%
List<UserDetails> users=(List<UserDetails>)session.getAttribute("list");
for(UserDetails user : users){
%>	
<tr><td><%=user.getId() %> </td><td><%=user.getFullName() %> </td><td> <%=user.getEmail()%></td><td><%=user.getPhone() %></td>
<td><a href="updateUser?userid=<%=user.getId()%>">Update</a> <a href="deleteUser?userId=<%=user.getId()%>">Delete</a> </td>
</tr>

<%	
}

%>
</table>

</div>
</body>
</html>