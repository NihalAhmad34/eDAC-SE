<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login | Online Banking</title>
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
		style="background-color: lightblue; margin: auto; padding: 10px; width: 400px; margin-top:100px">
		<form method="post">
			<fieldset style="padding: 5px; min-height: 300px">
				<legend>
					Welcome To Online Banking
				</legend>
				<div class="row">
					<label>Email</label><input type="email" name="email" required="required" />
				</div>
				<div class="row">
					<label>Password</label><input type="password" name="password" required="required"/>
				</div>
				<div class="row">
					<input type="submit" value="Login" style="width: 100px; background-color: orange; margin:4px">
					<a href="<spring:url value='/user/reg_form'/>"> <input type="button" value="Register" style="width: 100px; background-color: blue; margin:4px"></a>
				</div>
				<br>
				<div class="row">
					<h5 style="color: red">${requestScope.message}</h5>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>