<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="${request.contextPath}/header.jsp"></jsp:include>
<title>Add a product</title>
</head>
<body>
<h1>Add a product</h1>
<form action="addProduct" method="post">
	<label for="name">Name:</label>
	<input type="text" name="name"><br>
	<label for="description">Description:</label>
	<input type="text" name="description"><br>
	<label for="price">Price:</label>
	<input type="number" step="0.01" name="price"><br>
	<label for="category">Category:</label>
	<select id="category" name="category">
		<c:forEach var="category" items="${categoryList}">
			<option value="${category.id}">${category.name}</option>
		</c:forEach>
	</select><br>
	<input type="submit" value="Add"> 
</form>
<jsp:include page="${request.contextPath}/footer.jsp"></jsp:include>
</body>
</html>