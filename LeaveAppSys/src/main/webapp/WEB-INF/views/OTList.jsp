<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<table border=1>
<thead>
<tr>
<td><b>OT ID</b></td>
<td><b>Over time date</b></td>
<td><b>No: of Hours worked</b></td>
<td><b>Staff id</b></td>
<td colspan="2"><b>Options</b></td>
</tr>
</thead>
<tbody>
<c:forEach var="otlist" items="${otlist}">
<tr>
<td>${otlist.otid}</td>
<td>${otlist.otdate}</td>
<td>${otlist.noOfHours}</td>
<td>${otlist.staffid}</td>
<td><a href="${pageContext.request.contextPath}/otime/edit/${otlist.otid}.html">Edit</a></td>
<td><a href="${pageContext.request.contextPath}/otime/delete/${otlist.otid}.html">Delete OT</a></td>
</tr>
</c:forEach>

</tbody>
</table>
</body>
<a href="${pageContext.request.contextPath}/DashBoard">Home page</a>
</html>