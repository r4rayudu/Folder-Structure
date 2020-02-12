<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<div class="starter-template">
			<h1>Find the file structure path</h1>
			<div class="row">
			    <div class="col"><h2>User Enter : </h2></div>
			    <div class="col">
			    	<form id="findPathForm" action="/findPathResult" method="get">
			    		<input type="text" id="find" name="find" value="${findInput}"/>
			    	</form>
			    </div>
			    <div class="col"><button type="submit" form="findPathForm" value="Submit" >Submit</button></div>
			 </div>
			 <c:if test="${empty pathList}">
			 	No search record found
			 </c:if>
			 <c:forEach items="${pathList}" var="pathList">
    			 ${pathList}<br/>
			 </c:forEach>
		</div>

	</div>
	
</body>
</html>

