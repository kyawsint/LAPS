
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit page</title>
</head>
<body>

<h1>Update Hierarchy page</h1>
<form method="POST" action="${pageContext.request.contextPath}/Hierachy/edit/${type.staffid}" >
<table>
<tbody>
<tr>
<td>Staff ID:</td>
<td><input type="text" name="staffid" value="${type.staffid}"/></td>
</tr>

<tr>
<td>Staff Name:</td>
<td><input type="text" name="staff_name" value="${type.staff_name}"/></td>
</tr>
<tr>
<td>Reports To:</td>
<td>
<%-- <form:select path="staffid">
    <form:options items="${type}" itemvalue="type.reportsTo" itemlabel="type.staff_name" />
</form:select> --%>
<select  name="reportsTo" value="${type.reportsTo}">   
<option  value="4">Swee</option>  
<option  value="5">Robert</option>
<option value="0">Null</option> 
<input type="hidden"/>  
</select>  

</td>


<%-- <td><input type="text" name="reportsTo" value="${type.reportsTo}"/></td> --%>
</tr>

<tr>
<td><input type="submit" value="Update"  /><input type="Reset" value="Reset"  /></td>
</tr>


</tbody>
</table>
</form>


</body>
</html>