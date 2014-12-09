<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<h1>Staff Update </h1>
<form:form method="POST" commandName="staff" action="${pageContext.request.contextPath}/staff/edit/${staff.staffid}.html" >
<table>
<tbody>
<tr>
<td>staff name:</td>
<td><form:input path="staff_name" /></td>
<td><form:errors path="staff_name" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Staff user id:</td>
<td><form:input path="userid" /></td>
<td><form:errors path="userid" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>reportsTo:</td>
<td><form:input path="reportsTo" /></td>
<td><form:errors path="reportsTo" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Date of Birth</td>
<td><form:input path="dob" /></td>
<td><form:errors path="dob" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>address :</td>
<td><form:input path="address" /></td>
<td><form:errors path="address" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>contact no. :</td>
<td><form:input path="contactno" /></td>
<td><form:errors path="contactno" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>emailid :</td>
<td><form:input path="emailid" /></td>
<td><form:errors path="emailid" cssStyle="color: red;"/></td>
</tr>
<tr>
<td><input type="submit" value="update" /></td>
<td></td>
<td></td>
</tr>
</tbody>
</table>
</form:form>
<a href="${pageContext.request.contextPath}/">Home page</a>

</body>
</html>