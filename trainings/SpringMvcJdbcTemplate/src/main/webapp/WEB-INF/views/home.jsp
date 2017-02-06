<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
    	   <div align="center">
	        <h1>Animal</h1>

			<table border="1">
				<th>No</th>
				<th>Name</th>

				<c:forEach var="animal" items="${listAnimal}" varStatus="status">

					<tr>
							<td>${animal.objectId}</td>
							<td>${animal.name}</td>

						<td>
							<a href="/showParams?objectId=${animal.objectId}">Show Params</a>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="/deleteAnimal?objectId=${animal.objectId}">Delete</a>

						</td>

					</tr>
				</c:forEach>
			</table>


			<h3><a href="newAnimal">New Animal</a></h3>
    	</div>
    </body>
</html>
