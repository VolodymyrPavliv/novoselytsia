<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding post</title>
    <link href="/resources/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../sections/header.jsp"/>
<div class="container">
<div class="row m-2">
    <h1 class="text-center">Add new post</h1>
</div>
    <form:form action="/news/add" method="post" modelAttribute="newPost">
        <label for="title" class="form-label"><b>Title: </b></label>
        <form:input path="title" type="text" class="form-control" id = "title" placeholder="Enter title"/>

        <label for="title" class="form-label"><b>Text: </b></label>
        <form:textarea path="text" class="form-control" id = "text" placeholder="Enter text"/>
        <br>
        <button class="btn btn-success bg-dark text-success" type="submit">Add post</button>
    </form:form>
</div>
</body>
</html>
