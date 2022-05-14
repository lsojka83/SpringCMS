<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add/Edit article</title>
</head>
<body>

<form:form method="post" modelAttribute="article">
    <div>
        <label for="title">Title</label>
        <form:input path="title" type="text" maxlength="200"></form:input>
    </div>
    <div>
        <label for="content">Content</label>
        <form:textarea path="content" rows="5" cols="20"></form:textarea>
    </div>
    <div>
        <label for="author">Author</label>
        <form:select path="author"  items="${authors}" itemLabel="lastName" itemValue="id"></form:select>
    </div>
    <div>
        <label for="categories">Categories</label>
        <form:select path="categories"  items="${categories}" itemLabel="name" itemValue="id" multiple="true"></form:select>
    </div>

    <div>
        <form:button name="confirm" value="yes">Send</form:button>
        <form:button name="confirm" value="=no">Cancel</form:button>
    </div>
</form:form>
</body>
</html>