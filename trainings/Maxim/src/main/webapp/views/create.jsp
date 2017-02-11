<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New Entity</title>
</head>
<body>
<div align="center">
    <h1>New Entity</h1>
    <form:form action="saveEntity" method="post" modelAttribute="entity">
        <table>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Weight:</td>
                <td><form:input path="weight" /></td>
            </tr>
            <tr>
                <td>Length:</td>
                <td><form:input path="length" /></td>
            </tr>
            <tr>
                <td>Age:</td>
                <td><form:input path="age" /></td>
            </tr>
            <tr>
                <td>Colour:</td>
                <td><form:input path="colour" /></td>
            </tr>
            <td colspan="2" align="center"><input type="submit" value="Save"></td>
        </table>
    </form:form>
</div>
</body>
</html>
