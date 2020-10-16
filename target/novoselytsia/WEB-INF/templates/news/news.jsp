<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>News</title>
    <link href="/resources/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="../sections/header.jsp"/>

    <div class="container">
        <h1 class="text-center">News
            <c:if test="${not empty title}">
                about ${title}
            </c:if>
        </h1>

        <form action=""  method="get" >
            <input type="text" name="title">
            <button class="btn btn-success bg-dark text-success" type="submit">Find</button>
        </form>
        <h4 class="text-center"><a href="/news/add" class="text-success">Add new post</a></h4>

        <c:choose>
            <c:when test="${empty news}">
                <h4>There are no news</h4>
            </c:when>

            <c:otherwise>
                <c:forEach items="${news}" var="post">
                    <div class="alert alert-info mt-2 bg-dark text-success">
                        <h1>${post.title}</h1>
                        <p>${post.text}</p>
                        <p><b>Author: </b> <i>${post.user.firstName}</i> <i>${post.user.lastName}</i> </p>
                        <p><b>Publication date: </b> <i>${post.publicationDate}</i> <c:if test="${post.lastModified!=null}"><b>
                            Last modified: </b> <i>${post.lastModified}</i></c:if> </p
                    </div>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>
