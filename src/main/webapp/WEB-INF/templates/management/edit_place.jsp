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
    <h1 class="text-center">Edit place ${name}</h1>
    <form:form method="post" modelAttribute="place">
        <hidden path="id" />
        <label for="placeName" class="form-label"><b>Name:</b></label>
        <input name="name" type="text" class="form-control" id="placeName" value="${place.name}"/>
        <label for="placeDescription" class="form-label"><b>Description</b></label>
        <textarea name="description"  class="form-control" id="placeDescription" rows="3">${place.description}</textarea>
        <label for="placeLocation" class="form-label"><b>Location:</b></label>
        <input name="location" type="text" class="form-control" id="placeLocation" value="${place.location}"/>
        <br>
        <button class="btn btn-success bg-dark text-success" type="submit">Submit changes</button>
    </form:form>
</div>
</body>
</html>