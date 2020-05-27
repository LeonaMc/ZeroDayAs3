<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8">
    <title>Add New Module</title>
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
        <a href="/list">List All Modules</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="/newgrade">Add Grade</a>&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="/listgrades">All Grades</a>&nbsp;&nbsp;&nbsp;&nbsp;
    </h3>
    <br /><br />
</center>

<div align="center">
    <form action="/staffWelcome" method="post">
        <table border="1" cellpadding="5" class="table table-striped">
            <caption>
                <center>
                <h3>
                    Edit Module
                </h3>
                </center>
            </caption>
            <input type="hidden" name="id" value="<c:out value='${module.id}' />"  />
            <tr>
                <th>Title: </th>
                <td>
                    <input type="text" name="module_name" size="45"
                           value="<c:out value='${module.module_name}' />"
                    />
                </td>
            </tr>

            <tr>
                <th>School: </th>
                <td>
                    <input type="text" name="school" size="45"
                           value="<c:out value='${module.school}' />"
                    />
                </td>
            </tr>

            <tr>
                <th>Module Coordinator: </th>
                <td>
                    <input type="text" name="module_coord" size="45"
                           value="<c:out value='${module.module_coord}' />"
                    />
                </td>
            </tr>

            <tr>
                <th>Module Topic: </th>
                <td>
                    <input type="text" name="module_topic" size="45"
                           value="<c:out value='${module.module_topic}' />"
                    />
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>

        </table>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

    </form>
</div>
        </c:if>
</div>
</body>
</html>