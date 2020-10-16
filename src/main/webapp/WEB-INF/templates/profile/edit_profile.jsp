<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Profile</title>
</head>
<link href="/resources/bootstrap.min.css" rel="stylesheet">
<body>
<jsp:include page="../sections/header.jsp"/>
<div class="container">
    <form action="" method="post" class="form-signin ">
        <h2 class="form-signin-heading">Edit profile</h2>
        <lable id="firstName"><b>First Name: </b></lable>
        <input name="firstName" id="firstName" type="text" value="${user.firstName}" class="form-control" />
        <lable id="lastName"><b>Last Name: </b></lable>
        <input name="lastName" id = "lastName" type="text" value="${user.lastName}" class="form-control" />
        <lable id="age"><b>Age: </b></lable>
        <input name="age" id = "age" type="text" value="${user.age}" class="form-control"/>
        <br>
        <button class="btn btn-success bg-dark text-success" type="submit">Submit changes</button>
    </form>
</div>
</body>
</html>
