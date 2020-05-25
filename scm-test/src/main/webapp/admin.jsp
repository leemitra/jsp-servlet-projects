<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String userid = (String)session.getAttribute("userid");
if(userid == null){
	response.sendRedirect("index.jsp");
}
%>
<h2>Welcome <%=userid%> to Admin page</h2>
<p> <a href="logout"> logout</a></p>

</body>
</html>