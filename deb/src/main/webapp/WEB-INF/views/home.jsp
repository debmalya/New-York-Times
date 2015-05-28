<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<link rel="stylesheet" href="./resources/css/octus.css" type="text/css">
	<title>New York Times</title>
</head>
<body>
<h1>
	 
</h1>
<form name="nyt" method="post">
<div>
<P>  New York Times Categories. </P>
<select name="nyt_categories" id="nyt_categories">
<c:forEach items="${categories}" var="category">
		<option value="${category.section}">${category.display_name}</option>
</c:forEach>
</select>
</div>
<div>
<input type="submit" value="Get Details"/>
</div>
<div name="categoryDetails" id="categoryDetails">
<c:forEach items="${categoryDetails}" var="categoryDetail">
		<a href="${categoryDetail.url}">${categoryDetail.title}</a><br>
</c:forEach>
</div>

</form>

</body>
</html>
