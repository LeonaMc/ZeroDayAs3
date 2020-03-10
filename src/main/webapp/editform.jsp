<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="${contextPath}/resources/css/mainstyle.css">
    <title>Modules Store Application</title>
</head>
<body>
<center>
    <h1>Modules Management</h1>
    <h2>
        <a href="/new">Add New Module</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/list">List All Modules</a>

    </h2>
</center>
<div align="center">
    <form action="/staffWelcome" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Module
                </h2>
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
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>

        </table>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    </form>
</div>
</body>
</html>