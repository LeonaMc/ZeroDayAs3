<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create an account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>

<body>

<div class="container">
    <form:form method="POST" modelAttribute="payFees" class="form-signin">
        <h2 class="form-signin-heading">Input your card details</h2>

        <spring:bind path="cardNumber">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="cardNumber" class="form-control" placeholder="Card Number"
                            autofocus="true"></form:input>
                <form:errors path="cardNumber"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="securityCode">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="securityCode" class="form-control" placeholder="Security Code"></form:input>
                <form:errors path="securityCode"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="expireDate">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="expireDate" class="form-control" placeholder="Expiry Date"></form:input>
                <form:errors path="expireDate"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="cardName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="cardName" class="form-control" placeholder="Cardholders Name"></form:input>
                <form:errors path="cardName"></form:errors>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>

    </form:form>


</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>