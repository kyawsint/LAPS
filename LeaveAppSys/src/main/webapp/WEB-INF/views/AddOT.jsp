<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1>Add Over time</h1>
<form:form method="POST" commandName="otime" action="${pageContext.request.contextPath}/otime/create.html" >
<table>
<tbody>
<tr>
<td><form:hidden path="otid" /></td>
<td><form:errors path="otid" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Staff Id:</td>
<td><form:input path="staffid" value="${staffid}" readonly="true"/></td>
<td><form:errors path="staffid" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Date worked:</td>

<td><form:input  path="otdate"  type="date"/></td>
<td><form:errors path="otdate" cssStyle="color: red;"/></td>
<td></td>
</tr>

<tr>
<td>Total OT hours:</td>
<td><form:input path="noOfHours" /></td>
<td><form:errors path="noOfHours" cssStyle="color: red;"/></td>
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
