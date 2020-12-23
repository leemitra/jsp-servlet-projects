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
<script type="text/javascript">
function showBook() {
	  var x = document.getElementById("addBookDiv");
	  var y = document.getElementById("viewBookDiv");
	  var z = document.getElementById("usersList");
	  z.style.display="none";
	y.style.display="block";
	x.style.display="none";
}

function addBook() {
	  var x = document.getElementById("addBookDiv");
	  var y = document.getElementById("viewBookDiv");
	  var z = document.getElementById("usersList");
	  
	x.style.display="block";
	y.style.display="none";
	z.style.display="none";
}

function showUsersList() {
	  var x = document.getElementById("addBookDiv");
	  var y = document.getElementById("viewBookDiv");
	  var z = document.getElementById("usersList");
	  z.style.display="block";
		x.style.display="none";
		y.style.display="none";
}

</script>

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
<p> 
<button onclick="showUsersList()" >Users</button> 
<button onclick="showBook()">View Books</button>&nbsp; 
 <button onclick="addBook()">Add Books</button>&nbsp;
   <a href="logout"><button>logout</button> </a> </p>

<div style="margin-left: 50mm; display: none;" id="viewBookDiv">
<table border="1">
<thead><tr><th>Sl.No</th>
<th>Book Name</th><th> Author Name</th><th>Edition</th><th>Number of Copies</th>
<th>Update</th><th>delete</th>
</tr></thead>
<c:forEach items="${books}" var="book" varStatus="loop" >
<tr>
<td>${loop.count} </td>
	<td>${book.bookName} </td><td>${book.bookAuthor}   </td>
	<td>${book.edition} </td>
	<td> ${book.numberOfCopies}   </td>
	<td><a href="updateBook?bookid=${book.bookId}">Update</a> </td>
	<td><a href="deleteBook?bookid=${book.bookId}">Delete</a> </td>
	</tr> 

</c:forEach>
 </table>
</div>

<div style="margin-left: 50mm;  display: none;" id="addBookDiv">
<form action="addbooksAction.jsp" method="post">
<table>
	<tr><td>Book Name:</td><td><input type="text" name="bookName"> </td></tr>
	<tr><td>Author Name:</td><td><input type="text" name="bookAuthor"> </td></tr>
	<tr><td>Price: </td><td><input type="text" name="bookPrice"> </td></tr>
	<tr><td>ISBN  Number:</td><td><input type="text" name="bookNumber"> </td></tr>
	<tr><td>Edition:</td><td><input type="text" name="edition"> </td></tr>
	<tr><td>Purchase Date:</td><td><input type="date" name="purchageDate1"> </td></tr>
	<tr><td>Number of Copies:</td><td><input type="text" name="numberOfCopies"> </td></tr>
	<tr><td></td><td><input type="submit" value="Submit"> </td></tr>
</table>
</form>
</div>

<div  id="usersList">

<table>
<tr><td>Sl.No </td><td>Name</td><td>Email</td><td>Phone</td> <td>Update</td><td>Delete</td>  </tr>
<c:forEach items="${list}" var="user" varStatus="loop">
<c:choose >
<c:when test="${user.role.role eq 'USER'}">
<tr><td>${loop.index} </td><td>${user.fullName} </td><td>${user.email}</td>
<td>${user.phone}</td>
<td><a href="updateUser?userid=${user.id}">Update</a> </td>
<td><a href="deleteUser?userId=${user.id}">Delete</a> </td>
</tr>
</c:when>
</c:choose>
</c:forEach>

</table>
</div>
 
 </div>
</body>
</html>