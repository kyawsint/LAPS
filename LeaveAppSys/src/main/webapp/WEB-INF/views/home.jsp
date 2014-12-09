<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="borderColors.css">
<h1>Welcome to laps</h1>
<form:form method="POST" commandName="login" action="${pageContext.request.contextPath}/login/create.html" >
<table>
<tbody>
<tr>
<td>Username:</td>
<td><form:input path="userId" default=""/></td>
<td><form:errors path="userId" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Password:</td>
<td><form:input type="password" path="password" default=""/></td>
<td><form:errors path="password" cssStyle="color: red;"/></td>
</tr>
<tr>

<td><form:hidden path="roleName" default=""/></td>
<td><form:errors path="roleName" cssStyle="color: red;"/></td>
</tr>

<tr>
<td><input type="submit" value="Login" /></td>
<td ><p class="textBoxes"><c:out value="${invalidUser}"/></p></td>
<td></td>
</tr>
</tbody>
</table>
</form:form>

