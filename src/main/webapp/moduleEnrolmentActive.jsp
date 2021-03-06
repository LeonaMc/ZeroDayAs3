<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<meta charset="utf-8">
	<title>Module Enrolment</title>
	<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<form id="logoutForm" method="POST" action="${contextPath}/logout">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>
	</c:if></div>
<center>
	<h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
	<br /><br /><br />
	<h1>Student Area</h1>
	<br /><br /><br />
	<h3>
		<a href="/welcome">Back to Home</a> &nbsp;&nbsp;&nbsp;&nbsp;
		<a href="/listAllEnroledModules">Enrol in a Module</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="/listActiveEnrolledModules">Current Modules</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="/viewGrades">View Grades</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="/statistics">Statistics</a><br />
	</h3>
	</br> </br><br />
</center>

<div align="center">
	<table border="1" cellpadding="5" class="table table-striped">
		<caption>
			<center><h3>List of Active Modules</h3></center>
		</caption>
		<br />
		<tr>
			<th>ID</th>
			<th>Module</th>
			<th>School</th>
			<th>Module Coordinator</th>
			<th>Module Topic</th>
		</tr>
		<c:forEach var="module" items="${listEnrolledModules}">
			<tr>
				<td><c:out value="${module.id}" /></td>
				<td><c:out value="${module.module_name}" /></td>

				<td><c:out value="${module.school}" /></td>
				<td><c:out value="${module.coordinator.firstName}" /></td>
				<td><c:out value="${module.module_topic}" /></td>

			</tr>
		</c:forEach>


	</table>
	<form>
		<input type="hidden" name="${_csrf.parameterName}"
			   value="${_csrf.token}" />
	</form>
</div>
</body>
</html>
