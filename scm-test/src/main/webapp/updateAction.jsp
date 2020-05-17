<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="userData" class="com.test.entity.UserDetails" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="userData"/>
<jsp:forward page="updateUserDetails"></jsp:forward>
</body>
</html>