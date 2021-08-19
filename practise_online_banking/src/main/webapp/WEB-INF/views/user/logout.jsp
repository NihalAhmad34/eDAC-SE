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

</style>
<script type="text/javascript">
	function my(){
		var ti=5;
		var int = setInterval(document.getElementById("time").innerHTML=--ti,1000);
	}
</script>
</head>
<body>
	<div
		style="background-color: lightblue; margin: auto; padding: 10px; width: 400px;">
		<h4>Hello, ${requestScope.details.name}</h4>
		<h5 style="color:green;">Logged out successfully</h5>
		<h5>Redirect automatically in <span id="time">5</span> sec</h5>
	</div>
</body>
</html>