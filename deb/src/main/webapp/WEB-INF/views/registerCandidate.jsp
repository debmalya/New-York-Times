<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<link rel="stylesheet" href="./resources/css/octus.css" type="text/css">
	<title>Home</title>
</head>
<body>


<p>  
<header>
<!--  <img src="https://media.licdn.com/media/p/5/005/090/1b9/144bbda.png"></img> -->
</header>
<h1>
	Rest with JSON and MongoDB  
</h1>
<h2>
Register Candidate
</h2>
<form name="registerCandidate" method="POST">
<input type="email" name="emailAddress" maxlength="80" />
<input type="submit" name="Register" value="register"/>
</form>
</p>
</body>
<!--  <footer><jsp:include page="footer.jsp"/></footer> -->
</html>
