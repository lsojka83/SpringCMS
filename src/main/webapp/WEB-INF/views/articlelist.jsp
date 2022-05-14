<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Article list</title>
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
        <th>Title</th>
        <th>Content</th>
        <th>Author</th>
        <th>Category</th>
        <th>Created</th>
        <th>Updated</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${articles}" var="article">
        <tr>
            <td>
                    ${article.id}
            </td>
            <td>
                    ${article.title}
            </td>
            <td>
                    ${article.content}
            </td>
            <td>
                    ${article.author.lastName}
            </td>
            <td>
                <c:forEach items="${article.categories}" var="cat">
                    ${cat.name}

                </c:forEach>
            </td>
            <td>
                    ${article.created}
            </td>
            <td>
                    ${article.updated}
            </td>

            <td>
                <a href="/article/edit?id=${article.id}">Edit</a>
            </td>
            <td>
                <a href="/article/delete?id=${article.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
