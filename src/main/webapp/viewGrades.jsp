<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8">
    <title>Student grades</title>
    <title>Fees Paid</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<body>
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
        <caption><center><h3>List of Grades</h3></center></caption>
        <br />
        <tr>
            <th>Student ID</th>
            <th>Student Name</th>
            <th>Module</th>
            <th>Grade</th>
        </tr>
        <c:forEach var="grade" items="${listGrades}">
            <tr>
                <td><c:out value="${grade.studentID}" /></td>
                <td><c:out value="${grade.studentName}" /></td>
                <td><c:out value="${grade.module}" /></td>
                <td><c:out value="${grade.grade}" /></td>
            </tr>
        </c:forEach>


    </table>
    <form><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/></form>
</div>
</body>
</html>