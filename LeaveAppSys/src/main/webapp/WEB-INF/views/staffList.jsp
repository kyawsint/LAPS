<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Staff List page</h1>
<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
<td>Staff Id</td>
<td>Student Name</td>

<td>Edit/Delete</td>
</thead>
<tbody>
<c:forEach var="staff" items="${staffList}">
<tr>
<td>${staff.staffid}</td>
<td>${staff.staff_name}</td>

<td>
<a href="${pageContext.request.contextPath}/staff/edit/${staff.staffid}.html">Edit</a><br/>
<a href="${pageContext.request.contextPath}/staff/delete/${staff.staffid}.html">Delete</a><br/>
</td>
</tr>
</c:forEach>
</tbody>
</table>
<a href="${pageContext.request.contextPath}/">Home page</a>

</body>
</html>