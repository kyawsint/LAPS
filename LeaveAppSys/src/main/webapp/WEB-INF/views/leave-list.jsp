<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Leave List</title>
</head>
<body>
<h1>Leave List page</h1>
<a href="${pageContext.request.contextPath}/DashBoard">Home page</a>&nbsp;&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}/leave/create-leave.html">Apply Leave</a><br/><br/>
<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
<td>Staff ID</td>
<td>From Date</td>
<td>Number of Days</td>
<td>Leave Type</td>
<td>Status</td>
<td>Contact Address</td>
<td>Comments</td>
<td>Reason for leave</td>
</thead>
<tbody>
<c:forEach var="leave" items="${leaveList}">
<tr>
<td>${leave.staffId}</td>
<td>${leave.fromDate}</td>
<td>${leave.noOfDays}</td>
<td>${leave.leaveTypeId}</td>
<td>${leave.leaveStatus}</td>
<td>${leave.contactAddress}</td>
<td>${leave.comments}</td>
<td>${leave.reasonForLeave}</td>
<td>
<a href="${pageContext.request.contextPath}/leave/edit/${leave.leaveId}.html">Edit</a>
</td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>