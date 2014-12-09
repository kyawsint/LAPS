<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1>Edit claim</h1>
<form:form method="POST" commandName="claim" action="${pageContext.request.contextPath}/claim/edit/${claim.leaveID}.html" >
<table>
<tbody>
<tr>
<%--<td>Leave ID:</td> --%>
<td><form:hidden path="leaveID" /></td>
<td><form:errors path="leaveID" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Staff Id:</td>
<td><form:input path="staffID" readonly="true"/></td>
<td><form:errors path="staffID" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>From date:</td>

<td><form:input  path="fromDate" type="date" /></td>
<td><form:errors path="fromDate" cssStyle="color: red;"/></td>
<td></td>
</tr>
<tr>
<td>No Of days:</td>
<td><form:input path="noOfDays" /></td><td>${claimCondition}</td>
<td><form:errors path="noOfDays" cssStyle="color: red;"/></td>
</tr>
<tr>
<%--<td><form:select path="leaveTypeID" > <form:option value="${param['leaveTypeID']}"/></form:select></td> --%>
<td><form:hidden path="leaveTypeID" /></td>
<td><form:errors path="leaveTypeID" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Total OT hours:</td>
<td><form:input path="totalOTHours"  readonly="true"/></td>
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
<td>Status:</td>
<td><form:input path="leaveStatus" readonly="true"/></td>
<td><form:errors path="leaveStatus" cssStyle="color: red;"/></td>
</tr>
<tr>
<td><input type="submit" value="Update" /></td>
<td></td>
<td></td>
</tr>
</tbody>
</table>
</form:form>
<a href="${pageContext.request.contextPath}/DashBoard">Home page</a>
