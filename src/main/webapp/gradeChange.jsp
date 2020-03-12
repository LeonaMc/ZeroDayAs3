<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8">
    <title>Grade Change Page</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<body>
<center>
    <h1>Grade Change</h1>
    <h2>
        <a href="/newgrade">Add New Grade Information</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/listgrades">List All Grades</a>

    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Grades</h2></caption>
        <tr>
            <th>Student ID</th>
            <th>Student Name</th>
            <th>Module</th>
            <th>Grade</th>
        </tr>
        <c:forEach var="grade" items="${listgrades}">
            <tr>
                <td><c:out value="${grade.studentID}" /></td>
                <td><c:out value="${grade.studentName}" /></td>
                <td><c:out value="${grade.module}" /></td>
                <td><c:out value="${grade.grade}" /></td>
                <td>
                    <a href="/grades/${grade.studentID}"/>Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/deletegrade/${grade.studentID}"  />Delete</a>
                </td>
            </tr>
        </c:forEach>


    </table>
    <form><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/></form>
</div>
</body>
</html>