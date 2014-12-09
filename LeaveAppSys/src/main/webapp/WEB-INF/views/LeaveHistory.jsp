<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Leave History</title>
</head>
<body>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption>List of Leave History</caption>
			<tr>
				<th>Leave ID</th>
				<th>From Date</th>
				<th>No Of Days</th>
				<th>Leave Status</th>
			</tr>
			
			<c:forEach var="l" items="${leavelist}">
				<tr>
					<td>${l.leaveID}</td>
					<td>${l.fromDate}</td>
					<td>${l.noOfDays}</td>
					<td><a href="${pageContext.request.contextPath }/LeaveHistory/Detail/${l.leaveID}.html">${l.leaveStatus}</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<a href="${pageContext.request.contextPath}/DashBoard">Home page</a>
</body>
</html>