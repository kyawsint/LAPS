<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>List page</h1>
<table style="text-align: center;" border="2px" cellpadding="0" cellspacing="2" >
<thead>
<tr>
<td>Staff Id</td>
<td>Staff Name</td>
<td>ReportsTo</td>
<td>Edit</td>
<%--<td>Delete</td> --%>
<tr>

</thead>
<tbody>
<c:forEach var="hi" items="${list}">
<tr>
<td>${hi.staffid}</td>
<td>${hi.staff_name}</td>
<td>${hi.reportsTo}</td>
<td><a href="${pageContext.request.contextPath}/Hierachy/edit/${hi.staffid}">Edit</a></td>
<%--<td><a href="${pageContext.request.contextPath}/Hierachy/delete/${hi.staffid}">Delete</a></td> --%>
</tr>
</c:forEach>
<a href="${pageContext.request.contextPath}/reportsto">Return To Home Page</a>
</tbody>
</table>