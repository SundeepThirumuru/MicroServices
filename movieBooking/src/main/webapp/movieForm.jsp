<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Add Movie</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<style>
		.errors {
			color: red;
		}
	</style>
</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">Add Movie</div>
			<div class="panel-body">
				<form:form action="addMovie" method="post" modelAttribute="movie">
					<div class="form-group">
						<form:label path="name">Movie Name:</form:label>
						<form:input class="form-control" path="name"/>
						<form:errors path="name" class="errors"/>
					</div>
					<br/>
					<div class="form-group">
						<form:label path="release_date">Release Date:</form:label>
						<form:input type="date" class="form-control" path="release_date"/><br/>
						<form:errors path="release_date" class="errors"></form:errors>
					</div>
					<br/>
					<div class="form-group">
						<label path="actors">Actors :</label>
						<form:select class="form-control" path="actors" multiple="true" items="${ actors }" itemLabel="fullName" itemValue="id"/>													
						<form:errors path="actors" class="errors"></form:errors>
					</div>
					<br/>										
					<input type="submit" class="btn btn-default"/>		
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>