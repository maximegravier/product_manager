<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="fr.myschool.productmanager.entity.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="${request.contextPath}/header.jsp"></jsp:include>
<title>Show a product</title>
</head>
<body>
	<h1>Product details</h1>	
	<p style="font-weight: bold">Name: </p>${productShown.name}
	<p style="font-weight: bold">Description: </p>${productShown.description}
	<p style="font-weight: bold">Price: </p>${productShown.price} euros
	<p style="font-weight: bold">Category: </p>${productShown.category.name}
	<jsp:include page="${request.contextPath}/footer.jsp"></jsp:include>
</body>
</html>