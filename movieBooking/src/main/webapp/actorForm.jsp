<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Add Actor</title>
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
			<div class="panel-heading">Add Actor</div>
			<div class="panel-body">
				<form:form action="addActor" method="post" modelAttribute="actor">
					<div class="form-group">
						<form:label path="firstName">Actor First Name:</form:label>
						<form:input path="firstName" class="form-control"/>
						<form:errors path="firstName" class="errors"/>
					</div>
					<br/>
					<div class="form-group">
						<form:label path="lastName">Actor Last Name:</form:label>
						<form:input path="lastName" class="form-control"/>
						<form:errors path="lastName" class="errors"/>
					</div>
					<input type="submit" class="btn btn-default"/>		
				</form:form>
			</div>
		</div>
	</div>
</body>