<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Management News</title>
    <link href="/resources/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../sections/header.jsp"/>

<div class="container">
    <h1 class="text-center">User List</h1>

    <form action=""  method="get" >
        <input type="text" name="lastName" placeholder="Enter lastName"/>
        <button class="btn btn-success bg-dark text-success" type="submit">Find</button>
    </form>

    <c:choose>
        <c:when test="${empty users}">
            <h4>There are no users</h4>
        </c:when>

        <c:otherwise>
            <c:forEach items="${users}" var="user">
                <div class="alert alert-info mt-2 bg-dark text-success">
                    <p><h2>${user.firstName}</h2> <h2>${user.lastName}</h2></p>
                    <p>${user.email}</p>
                    <p><b>Age: </b>${user.age}</p>
                    <c:forEach items="${user.roles}" var="role">
                        <p><b>Role: </b>${role.name}</p>
                    </c:forEach>
                    <form method="post" action="/management/users/${user.id}">
                        <button class="btn btn-info" type="submit">Change status</button>
                    </form>
                    <a href="<c:url value="/profile/news/${user.id}"/>"
                       class="btn btn-info btn-sm bg-info text-white">Posts</a>
                    <a href="<c:url value="/management/users/delete/${user.id}"/>"
                       class="btn btn-danger btn-sm">Delete</a>
                </div>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
