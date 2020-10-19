<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding place</title>
    <link href="/resources/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../sections/header.jsp"/>
<div class="container">
    <div class="row m-2">
        <h1 class="text-center">Add new place</h1>
    </div>
    <form:form action="/management/places/add" method="post" modelAttribute="newPlace">
        <label for="placeName" class="form-label"><b>Name: </b></label>
        <form:input path="name" class="form-control" id = "placeName" placeholder="Enter title"/>
        <div class="invalid-feedback d-block">
            <form:errors path="name" />
        </div>

        <label for="placeDescription" class="form-label"><b>Description: </b></label>
        <form:textarea path="description" class="form-control" id = "placeDescription" placeholder="Enter text"/>

        <label for="placeLocation" class="form-label"><b>Location: </b></label>
        <form:input path="location"  class="form-control" id = "placeLocation" placeholder="Enter text"/>
        <br>
        <button class="btn btn-success bg-dark text-success" type="submit">Add post</button>
    </form:form>
</div>
</body>
</html>

