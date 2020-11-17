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

    <title>Редагування поста</title>

    <!-- Bootstrap Core CSS -->
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Theme CSS -->
    <link href="/resources/css/clean-blog.min.css" rel="stylesheet">

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
<!-- Navigation -->
<nav class="navbar navbar-default navbar-custom navbar-fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header page-scroll">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                Menu <i class="fa fa-bars"></i>
            </button>
            <a class="navbar-brand" href="<c:url value="/"/>">Новоселиця</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="<c:url value="/"/>">Головна</a>
                </li>
                <c:if test="${pageContext.request.isUserInRole('MANAGER')}">
                    <li>
                        <a href="<c:url value="/management"/>">Менеджмент</a>
                    </li>
                </c:if>
                <li>
                    <a href="<c:url value="/news"/>">Новини</a>
                </li>
                <li>
                    <a href="<c:url value="/places"/>">Місця</a>
                </li>
                <li>
                    <a href="<c:url value="/history"/>">Історія</a>
                </li>
                <li>
                    <a href="<c:url value="/profile"/>">Профіль</a>
                </li>
                <li>
                    <a href="<c:url value="/contact"/>">Контакти</a>
                </li>
                <li>
                    <a href="<c:url value="/logout"/>">Вихід</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->

    </div>
    <!-- /.container -->
</nav>

<!-- Page Header -->
<!-- Set your background image for this header on the line below. -->
<header class="intro-header" style="background-image: url('/images/update-bg.jpg')">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                <div class="site-heading">
                    <h1>Редагування поста</h1>
                    <hr class="small">
                    <span class="subheading">
                        Редагування поста про ${title}
                    </span>
                </div>
            </div>
        </div>
    </div>
    </div>
</header>

<div class="container">
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
        <form:form method="post" modelAttribute="newPost" enctype="multipart/form-data">
        <hidden path="id" />
        <label for="postTitle" class="form-label"><b>Заголовок: </b></label>
        <input name="title" type="text" class="form-control" id="postTitle" value="${post.title}"/>
        <div class="text-left text-danger">
            <form:errors path="title" />
        </div>
        <label for="postText" class="form-label"><b>Текст: </b></label>
        <textarea name="text"  class="form-control" id="postText" rows="3">${post.text}</textarea>
        <div class="text-left text-danger">
            <form:errors path="text" />
        </div>
        <br>
            <c:if test="${post.filename == null}">
                <lable id="file"><b>Додати зображення: </b></lable>
            </c:if>
            <c:if test="${post.filename != null}">
                <lable id="file"><b>Змінити зображення: </b></lable>
            </c:if>
            <input type="file" name="file" class="form-control"/>
            <h5 class="text-left text-danger">${fileError}</h5>
        <button class="btn btn-success bg-dark text-success" type="submit">Змінити зміни</button>
    </form:form>
        </div>
    </div>
</div>
<hr>

<!-- Footer -->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                <ul class="list-inline text-center">
                    <li>
                        <a href="#">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-twitter fa-stack-1x fa-inverse"></i>
                                </span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-facebook fa-stack-1x fa-inverse"></i>
                                </span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-github fa-stack-1x fa-inverse"></i>
                                </span>
                        </a>
                    </li>
                </ul>
                <p class="copyright text-muted">Novoselytsia &copy; 2020</p>
            </div>
        </div>
    </div>
</footer>

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
