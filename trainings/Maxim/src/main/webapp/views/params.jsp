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
    <h1>Params Table</h1>

    <table border="2">

        <th>Attr_id</th>
        <th>Object_id</th>
        <th>Value</th>

        <c:forEach var="params" items="${listParams}" varStatus="status">
            <tr>
                <td>${params.attrId}</td>
                <td>${params.objectId}</td>
                <td>${params.value}</td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>