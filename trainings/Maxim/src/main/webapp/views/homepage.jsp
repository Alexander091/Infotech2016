<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home Page of Zoo Shop</title>
</head>
<body>
<div align="center">
    <h1>Objects list</h1>
    <h3><a href="newEntity">New Animal</a></h3>
    <h3><a href="params">Show params</a></h3>
    <table border="1">
        <th>No</th>
        <th>Name</th>

        <c:forEach var="entity" items="${listObjects}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${entity.nameType}</td>
                <td>
                    <a href="delete?id=${entity.objectId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
