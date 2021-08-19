<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Account | Online Banking</title>
<style type="text/css">
.row {
	text-align: center;
	padding: 6px
}

.row label {
	width: 180px;
	padding: 8px;
}

.row input, select {
	width: 200px;
	padding: 8px
}
</style>
</head>
<body style="background-color: gray; margin: auto;">
	<div
		style="background-color: lightblue; margin: auto; padding: 10px; width: 400px; margin-top: 100px;">
		<form method="post">
			<fieldset style="padding: 5px; min-height: 300px">
				<legend> Create Account To Online Banking </legend>
				<div class="row">
					<label>Account type</label><br>
					<select name="type">
					<c:forEach var="actype" items="${requestScope.acc_type}">
						<option value="${actype}">${actype}</option>
					</c:forEach>
					</select>
				</div>
				<div class="row">
					<label>Opening Balance</label><br>
					<input type="number" name="balance" required="required" value="0"/>
				</div>
				<div class="row">
					<input type="submit" value="Create Account"
						style="min-width: 100px; background-color: orange; margin: 4px">
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