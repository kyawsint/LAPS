<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Leave List page</h1>
<table style="text-align: center;" border="2px" cellpadding="0" cellspacing="2" >
<thead>
<tr>
<td>Leave Id</td>
<td>Leave Name</td>
<%--
<td>Edit</td>
<td>Delete</td> --%>
<tr>

</thead>
<tbody>
<c:forEach var="leave" items="${list}">
<tr>
<td>${leave.typeid}</td>
<td>${leave.leaveName}</td>
<%--<td><a href="${pageContext.request.contextPath}/Admin/edit/${leave.typeid}">Update</a></td>
<td><a href="${pageContext.request.contextPath}/Admin/delete/${leave.typeid}">Delete</a></td> --%>
</tr>
</c:forEach>

<a href="${pageContext.request.contextPath}/type">Return To Home Page</a>
</tbody>
</table>

</body>
</html>