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
    <div align="center">
        <table border="1" cellpadding="5">
            <caption>List of Staff</caption>
            <tr>
                <th>Staff ID</th>
                <th>Staff Name</th>
            </tr>
            <c:forEach var="staff" items="${staffList}">
                <tr>
                    <td>${staff.staffid}</td>
                    <td><a href="${pageContext.request.contextPath }/LeaveHistory/List/${staff.staffid}.html">${staff.staff_name}</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <a href="${pageContext.request.contextPath}/DashBoard">Home page</a>
</body>
</html>