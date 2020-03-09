<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add new Grade Entry</title>
</head>
<body>
<center>
    <h1>Grade Change</h1>
    <h2>
        <a href="/newgrade">Add New Grade</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/listgrades">List All Grades</a>

    </h2>
</center>
<div align="center">
    <form action="/gradeChange" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2> Add New Grade</h2>
            </caption>
            <tr>
                <th>Student ID: </th>
                <td>
                    <input type="text" name="studentID" size="10"
                           value="<c:out value='${grade.studentID}' />"
                    />
                </td>
            </tr>

            <tr>
                <th>Student Name: </th>
                <td>
                    <input type="text" name="studentName" size="45"
                           value="<c:out value='${grade.studentName}' />"
                    />
                </td>
            </tr>

            <tr>
                <th>Module: </th>
                <td>
                    <input type="text" name="module" size="10"
                           value="<c:out value='${grade.module}' />"
                    />
                </td>
            </tr>

            <tr>
                <th>Grade: </th>
                <td>
                    <input type="text" name="grade" size="2"
                           value="<c:out value='${grade.grade}' />"
                    />
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>


        Choose your favorite subject:
        <button name="subject" type="submit" value="fav_HTML">HTML</button>
        <button name="subject" type="submit" value="fav_CSS">CSS</button>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>


    </form>
</div>
</body>
</html>
