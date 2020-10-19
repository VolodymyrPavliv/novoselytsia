<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Places</title>
    <link href="/resources/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../sections/header.jsp"/>
<div class="container">
    <h1 class="text-center">
        <c:if test="${not empty name}">
            ${name}
        </c:if>
    </h1>

    <form action=""  method="get" >
        <input type="text" name="name" placeholder="Enter name">
        <button class="btn btn-success bg-dark text-success" type="submit">Find</button>
    </form>
    <h4 class="text-center"><a href="/management/places/add" class="text-success">Add new place</a></h4>

    <c:choose>
        <c:when test="${empty places}">
            <h4>There are no places</h4>
        </c:when>

        <c:otherwise>
            <c:forEach items="${places}" var="place">
                <div class="alert alert-info mt-2 bg-dark text-success">
                    <h1>${place.name}</h1>
                    <p><b>Location: </b>${place.location}</p>
                    <p>${place.description}</p>
                    <a href="<c:url value="/management/places/edit/${place.id}"/>"
                       class="btn btn-info btn-sm bg-info text-white">Edit</a>
                    <a href="<c:url value="/management/places/delete/${place.id}"/>"
                       class="btn btn-danger btn-sm">Delete</a>
                </div>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>

