
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Params</title>
</head>
<body>
<div align="center">
    <h1>Animal</h1>

        <table border="1">

            <th>Name</th>
            <th>Value</th>

        <c:forEach var="animal" items="${listParams}" varStatus="status">

            <tr>
                <td>${animal.name}</td>
                <td>${animal.value}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
