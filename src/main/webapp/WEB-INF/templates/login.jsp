<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Login</title>
    <link href="/resources/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/common.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="${pageContext.request.contextPath}/login" method="post" class="form-signin">
        <h2 class="form-heading">Login</h2>
        <div class="form-group">
            <h3 class="text-left text-danger">${error}</h3>
            <h3 class="text-left text-success">${message}</h3>
            <input name="email" type="email" class="form-control" placeholder="Your email"/>
            <input name="password" type="password" class="form-control" placeholder="Your password" />
            <button class="btn btn-lg btn-success btn-block bg-dark text-success" type="submit">Login</button>
            <h4 class="text-center"><a href="/registration" class="text-success">Create an account</a></h4>
        </div>
    </form>
</div>
</body>
</html>

