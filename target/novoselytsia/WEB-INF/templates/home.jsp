<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="ua.novoselytsia.security.CustomerDetails" %>
<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Home page</title>
    <link href="/resources/bootstrap.min.css" rel="stylesheet">

</head>
<body>
    <jsp:include page="sections/header.jsp"/>
    <div class="container">
        <h1 class="text-center">Welcome to Home page!</h1>
        <div class="alert alert-info mt-2 bg-dark text-success">
            <h4 class="text-center"><a href="/news" class="text-success">News</a></h4>
        </div>
        <div class="alert alert-info mt-2 bg-dark text-success">
            <h4 class="text-center"><a href="/places" class="text-success">Places</a></h4>
        </div>
        <div class="alert alert-info mt-2 bg-dark text-success">
            <h4 class="text-center"><a href="/history" class="text-success">History</a></h4>
        </div>
    </div>
</body>
</html>