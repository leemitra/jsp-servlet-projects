<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.test.entity.BookDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
<jsp:useBean id="book" class="com.test.entity.BookDetails" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="book"/>
<jsp:forward page="addBooks"></jsp:forward>

</body>
</html>