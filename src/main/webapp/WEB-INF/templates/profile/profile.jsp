<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <link href="/resources/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../sections/header.jsp"/>
<div class="container">
    <div class="alert alert-info mt-2 bg-dark text-success">
        <p><h2>${userName} </h2></p>
        <p><b>Email: </b>${user.email}</p>
        <p><b>Age: </b>${user.age}</p>
        <a href="<c:url value="/profile/news/${user.id}"/>"
           class="btn btn-info btn-sm bg-info text-white">Posts</a>
        <a href="<c:url value="/profile/edit/${user.id}"/>"
           class="btn btn-info btn-sm bg-info text-white">Edit</a>
    </div>

</div>
</body>
</html>
