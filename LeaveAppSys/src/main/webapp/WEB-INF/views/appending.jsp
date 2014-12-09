<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>AppendingLeave List page</h1>

<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
<td>leaveID</td>
<td>staffName</td>
<td>fromDate</td>
<td>noOfDays</td>
<td>leaveStatus</td>
<td>contactAddress</td>
<td>comments</td>
<td>reasonForLeave</td>
<td></td>
<td></td>
<td></td>
</thead>
<tbody>
<c:forEach var="x" items="${allAppending}">
<tr>
<form action="aorr" method="POST">
<td>${x.leaveID}</td>
<td>${x.sd.staff_name}</td>
<td>${x.fromDate}</td>
<td>${x.noOfDays}</td>
<td>${x.leaveStatus}</td>
<td>${x.contactAddress}</td>
<td>${x.comments}</td>
<td>${x.reasonForLeave}</td>
<td><input type="hidden" value="${x.leaveID}" name="ID"/></td>
<td>
<select name="apply">
<option value="Approved">Approve</option>
<option value="Rejected">Reject</option>
</select>
</td>
<td><input type="submit" value="Submit"/></td>
</form>
</tr>
</c:forEach>
</tbody>
</table>
<a href="${pageContext.request.contextPath}/DashBoard">Home page</a>
</body>
</html>