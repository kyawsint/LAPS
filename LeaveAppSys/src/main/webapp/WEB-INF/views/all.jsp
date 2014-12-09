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
<h1>Staff List page</h1>
<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
<td>staffid</td>
<td>staff_name</td>
<td>userid</td>
<td>reportsTo</td>
<td>compOffConsumed</td>
<td>totalOTHours</td>
<td></td>
</thead>
<tbody>
<c:forEach var="x" items="${allstaff}">
<tr>
<td>${x.staffid}</td>
<td>${x.staff_name}</td>
<td>${x.userid}</td>
<td>${x.reportsTo}</td>
<td>${x.compOffConsumed}</td>
<td>${x.totalOTHours}</td>
<td>
<a href="${pageContext.request.contextPath}/student/edit/${student.id}.html">Approve</a><br/>
</td>
</tr>
</c:forEach>
</tbody>
</table>
<a href="${pageContext.request.contextPath}/">Home page</a>
</body>
</html>