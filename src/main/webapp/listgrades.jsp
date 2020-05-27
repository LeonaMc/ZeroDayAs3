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
<div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
    <form id="logoutForm" method="POST" action="${contextPath}/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
<center>
    <h1>Staff Area |  <a onclick="document.forms['logoutForm'].submit()">Logout</a></h1>
    <br /><br />
    <h3>
        <a href="/login">Back to Login</a> &nbsp;&nbsp;&nbsp;&nbsp;
        <a href="/new">Add New Module</a>&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="/list">List All Modules</a>&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="/newgrade">Add Grade</a>&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="/listgrades">All Grades</a>&nbsp;&nbsp;&nbsp;&nbsp;
    </h3>
    <br /><br />
</center>
<div align="center">
    <table border="1" cellpadding="5" class="table table-striped">
        <caption><center><h3>List of Grades</h3></center></caption>
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
                    <%--    <td>
                           <a href="/grades/${grade.studentID}"/>Edit</a>
                           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                           <a href="/deletegrade/${grade.studentID}"  />Delete</a>
                       </td> --%>
            </tr>
        </c:forEach>


    </table>
    <form><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/></form>
</div>
        </c:if>
</div>
</body>
</html>