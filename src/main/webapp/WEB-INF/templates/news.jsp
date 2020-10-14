<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>News</title>
    <link href="/resources/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="sections/header.jsp"/>

    <div class="container">
        <h1 class="text-center">News about
            <c:if test="${not empty param.title}">
                in ${param.title}
            </c:if>
        </h1>

        <form action=""  method="get" >
            <button class="btn btn-info" type="submit">Find</button>
        </form>
        <h4 class="text-center"><a href="/news/add" class="text-success">Add new post</a></h4>

        <c:choose>
            <c:when test="${empty news}">
                <h4>There are no news</h4>
            </c:when>

            <c:otherwise>
                <c:forEach items="${news}" var="post">
                    <div class="alert alert-info mt-2">
                        <h1>${post.title}</h1>
                        <p>${post.text}</p>
                        <p>${post.user.firstName}</p>
                        <p>${post.user.lastName}</p>
                    </div>
                </c:forEach>
            </c:otherwise>
        </c:choose>

    </div>
</body>
</html>
