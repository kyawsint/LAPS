<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Home page</h1>
<p>
Welcome to "Staff application".<br/>
<i>${message}</i><br/>
<c:url var="c" value="/staff/create.html" />
<c:url var="l" value="/staff/list" />

<a href="${c}">Create a new staff</a><br/>
<a href="${l}">View all staff</a><br/>

</p>

</body>
</html>