<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%--<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
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
       dateFormat: 'yyyy-MM-dd',
       onSelect: (function(dateText, inst) { 
           $('.date-picker').val(dateText);
       })
});
});

</script>
<script src="lib/jquery-2.1.1.min.js"></script>--%>
<h1>Add claim</h1>
<form:form method="POST" commandName="claim" action="${pageContext.request.contextPath}/claim/create.html" >
<table>
<tbody>
<tr>
<%--<td>Leave ID:</td> --%>
<td><form:hidden path="leaveID" /></td>
<td><form:errors path="leaveID" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Staff Id:</td>
<td><form:input path="staffID" value="${StaffId}" readonly="true"/></td>
<td><form:errors path="staffID" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>From date:</td>

<td><form:input  path="fromDate" type="date"/> </td>
<td><form:errors path="fromDate" cssStyle="color: red;"/></td>
<td></td>
</tr>
<tr>
<td>No Of days:</td>
<td><form:input path="noOfDays" /></td>
<td><form:errors path="noOfDays" cssStyle="color: red;"/></td><td>${claimCondition}</td>
</tr>
<tr>
<%--<td><form:hidden path="leaveTypeID" value="${param['leaveTypeID']}"/></td>--%>
<td><form:hidden path="leaveTypeID" value="${leaveTypeid}"/></td>
<td><form:errors path="leaveTypeID" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Leave name:</td>
<%-- <td><form:input path="leaveName" /></td>--%>
<td>${leaveName}</td>
<td><form:errors path="leaveName" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Staff name:</td>
<td>${claim.sn.staff_name}</td>
<td></td>
</tr> 

<tr>
<td>Total OT hours:</td>
<td><form:input path="totalOTHours" value="${totalOTHours}" readonly="true"/></td>
<td><form:errors path="totalOTHours" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>contactAddress:</td>
<td><form:input path="contactAddress" /></td>
<td><form:errors path="contactAddress" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>reasonForLeave:</td>
<td><form:input path="reasonForLeave" /></td>
<td><form:errors path="reasonForLeave" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Comments:</td>
<td><form:input path="comments" /></td>
<td><form:errors path="comments" cssStyle="color: red;"/></td>
</tr>
<tr>
<td><input type="submit" value="Create" /></td>
<td></td>
<td></td>
</tr>
</tbody>
</table>
</form:form>
<a href="${pageContext.request.contextPath}/DashBoard">Home page</a>
