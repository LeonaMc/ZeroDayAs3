<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<html>
<head>
    <meta charset="utf-8">
    <title>Fees Paid</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<body>

<center>
<h1>Fees Paid</h1>
<p>Your fees have already been paid, you can now enrol in modules.</p>

    <a href="/welcome">Back to Home</a>
    <a href="/moduleEnrolment">Enrol in a Module</a>

</center>
</body>
</html>