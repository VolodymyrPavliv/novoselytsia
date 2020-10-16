<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit post</title>
    <link href="/resources/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../sections/header.jsp"/>
<div class="container">
    <h1 class="text-center">Edit post about ${title}</h1>
    <form method="post" >
        <hidden path="id" />
        <label for="postTitle" class="form-label"><b>Title</b></label>
        <input name="title" type="text" class="form-control" id="postTitle" value="${post.title}"/>
        <label for="postText" class="form-label"><b>Text</b></label>
        <textarea name="text"  class="form-control" id="postText" rows="3">${post.title}</textarea>
        <br>
        <button class="btn btn-success bg-dark text-success" type="submit">Submit changes</button>
    </form>
</div>
</body>
</html>