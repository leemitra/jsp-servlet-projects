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
<%
BookDetails book = (BookDetails)request.getAttribute("book");
%>
<form action="updateBookAction.jsp" method="post" >
<table>
	 
	<tr><td>Book Name:</td><td>
	<input type="hidden" name="bookId" value="<%=book.getBookId()%>" >  
	<input type="text" name="bookName" value="<%=book.getBookName()%>" > </td></tr>
	<tr><td>Author Name:</td><td><input type="text" name="bookAuthor" value="<%=book.getBookAuthor() %>"> </td></tr>
	<tr><td>Price: </td><td><input type="text" name="bookPrice" value="<%=book.getBookPrice() %>"> </td></tr>
	<tr><td>ISBN  Number:</td><td><input type="text" name="bookNumber" value="<%=book.getBookNumber() %>"> </td></tr>
	<tr><td>Edition:</td><td><input type="text" name="edition" value="<%=book.getEdition() %>"> </td></tr>
<%-- 	<tr><td>Purchase Date:</td><td><input type="date" name="purchageDate1" value="<%=book.getPurchageDate()%>"> </td></tr> --%>
	<tr><td>Number of Copies:</td><td><input type="text" name="numberOfCopies" value="<%=book.getNumberOfCopies() %>"> </td></tr>
	<tr><td></td><td><input type="submit" value="Submit"> </td></tr>
</table>
</form>
</div>
 
 </div>
</body>
</html>