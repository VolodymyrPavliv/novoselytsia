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
        <a href="<c:url value="/profile/edit/${user.id}"/>"
           class="btn btn-info btn-sm bg-info text-white">Edit</a>
    </div>

    <h1 class="text-center">Your posts
        <c:if test="${not empty title}">
            about ${title}
        </c:if>
    </h1>

    <form action=""  method="get" >
        <input type="text" name="title" placeholder="Enter title"/>
        <button class="btn btn-success bg-dark text-success" type="submit">Find</button>
    </form>
    <h4 class="text-center"><a href="/news/add" class="text-success">Add new post</a></h4>

    <c:choose>
    <c:when test="${empty posts}">
        <h4>There are no posts</h4>
    </c:when>

    <c:otherwise>
    <c:forEach items="${posts}" var="post">
        <div class="alert alert-info mt-2 bg-dark text-success">
            <h1>${post.title}</h1>
            <p>${post.text}</p>
            <p><b>Publication date: </b> <i>${post.publicationDate}</i>
                <c:if test="${post.lastModified!=null}"><b>Last modified: </b> <i>${post.lastModified}</i></c:if></p>
            <a href="<c:url value="/profile/post/edit/${post.id}"/>"
               class="btn btn-info btn-sm bg-info text-white">Edit</a>
            <a href="<c:url value="/profile/post/delete/${post.id}"/>"
               class="btn btn-danger btn-sm">Delete</a>
        </div>
    </c:forEach>
    </c:otherwise>
    </c:choose>
</div>
</body>
</html>
