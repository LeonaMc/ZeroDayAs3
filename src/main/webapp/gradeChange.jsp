<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Grade Change Page</title>
</head>
<body>
<center>
    <h1>Grade Change</h1>
    <h2>
        <a href="/new">Add New Student</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/list">List All Modules</a>

        <a href="/gradeChange">List All Modules</a>

    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Books</h2></caption>
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