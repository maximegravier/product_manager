<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List"%>
    <%@ page import="fr.myschool.productmanager.entity.Product"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="${request.contextPath}/header.jsp"></jsp:include>
<title>List all products</title>
</head>
<body>
	<h1>List of all products</h1>
	<c:forEach var="product" items="${productList}">
		<p>${product}</p>
		<form action="${pageContext.request.contextPath}/auth/removeProduct" method="post">
			<input type="hidden" name="id" value="${product.id}">
			<input type="submit" value="Remove product">
		</form>
	</c:forEach>
	<h1>Cheapest products</h1>
	<c:forEach var="cheapProduct" items="${cheaperProductsList}">
		<p>${cheapProduct}</p>
	</c:forEach>
	<jsp:include page="${request.contextPath}/footer.jsp"></jsp:include>
</body>
</html>