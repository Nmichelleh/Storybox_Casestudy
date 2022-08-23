<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<script type="text/javascript">
    function userValidation(form) {
    	var email = form.email.value;
        var password = form.password.value;
        var confirmPassword = form.confirmPassword.value;
        var name = form.fullName.value;

        if(email == "") {
        	form.email.focus();
        	return false;
            } 
        if(password == "") {
        	form.password.focus();
        	return false;
            } 
        if(confirmPassword == "") {
        	form.confirmPassword.focus();
        	return false;
            } 
        if(name == "") {
        	form.name.focus();
        	return false;
            } 
        
        return false;
    }
</script>

	<style type="text/css" >

		* {
			margin: 0;
			padding: 0;
			box-sizing: border-box;
			font-family: Arial, Helvetica, sans-serif;
		}

		body {
			margin: 0;
			padding: 0;
			background: linear-gradient(120deg, #0aaaf2, #3303bf);
			height: 100vh;
			overflow: hidden;
		}

		.center {
			position: absolute;
			top: 50%;
			left: 50%;
			transform: translate(-50%, -50%);
			width: 400px;
			background: whitesmoke;
			border-radius: 10px;
			box-shadow: 10px 10px 15px rgba(0, 0, 0, 0.05);
		}

		.center h1 {
			text-align: center;
			padding: 0 0 20px 0;
			border-bottom: 1px solid silver;
		}

		.center form {
			padding: 0 40px;
			box-sizing: border-box;
		}


		form .txt_field {
			position: relative;
			border-bottom: 2px solid black;
			margin: 30px 0;
		}

		.txt_field input {
			width: 100%;
			padding: 0 5px;
			height: 40px;
			font-size: 16px;
			border: none;
			background: none;
			outline: none;

		}

		.txt_field label {
			position: absolute;
			top: 50%;
			left: 5px;
			color: gray
		}


		.txt_field span::before {
			content: '';
			position: absolute;
			top: 40px;
			left: 0;
			width: 0%;
			height: 2px;
			background: #2691d9;
			transition: .5s;
		}

		.txt_field input:focus ~ label,
		.txt_field input:valid ~ label {
			top: -5px;
			color: #2691d9;
		}

		.txt_field input:focus ~ span::before,
		.txt_field input:valid ~ span::before {
			width: 100%;
		}

		.pass {
			margin: -5px 0 20px 5px;
			color: grey;
			cursor: pointer;
		}

		.pass :hover {
			text-decoration: underline;
		}

		input[type="submit"] {
			width: 100%;
			height: 50px;
			border: 1px solid;
			background: #2691d9;
			border-radius: 25px;
			font-size: 18px;
			color: whitesmoke;
			font-weight: 700;
			cursor: pointer;
			outline: none;
		}

		input[type="submit"]:hover {
			border-color: #2691d9;
			transition: 5s;
		}

		.Signup_link {
			margin: 30px 0;
			text-align: center;
			font-size: 16px;
			color: grey;
		}

		.Signup_link a {
			color: #2691d9;
			text-decoration: none;
		}

		.Signup_link a:hover {
			text-decoration: underline;
		}

	</style>
</head>
<body>
	<!--  navbar   -->

	<div class="center">
		<h1>Registration</h1>
		<form method="post" action="/createUser">

			<c:forEach var="error" items="${errors}">
				<span style='color: red'>${error}</span>
				<br>
			</c:forEach>

			<div class="txt_field">
				<input type="text" name="fullName"
					   value="${form.fullName }" required>
				<span></span>
				<label>Full Name</label>
			</div>

			<div class="txt_field">
				<input type="text" required name="email" value="${form.email }" >
				<span></span>
				<label>Email</label>
				<c:forEach items="${errorFields}" var="errorField">
					<c:if test='${errorField.getField().equals("email") }'>
						<br>
						<span style='color: red'>${errorField.defaultMessage}</span>

					</c:if>
				</c:forEach>
			</div>

			<div class="txt_field">
				<input type="password" required name="password" value="${form.password }" >
				<span></span>
				<label>Password</label>

				<c:forEach items="${errorFields}" var="errorField">
					<c:if test='${errorField.field == "password" }'>
						<br>
						<span style='color: red'>${errorField.defaultMessage}</span>
					</c:if>
				</c:forEach>

			</div>

			<div class="txt_field">
				<input type="password" required name="confirmPassword"
					   value="${form.confirmPassword }" >
				<span></span>
				<label>Confrim Password</label>

				<c:forEach items="${errorFields}" var="errorField">
					<c:if test='${errorField.field == "confirmPassword" }'>
						<br>
						<span style='color: red'>${errorField.defaultMessage}</span>
					</c:if>
				</c:forEach>

			</div>


			<div class="">
				<label for="exampleInputEmail1" class="form-label">Select Role</label>
				<select  class="form-label" name="role">
					<option value="Buyer" >Buyer</option>
					<option value="Seller" >Seller</option>
				</select>

			</div>



			<br>
			<br>
			<input type="submit" value="Signup">
			<div class="Signup_link">
				Already have an account? <a href="/login">Log in</a>

			</div>

		</form>
	</div>

</body>
</html>