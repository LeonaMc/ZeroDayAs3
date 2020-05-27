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

<center>
<div id="content">
	<h3>Nationalities</h3>
	<br />
	<p>The following data represents the nationalities of staff and students:</p><br />

	<c:forEach items="${nationalitiesMap}" var="entry">
	${entry.value.size()} from ${entry.key} <br>
	</c:forEach>

</br> </br> </br>
	<h3>Gender</h3>
	<br />
	<p>The following data represents the number of male vs female students and staff:</p>
	<br /><br/>
	<p>Males: ${males}</p>
	<p>Females: ${females}</p>
</div>



</center>
</body>
</html>
