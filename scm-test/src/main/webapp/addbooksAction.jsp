<%@page import="java.util.Calendar"%>
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
<%
String seletedDate = request.getParameter("purchageDate1");
System.out.println(seletedDate);
SimpleDateFormat sd= new SimpleDateFormat("yyyy-MM-dd");
Calendar cal= Calendar.getInstance();
cal.setTime(sd.parse(seletedDate));
%>
 
<jsp:useBean id="book" class="com.test.entity.BookDetails" scope="request"></jsp:useBean>
<jsp:setProperty property="purchageDate" name="book" value="<%=cal%>" />
<jsp:setProperty property="*" name="book"/>
<jsp:forward page="addBooks"></jsp:forward>

</body>
</html>