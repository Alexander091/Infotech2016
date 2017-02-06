<%@ page import="com.netcracker.Book" %>
<%@ page import="com.netcracker.BooksServlet" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="с" uri="http://java.sun.com/jsp/jstl/core" %>  <%--для описания либо подключется библиотека тегов--%>
<html>                                                           <%--Либо можно писать джава код напрямую, но это плохой вариант--%>
<head>
    <title>BooksStore</title>
</head>
<body>
Hello World !
<%= new java.util.Date()%>
</body>
</html>
<%--<ul>--%>
<%--<%= new java.util.Date() %>--%>
<%--&lt;%&ndash;<с:forEach items="${bookList}" var="book">&ndash;%&gt;--%>
<%--&lt;%&ndash;<li>Id: ${book.id}, Name: ${book.name}</li>&ndash;%&gt;--%>
<%--&lt;%&ndash;<li>Hello World!</li>&ndash;%&gt;--%>
<%--&lt;%&ndash;</с:forEach>&ndash;%&gt;--%>
<%--</ul>--%>
