<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding post</title>
    <link href="/resources/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="sections/header.jsp"/>
<div class="row m-2">
    <h1 class="text-center">Add new hotel</h1>
</div>
    <form:form action="/news/add" method="post" modelAttribute="newPost">
        <label for="title" class="form-label"><b>Title</b></label>
        <form:input path="title" type="text" class="form-control" id = "title" placeholder="Enter title"/>
        <div class="invalid-feedback d-block">
            <form:errors path="title" />
        </div>
        <label for="title" class="form-label"><b>Text</b></label>
        <form:input path="text" type="text" class="form-control" id = "text" placeholder="Enter text"/>
        <div class="invalid-feedback d-block">
            <form:errors path="text" />
        </div>
        <button class="btn btn-info" type="submit">Add Hotel</button>
    </form:form>
</body>
</html>
