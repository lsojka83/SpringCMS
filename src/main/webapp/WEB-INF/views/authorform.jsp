<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add/Edit Author</title>
</head>
<body>

<form:form method="post" modelAttribute="author">
    <div>
        <label for="firstName">First name</label>
        <form:input path="firstName" type="text"></form:input>
        <form:errors path="firstName"/>
    </div>
    <div>
        <label for="lastName">Last name</label>
        <form:input path="lastName" type="text"></form:input>
        <form:errors path="lastName"/>

    </div>
    <div>
        <form:button name="confirm" value="yes">Send</form:button>
        <form:button name="confirm" value="no">Cancel</form:button>
    </div>
</form:form>
</body>
</html>
