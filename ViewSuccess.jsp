<%@page import="bank_application.BankAccountBean"%>
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
BankAccountBean bab = (BankAccountBean)request.getAttribute("bankBean");
out.println("Account Number : "+bab.getAcno()+"<br>");
out.println("Account Holder Name : "+bab.getName()+"<br>");
out.println("Account Balance : "+bab.getBalance()+"<br>");

%>
<%@include file="View.html" %>
</body>
</html>