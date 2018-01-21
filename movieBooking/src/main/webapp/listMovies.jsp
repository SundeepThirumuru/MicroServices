<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movie List</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<div class="container">
	<c:if test="${ not empty message }">
		<div class="panel panel-success panel-bordered">
			<div class="panel-heading">
				Success
			</div>
			<div class="panel-body">
				<c:out value="${message}"/>
			</div>
		</div>
	</c:if>
	<c:choose>
		<c:when test="${ not empty movies }">
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Movie Name</th>
						<th>Release Date</th>
						<th>Actors</th>
						<th>Edit</th>
						<th>Delete</th>										
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ movies }" var="movie">
						<tr>
							<td><c:out value="${ movie.id }"/></td>
							<td><c:out value="${ movie.name }"/></td>
							<td><fmt:formatDate value="${movie.release_date}" pattern="yyyy-MM-dd" /></td>
							<td>
								<c:forEach items="${ movie.actors }" var="actor">
									<p>
										<c:out value="${actor.firstName} ${actor.lastName }"></c:out>
									</p>
								</c:forEach>
							</td>
							<td><a href="editMovieForm?id=${ movie.id }">Edit</a></td>
							<td><a href="deleteMovie?id=${ movie.id }" class="delete-movie">Delete</a></td>
						</tr>
					</c:forEach>	
				</tbody>			
			</table>
		</c:when>
		<c:otherwise>
			<p>Sorry, there are no movies available at the moment!!</p>
		</c:otherwise>
	</c:choose>
	<p>Click <a href="movieForm">here</a> to add a Movie!!</p>
	<p>Click <a href="actorForm">here</a> to add an Actor!!</p>
</div>
<script type="text/javascript">
	if(typeof $ != "undefined") {
		$(".delete-movie").each(function () {
			$(this).click( function () {
				return confirm("Are you sure you want to delete the movie?");	
			});
		});
	}
</script>
</body>
</html>