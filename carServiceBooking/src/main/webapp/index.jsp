<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Car Service Booking Application</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<div class="panel panel-info">
			<div class="panel-heading">Car List</div>
			<div class="panel-body">
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Car ID</th>
							<th>Car Reg No.</th>
							<th>Customer Ids</th>
							<th>Customer Names</th> 
							<th>Delete Operation</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ carList }" var="car">
							<tr>
								<td>${ car.getId() }</td>
								<td>${ car.getCarRegNo().toUpperCase() }</td>
								<td>${ car.getCustomerIdsAsString() }</td>
								<td>${ car.getCustomerNames(customerMap) }</td>
								<td><a
									href="/deleteCar?id=${ car.getId() }">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<a href="/addCarForm">Add Car</a>
	</div>
	<script>
		if(history != undefined) {
			history.replaceState("", "Car Service Application", "http://localhost:8080");
		}
	</script>
</body>
</html>