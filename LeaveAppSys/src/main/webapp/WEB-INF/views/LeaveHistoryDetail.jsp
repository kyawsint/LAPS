<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detail Of Leave History</title>
</head>
<body>


	<form:form method="POST" commandName="leavedetail"
		action="${pageContext.request.contextPath}/LeaveHistory/List/${leavedetail.staffID},${leavedetail.leaveID}.html }">
		<table cellpadding="5">
			<caption>Detail of Leave History</caption>
			<tr>
				<td>Leave ID</td>
				<td>${leavedetail.leaveID}</td>
			</tr>
			<tr>
				<td>Staff ID</td>
				<td>${leavedetail.staffID}</td>
			</tr>
			<tr>
				<td>From Date</td>
				<td>${leavedetail.fromDate}</td>
			</tr>
			<tr>
				<td>No Of Days</td>
				<td>${leavedetail.noOfDays}</td>
			</tr>
			<tr>
				<td>Leave Type ID</td>
				<td>${leavedetail.leaveTypeID}</td>
			</tr>
			<tr>
				<td>Leave Status</td>
				<td>${leavedetail.leaveStatus}</td>
			</tr>
			<tr>
				<td>Contact Address</td>
				<td>${leavedetail.contactAddress}</td>
			</tr>
			<tr>
				<td>Comments</td>
				<td>${leavedetail.comments}</td>
			</tr>
			<tr>
				<td>Reason For Leave</td>
				<td>${leavedetail.reasonForLeave}</td>
			</tr>
			<tr>
			<c:if test="${leavedetail.leaveStatus=='Cancelled'}">
				<td><input type="submit" name="Close" value="Close" /></td>
					</c:if>
			</tr>
			<tr>
			<c:if test="${leavedetail.leaveStatus=='Approved'}">
				<td><input type="submit" name="Close" value="Close" /></td>
					</c:if>
			</tr>
			<tr>
			<c:if test="${leavedetail.leaveStatus=='Rejected'}">
				<td><input type="submit" name="Close" value="Close" /></td>
					</c:if>
			</tr>
			
			<tr>
				<c:if test="${leavedetail.leaveStatus=='Applied' }">
				<td><input type="submit" name="Approve" value="Approve" /></td>
				<td><input type="submit" name="Reject" value="Reject" /></td>
				<td><input type="submit" name="Close" value="Close" /></td>
				</c:if>
			</tr>
			<tr>
				<c:if test="${leavedetail.leaveStatus=='Updated' }">
				<td><input type="submit" name="Approve" value="Approve" /></td>
				<td><input type="submit" name="Reject" value="Reject" /></td>
				<td><input type="submit" name="Close" value="Close" /></td>
				</c:if>
			</tr>
		</table>
		
	</form:form>


	

	
</body>
</html>