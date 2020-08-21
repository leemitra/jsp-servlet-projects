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
<h2 style="text-align: center;">Library Management</h2>
<%
String userid = (String)session.getAttribute("userid");
if(userid == null){
	response.sendRedirect("index.jsp");
}
%>
<h2 style="text-align: right; text-transform: uppercase;"><a href="#"> <%=userid%></a></h2>

<p> 
<button onclick="showBooks()">Books</button>
<button onclick="showRequests()">My Books</button>
 <a href="logout"><button>logout</button> </a></p>
<div style="margin-left: 50mm;" id="viewBookDiv">
<table border="1">
<thead><tr><th>Sl.No</th>
<th>Book Name</th><th> Author Name</th><th>Edition</th><th>Number of Copies</th>
<th>Request Book</th>
</tr></thead>
<c:forEach items="${books}" var="book" varStatus="loop" >
<tr>
<td>${loop.count} </td>
	<td>${book.bookName} </td><td>${book.bookAuthor}   </td>
	<td>${book.edition} </td>
	<td> ${book.numberOfCopies}   </td>
	<td><a href="updateBook?bookid=${book.bookId}">Request</a> </td>
	</tr> 
</c:forEach>
 </table>
</div>

</div>
</body>
</html>