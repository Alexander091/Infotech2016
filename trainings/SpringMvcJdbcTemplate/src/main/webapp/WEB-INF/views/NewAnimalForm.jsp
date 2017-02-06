
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Animal</title>
</head>
<body>
	<div align="center">
		<h1>New Animal</h1>
		<form:form action="saveAnimal" method="post" modelAttribute="animal">
		<tabl
			<form:hidden path="objectId"/>
			<tr>
				<td>Name:</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><form:input path="age" /></td>
			</tr>
			<tr>
				<td>Colour:</td>
				<td><form:input path="colour" /></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save"></td>
			</tr>
		</table>
		</form:form>
	</div>
</body>
</html>