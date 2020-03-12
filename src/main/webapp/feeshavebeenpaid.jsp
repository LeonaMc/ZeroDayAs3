<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<html>
<head>
    <meta charset="utf-8">
    <title>Fees Paid</title><br /><br /><br />
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </c:if></div>
<center>
<h1>Fees Paid</h1>
<p>Your fees have already been paid, you can now enrol in modules.</p>
    <br /><br /><br />
   <h3><a href="/welcome">Back to Home</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="/listAllEnroledModules">Enrol in a Module</a></h3>

</center>
</body>
</html>