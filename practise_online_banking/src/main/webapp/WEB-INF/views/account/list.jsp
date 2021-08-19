<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account List | Online Banking</title>
<style type="text/css">
tr {
	text-align: center;
	padding: 6px
}
td, th{padding:4px;}

input {
	margin: 4px;
}
</style>
</head>
<body style="background-color: gray; margin: auto;">
	<div
		style="background-color: lightblue; margin: auto; padding: 10px; width: 500px; min-height: 300px; margin-top: 100px; text-align: center;">
		<h5>Hello, ${requestScope.details.name}</h5>
		<h3>Your Account Details</h3>
		<form method="POST">
			<table style="min-width: 480px; margin: 10px; border-color: #add8e65e;" border="1" cellspacing="0">
				<tr>
					<th>Select</th>
					<th>Acc Id</th>
					<th>Acc Type</th>
					<th>Acc Balacne</th>
				</tr>
				<c:forEach var="acc"  items="${requestScope.acc_list}">
					<tr>
						<td><input type="radio" name="acc_id" value="${acc.acc_id}" required="required"></td>
						<td>${acc.acc_id}</td>
						<td>${acc.type}</td>
						<td>${acc.balance}</td>
					<tr>
				</c:forEach>
				<!-- <tr><td colspan="4" style="color:red">Data Not Found</td></tr>  -->
			</table>
			<div class="row">
				<label>Amount</label><input type="number" name="amount"  value="0"/>
			</div>
			<input type="submit" value="Withdraw" name="submit"> 
			<input type="submit" value="Deposite" name="submit">
			<input type="submit" value="Close Account" name="submit"> 
				<a href="<spring:url value='/account/create_acc' />"><input type="button" value="Create Account" name="create_acc"></a>
				 <a href="<spring:url value='/user/logout'/>">Logout</a>
		</form>
		<div><h5 style="color:red">${requestScope.message}</h5></div>
	</div>
</body>
</html>