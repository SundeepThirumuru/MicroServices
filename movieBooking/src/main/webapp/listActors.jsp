<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Actors List</title>
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
		<c:when test="${ not empty actors }">
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Actor First Name</th>
						<th>Actor Last Name</th>
						<th>Edit</th>
						<th>Delete</th>										
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ actors }" var="actor">
						<tr>
							<td><c:out value="${ actor.id }"/></td>
							<td><c:out value="${ actor.firstName }"/></td>
							<td><c:out value="${ actor.lastName }"/></td>
							<td><a href="editActorForm?id=${ actor.id }">Edit</a></td>
							<td><a href="deleteActor?id=${ actor.id }" class="delete-actor">Delete</a></td>
						</tr>
					</c:forEach>	
				</tbody>			
			</table>
		</c:when>
		<c:otherwise>
			<p>Sorry, there are no actors to show at the moment!!</p>
		</c:otherwise>
	</c:choose>
	Click <a href="actorForm">here</a> to add a Actor!!
</div>
<script type="text/javascript">
	if(typeof $ != "undefined") {
		$(".delete-actor").each(function () {
			$(this).click( function () {
				return confirm("Are you sure you want to delete the actor?");	
			});
		});
	}
</script>
</body>
</html>