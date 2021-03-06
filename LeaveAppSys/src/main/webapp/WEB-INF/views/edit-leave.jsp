<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Leave</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>

<script>
$(function() {
   $('.date-picker').datepicker( {
       changeMonth: true,
       changeYear: true,
       showButtonPanel: true,
       yearRange: "-35:+0",
       dateFormat: 'yy/mm/dd',
       onSelect: (function(dateText, inst) { 
           $('.date-picker').val(dateText);
       })
});
});
</script>
</head>
<body><h1>Edit Leave Type</h1>
<form:form method="POST" commandName="editleave" action="${pageContext.request.contextPath}/leave/edit/${leave.leaveId}.html">
<table>
<tbody>
<form:hidden path="leaveId"/>
<tr>
<td>Staff Name : </td>
<td>
<form:input path="staffId"/>
</td>
</tr>
<tr>
<td>From Date : </td>
<td><form:input path="fromDate" class="date-picker" placeholder="yyyy/mm/dd"/></td>
</tr>
<tr>
<td>No. of Days : </td>
<td><form:input path="noOfDays"/></td>
</tr>
<tr>
<td>Leave Type : </td>
<td>
<form:select path="leaveTypeId">
<c:forEach items="${leaveType}" var ="leaveNames">
<c:if test="${leaveNames.leaveName!='Compensation'}">
   <form:option value="${leaveNames.typeid}">${leaveNames.leaveName}</form:option>
   </c:if>
   </c:forEach>
</form:select>
</td>
</tr>
<tr>
<td><form:hidden path="leaveStatus"/></td>
</tr>
<tr>
<td>Contact Address : </td>
<td><form:input path="contactAddress"/></td>
</tr>
<tr>
<td>Comments : </td>
<td><form:input path="comments"/></td>
</tr>
<tr>
<td>Reason For Leave : </td>
<td><form:input path="reasonForLeave"/></td>
</tr>
<tr>
<td><input type="submit" value="Update" /></td>
<td><input type="button" value="Cancel"/></td>
</tr>
</tbody>
</table>
</form:form>
</body>
</html>