<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Registration</title>
    <link href="/resources/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/common.css" rel="stylesheet">

<body>
<div class="container">
    <form:form action="/registration" method="post" modelAttribute="newUser" class="form-signin ">
        <h2 class="form-signin-heading">Registration</h2>
        <form:input path="firstName" type="text" class="form-control" placeholder="First Name"/>
        <div class="invalid-feedback d-block">
            <form:errors path="firstName" />
        </div>
        <form:input path="lastName" type="text" class="form-control" placeholder="Last Name"/>
        <div class="invalid-feedback d-block">
            <form:errors path="lastName" />
        </div>
        <form:input path="email" type="email" class="form-control" placeholder="Email"/>
        <div class="invalid-feedback d-block">
            <form:errors path="email" />
        </div>
        <form:input path="age" type="text" class="form-control" placeholder="Username"/>
        <div class="invalid-feedback d-block">
            <form:errors path="age" />
        </div>
        <form:input path="password" type="password" class="form-control" placeholder="Password" />
        <div class="invalid-feedback d-block">
            <form:errors path="password" />
        </div>
        <button class="btn btn-lg btn-success btn-block bg-dark text-white" type="submit">Register</button>
    </form:form>
</div>
</body>
</html>

