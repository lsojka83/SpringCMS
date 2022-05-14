<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Category list</title>
</head>
<body>

<table>
    <tbody>
    <tr>
        <td>
            <p>
                <a href="/category/add">Add category</a>
            </p>
        </td>
        <td>
            <p>
                <a href="/category/">Category list</a>
            </p>
        </td>
    </tr>
    <tr>
        <td>
            <p>
                <a href="/author/add">Add author</a>
            </p>
        </td>
        <td>
            <p>
                <a href="/author/">Author list</a>
            </p>
        </td>
    </tr>
    <tr>
        <td>
            <p>
                <a href="/article/add">Add article</a>
            </p>
        </td>
        <td>
            <p>
                <a href="/article/">Article list</a>
            </p>
        </td>
    </tr>
    </tbody>
</table>


<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Desc</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td>
                    ${category.id}
            </td>
            <td>
                    ${category.name}
            </td>
            <td>
                    ${category.description}
            </td>

            <td>
                <a href="/category/edit?id=${category.id}">Edit</a>
            </td>
            <td>
                <a href="/category/delete?id=${category.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
