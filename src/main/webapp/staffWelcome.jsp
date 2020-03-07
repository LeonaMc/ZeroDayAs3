<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Staff Welcome Page</title>
</head>
<body>
<center>
    <h1>Welcome Staff</h1>
    <h2>
        <a href="/new">Add New Module</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/list">Module Management</a>

        <a href="/gradeChange">Change Grades</a>

    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Modules</h2></caption>
        <tr>
            <th>ID</th>
            <th>Module</th>
            <th>School</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="book" items="${listBooks}">
            <tr>
                <td><c:out value="${book.id}" /></td>
                <td><c:out value="${book.book_name}" /></td>

                <td><c:out value="${book.isbn}" /></td>
                <td>
                    <a href="/books/${book.id}"/>Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/delete/${book.id}"  />Delete</a>
                </td>
            </tr>
        </c:forEach>


    </table>
    <form><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/></form>
</div>
</body>
</html>