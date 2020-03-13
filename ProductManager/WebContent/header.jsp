<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<a href="listProduct">Products List</a>
	<c:choose>
		<c:when test="${username != null}">
			<a href="${pageContext.request.contextPath}/auth/addProduct">Add a product</a>
			<a href="${pageContext.request.contextPath}/auth/basicInsert">Basic insert</a>
			<a href="${pageContext.request.contextPath}/auth/addCategory">Add a category</a>
			<a href="${pageContext.request.contextPath}/logout">Logout</a>
		</c:when>
		<c:otherwise>
			<a href="login">Login</a>
		</c:otherwise>
	</c:choose>						
	<hr>	
</body>
</html>