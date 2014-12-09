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
<td><b>Leave ID<b></td>
<td><b>Leave Date</b></td>
<td><b>Status</b></td>
<td colspan="2"><b>Options</b></td>
</tr>
</thead>
<c:forEach var="claimsList" items="${claimsList}">
<tr>
<td>${claimsList.leaveID}</td>
<td>${claimsList.fromDate}</td>
<td>${claimsList.leaveStatus}</td>
<c:if test="${claimsList.leaveStatus!='Cancelled'}">

<td><c:if test="${claimsList.leaveStatus!='Approved'}"><a href="${pageContext.request.contextPath}/claim/edit/${claimsList.leaveID}.html">Edit</a></c:if></td>

<td><a href="${pageContext.request.contextPath}/claim/delete/${claimsList.leaveID}.html">Cancel Leave</a></td>
</c:if>
<%--
<td>
<a href="${pageContext.request.contextPath}/student/edit/${student.id}.html">Edit</a><br/>
<a href="${pageContext.request.contextPath}/student/delete/${student.id}.html">Delete</a><br/>
</td>--%>
</tr>
</c:forEach>
</table>
</body>
<a href="${pageContext.request.contextPath}/DashBoard">Home page</a>
</html>