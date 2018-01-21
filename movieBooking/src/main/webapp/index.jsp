<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Movie Booking Application</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
	    <div class="jumbotron">
		    <c:choose>	
				<c:when test="${ not empty guestName }">
					<p>Welcome, <c:out value="${ guestName }"/></p>
				</c:when>
				<c:otherwise>
				    <p>Welcome</p>
				</c:otherwise>
			</c:choose>	
			<p>Hey, How are you doing?</p>  
			<a href="listMovies">Click Here to see the list of movies</a> 
		</div>
	</div>
</body>
</html>