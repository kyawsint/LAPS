<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Update Leave page</h1>
<form method="POST" action="${pageContext.request.contextPath}/Admin/edit/${type.typeid}" >
<table>
<tbody>
<tr>
<td>Leave ID:</td>
<td><input type="text" name="typeid" value="${type.typeid}"/></td>
</tr>

<tr>
<td>Leave Name:</td>
<td><input type="text" name="leaveName" value="${type.leaveName}"/></td>
</tr>

<tr>
<td><input type="submit" value="Update"  /><input type="Reset" value="Reset"  /></td>
</tr>


</tbody>
</table>
</form>



</body>
</html>