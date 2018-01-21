<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Car Form</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
</head>
<body>
	<div class="panel panel-info">
		<div class="panel-heading">Add Customer Form</div>
		<div class="panel-body">
			<form method="POST" action="addCustomer" modelAttribute="customer">
				<div class="form-group">
					<label for="name">Name</label> 
					<input type="text" id="name" name="name" class="form-control" />
				</div>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
	</div>
</body>
</html>