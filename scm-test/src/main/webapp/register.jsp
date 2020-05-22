<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<style type="text/css">
<%@include file="../css/style.css" %>

</style>

</head>
<body>

<div class="container">
<h2 style="text-align: center;" >User Registeration</h2>
<form action="registerAction.jsp" method="post">
<div class="row" > 
<div class="col">
<!-- left part -->
</div>
<div class="col" > 
<table>
<tr><td>Full name</td><td><input type="text" name="fullName"> </td> </tr>
<tr><td>Username :</td><td><input type="text" name="username"> </td> </tr>
<tr><td>Password:</td><td><input type="password" name="password"> </td> </tr>
<tr><td>Email :</td><td><input type="text" name="email" > </td> </tr>
<tr><td>Phone: </td><td><input type="text" name="phone" > </td> </tr>
<tr><td></td><td><input type="submit" value="Register"> </td> </tr>

</table>
</div>
</div>
</form>
</div>


</body>
</html>