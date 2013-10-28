<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Testing results</title>
</head>
<body>
    <h1>Results</h1>
    <h3>First name : ${testResult.firstName}</h3>
    <h3>Last name : ${testResult.lastName}</h3>
    <h3>Questions answered : ${fn:length(testResult.answeredQuestionIds)}</h3>
    <h3>Correct answers : ${testResult.correctAnswersCount}</h3>
</body>
</html>