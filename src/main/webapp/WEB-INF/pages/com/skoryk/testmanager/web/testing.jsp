<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Testing</title>
    <script type="text/javascript" src="<c:url value='/js/jquery/jquery.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/mustache.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/Testing.js'/>"></script>
</head>
<body>
    seconds left: <span id="secondsContainer"></span>
    <br/>

    <div id="questionContainer"></div>
    <a href="javascript: testing.answer()">Answer</a>

    <div style="display: none;" id="questionAnswers" type="text/html">
        <h3>{{text}}</h3>
        {{#answers}}
            <input type="radio" name="answer" value="{{id}}" />
            <span>{{text}}</span>
            <br/>
        {{/answers}}
    </div>


    <script type="text/javascript">
        var testing;
        $(document).ready(function(){
            testing = new Testing({
                answerUrl: "<c:out value='${answerUrl}' />",
                resultsUrl: "<c:out value='${resultsUrl}' />",
                question: '${question}'
            });
            testing.initialize();
        });
    </script>
</body>
</html>