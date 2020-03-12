<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Enter a grade</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<body>
<center>
    <h1>Staff Area</h1>
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

<div class="container">
    <form:form method="POST" modelAttribute="newgrade" class="form-signin">
        <caption>
            <center>
                <h3 style="color:#808080">Add New Grade</h3>
                <br />
            </center>
        </caption>



        <spring:bind path="studentID">
            <div >
                <form:input type="number" path="studentID" class="form-control" placeholder="Student ID"
                            autofocus="true"></form:input>
            </div>
        </spring:bind>

        <spring:bind path="studentName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="studentName" class="form-control" placeholder="Student Name"></form:input>
                <form:errors path="studentName"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="module">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="module" class="form-control" placeholder="Module Name"></form:input>
                <form:errors path="module"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="grade">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="number" path="grade" class="form-control" placeholder="Student's Grade"></form:input>
                <form:errors path="grade"></form:errors>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>

    </form:form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
