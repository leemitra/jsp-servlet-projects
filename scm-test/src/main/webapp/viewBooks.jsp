<%@page import="com.test.entity.BookDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.test.entity.UserDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style type="text/css">
<%@include file="../css/style.css" %>

</style>

</head>
<body>
<div class="container">

<h2 style="text-align: center;" >Library Management</h2>
<%
String userid = (String)session.getAttribute("userid");
if(userid == null){
	response.sendRedirect("index.jsp");
}
%>
<h2>Welcome <c:out value="${userid}"/>  to Admin home page</h2>
<p> <a href="admin.jsp">Add Books</a>&nbsp; <a href="viewBooks">View Books</a>&nbsp;   <a href="logout"> logout</a> </p>
<div style="margin-left: 50mm;" class="">
<table border="1">
<thead><tr>
<th>Book Name</th><th> Author Name</th><th>Edition</th><th>Number of Copies</th>
<th>Update</th><th>delete</th>
</tr></thead>
<c:forEach items="${books}" var="book">
<tr>
	<td>${book.bookName} </td><td>${book.bookAuthor}   </td>
	<td>${book.edition} </td>
	<td> ${book.numberOfCopies}   </td>
	<td><a href="updateBook?bookid=${book.bookId}">Update</a> </td>
	<td><a href="deleteBook?bookid=${book.bookId}">Delete</a> </td>
	</tr> 

</c:forEach>
 </table>
</div>
 
 </div>
</body>
</html>