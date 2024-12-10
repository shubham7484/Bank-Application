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
String holderName = (String)request.getAttribute("msg");
out.println("Registration Successfull<br>");
out.println("Hello "+holderName+" welcome to Online Bank");
%>
<%@include file="login.html" %>
</body>
</html>