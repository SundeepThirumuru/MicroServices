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
		<div class="panel-heading">Add Car Form</div>
		<div class="panel-body">
			<form method="POST" action="addCar" modelAttribute="car">
				<div class="form-group">
					<label for="carRegNo">Car Reg No.</label> <input type="text"
						id="carRegNo" name="carRegNo" class="form-control" />
				</div>
<!--				<div class="form-group">
					<label for="customerId">Customer Name</label> <select
						id="customerId" name="customerId" class="form-control">
						<option value="0">--Select Customer Name---</option>
						<c:forEach items="${ customers }" var="customer">
							<option value="${ customer.getId() }">${ customer.getName() }</option>
						</c:forEach>
					</select>
				</div>   
-->
				<div class="form-group">
					<label for="customerIds">Customer Names</label> 
					<select
						id="customerIds" name="customerIds" class="form-control" multiple="multiple">
						<option value="0">--Select Customer Name---</option>
						<c:forEach items="${ customers }" var="customer">
							<option value="${ customer.getId() }">${ customer.getName() }</option>
						</c:forEach>
					</select>
				</div>				
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
	</div>
</body>
</html>