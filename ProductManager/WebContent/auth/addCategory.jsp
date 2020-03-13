<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="${request.contextPath}/header.jsp"></jsp:include>
<title>Add a category</title>
</head>
<body>
	<h1>Add a category</h1>
	<form action="${pageContext.request.contextPath}/auth/addCategory" method="post">
		<label for="name">Name:</label>
		<input type="text" name="name"><br>		
		<input type="submit" value="Add"> 
	</form>
	<jsp:include page="${request.contextPath}/footer.jsp"></jsp:include>
</body>
</html>