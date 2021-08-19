<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register | Online Banking</title>
<style type="text/css">
.row {
	text-align: center;
	padding: 6px
}

.row label {
	width: 180px;
	padding: 8px;
}

.row input {
	width: 200px;
	padding: 8px
}
</style>
</head>
<body style="background-color: gray; margin: auto;">
	<div
		style="background-color: lightblue; margin: auto; padding: 10px; width: 400px; margin-top: 100px;">
		<form:form method="post" modelAttribute="user">
			<fieldset style="padding: 5px; min-height: 300px">
				<legend> Register To Online Banking </legend>
				<div class="row">
					<label>Name</label>
					<form:input type="text" path="name" required="required" />
				</div>
				<div class="row">
					<label>Email</label>
					<form:input type="email" path="email" required="required" />
				</div>
				<div class="row">
					<label>Password</label>
					<form:input type="password" path="password" required="required" />
				</div>
				<div class="row">
					<input type="submit" value="Register"
						style="width: 100px; background-color: orange; margin: 4px">
				</div>
				<br>
				<div class="row">
					<h5 style="color: red">${requestScope.message}</h5>
				</div>
			</fieldset>
		</form:form>
	</div>
</body>
</html>