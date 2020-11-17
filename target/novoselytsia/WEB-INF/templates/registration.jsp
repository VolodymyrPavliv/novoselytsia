<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Регістрація</title>

    <!-- Bootstrap Core CSS -->
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Theme CSS -->
    <link href="/resources/css/clean-blog.min.css" rel="stylesheet">
    <link href="/resources/css/common.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="container">
    <form:form action="/registration" method="post" modelAttribute="newUser" class="form-signin ">
        <h2 class="form-signin-heading">Реєстрація</h2>
        <form:input path="firstName" type="text" class="form-control" placeholder="Ім'я"/>
        <div class="text-left text-danger">
            <form:errors path="firstName" />
        </div>
        <form:input path="lastName" type="text" class="form-control" placeholder="Прізвище"/>
        <div class="text-left text-danger">
            <form:errors path="lastName" />
        </div>
        <form:input path="email" type="email" class="form-control" placeholder="Електронна пошта"/>
        <div class="text-left text-danger">
            <form:errors path="email" />
        </div>
        <form:input path="age" type="text" class="form-control" placeholder="Вік"/>
        <div class="text-left text-danger">
            <form:errors path="age" />
        </div>
        <form:input path="password" type="password" class="form-control" placeholder="Пароль" />
        <div class="text-left text-danger">
            <form:errors path="password" />
        </div>
        <button class="btn btn-lg btn-success btn-block bg-dark text-white" type="submit">Зареєструватися</button>
    </form:form>
</div>
<!-- jQuery -->
<script src="/resources/vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Contact Form JavaScript -->
<script src="/resources/js/jqBootstrapValidation.js"></script>
<script src="/resources/js/contact_me.js"></script>

<!-- Theme JavaScript -->
<script src="/resources/js/clean-blog.min.js"></script>
</body>
</html>

