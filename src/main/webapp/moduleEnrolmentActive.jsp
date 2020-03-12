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
<center>
	<h1>Module Management</h1>
	<h2>
		<a href="/moduleEnrolment">Back to Module Management</a> &nbsp;&nbsp;&nbsp; <a
			href="/listAllEnroledModules">Enrol in a Module</a>
	</h2>
	<h2>
		<a href="/listActiveEnrolledModules">View Current Modules</a>&nbsp;&nbsp;
		<a href="/statistics">Statistics</a><br />
	</h2>

	<h2>
		<a href="/welcome">Back to Home</a> &nbsp;&nbsp;&nbsp; <a
			href="/listAllEnroledModules">Enrol in a Module</a><br />
	</h2>

</center>

<div align="center">
	<table border="1" cellpadding="5">
		<caption>
			<h2>List of Active Modules</h2>
		</caption>
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
				<td><c:out value="${module.module_coord}" /></td>
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
