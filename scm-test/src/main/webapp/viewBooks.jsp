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
<h2>Welcome <%=userid%> to Admin home page</h2>
<p> <a href="admin.jsp">Add Books</a>&nbsp; <a href="viewBooks">View Books</a>&nbsp;   <a href="logout"> logout</a> </p>
<div style="margin-left: 50mm;" class="">
<table border="1">
<thead><tr>
<th>Book Name</th><th> Author Name</th><th>Edition</th><th>Number of Copies</th>
<th>Update</th><th>delete</th>
</tr></thead>
 <%
 List<BookDetails> books= (List<BookDetails>)  request.getAttribute("books");
 for(BookDetails book:books){
	 %>
	<tr>
	<td><%=book.getBookName()%> </td><td><%=book.getBookAuthor() %> </td>
	<td><%=book.getEdition()%> </td>
	<td><%=book.getNumberOfCopies()%> </td>
	<td><a href="updateBook?bookid=<%=book.getBookId()%>">Update</a> </td>
	<td><a href="deleteBook?bookid=<%=book.getBookId()%>">Delete</a> </td>
	</tr> 
<%	 
 }
 
 
 %>
 </table>
</div>
 
 </div>
</body>
</html>