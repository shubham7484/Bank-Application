<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="bank_application.BankAccountBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
BankAccountBean aba = (BankAccountBean)session.getAttribute("BABean");
%>
<%@include file="loginsuccess.html" %>
</body>
</html>