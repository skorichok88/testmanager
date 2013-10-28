<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <h3>This is knowledge test</h3>
    <h3>Please enter your first and last name and click Start</h3>
    <form action="<c:out value='${testingUrl}' />" method="post">
        <span>First Name</span>
        <input type="text" name="firstName">
        <span>Last Name</span>
        <input type="text" name="lastName">
        <input type="submit" value="Start">
    </form>
</body>
</html>