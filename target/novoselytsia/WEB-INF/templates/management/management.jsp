<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Management</title>
    <link href="/resources/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="../sections/header.jsp"/>
    <div class="container">
        <h1 class="text-center">Welcome to Management page!</h1>
        <div class="alert alert-info mt-2 bg-dark text-success">
            <h4 class="text-center"><a href="/management/users" class="text-success">User List</a></h4>
        </div>
        <div class="alert alert-info mt-2 bg-dark text-success">
            <h4 class="text-center"><a href="/management/news" class="text-success">News</a></h4>
        </div>
        <div class="alert alert-info mt-2 bg-dark text-success">
            <h4 class="text-center"><a href="/management/places" class="text-success">Places</a></h4>
        </div>
    </div>
</body>
</html>
