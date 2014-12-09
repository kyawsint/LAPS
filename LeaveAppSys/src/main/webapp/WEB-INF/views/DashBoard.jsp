<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="Logout.jsp"%>
<fmt:setBundle basename="i18n/messages"/>
</head>
<body>
        <h1>Welcome <c:out value="${UserName}"/></h1>
        
        <c:if test="${sessionScope.roleName=='admin'}">
        <a href="${pageContext.request.contextPath}/type">Manage Leave types</a><br>
        <a href="${pageContext.request.contextPath}/staff/manage.html"">Manage Staff</a><br>
        
        <a href="${pageContext.request.contextPath}/reportsto">Manage approval hierarchy</a>
        </c:if>
        <c:if test="${sessionScope.roleName=='staff' || sessionScope.roleName=='manager'}">
        
        
        
        <a href="${pageContext.request.contextPath}/leave/leave-list.html">Manage Leave application</a><br>
        <c:url var="claimCreate" value="/claim/create.html">
        <%--<c:param name="leaveTypeID" value="1"></c:param> --%>
        </c:url>
        <a href="${claimCreate}">Claim compensation</a><br>
        <a href="${pageContext.request.contextPath}/claim/list.html">View Claims</a><br>
        <a href="${pageContext.request.contextPath}/otime/create.html">Add Overtime details</a><br>
        <a href="${pageContext.request.contextPath}/otime/list.html">View Overtime details</a><br>
        </c:if>
        <c:if test="${sessionScope.roleName=='manager'}">        
        <a href="${pageContext.request.contextPath}/staff/List.html">View Employee leave history</a><br>
         

          <a href="/laps/approveManagement/approve">View all the pendingLeave</a><br>
          <a href="/laps/LeaveHistory/gaofan_method">View all the Compensation PendingLeave</a>
        </c:if>
        <p>${message}</p>
        <%-- <h1>Hello request scope ${requestScope.username}</h1>
        <h1>Hello application scope ${applicationScope.username}</h1>--%>
    </body>
</html>