<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Seller</title>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<style type="text/css" >
		@import url('https://fonts.googleapis.com/css2?family=Noto+Sans:wght@100;400&family=Poppins:wght@100;200;300;600&display=swap');

		* {
			margin: 0;
			padding: 0;
			box-sizing: border-box;
			font-family: 'Poppins', sans-serif;
		}


		header {
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			padding: 40px 100px;
			z-index: 1000;
			display: flex;
			justify-content: space-between;
			align-items: center;
		}

		header .logo {
			color: #fff;
			text-transform: uppercase;
			cursor: pointer;
		}

		.showcase header {
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			padding: 40px 100px;
			z-index: 1000;
			display: flex;
			align-items: center;
			justify-content: space-between;

		}

		.logo {
			text-transform: uppercase;
			cursor: pointer;
		}


		.toggle {
			position: relative;
			width: 60px;
			height: 60px;
			background: url('https://nawaztechnologies.com/video/menu-btn.png');
			background-repeat: no-repeat;
			background-size: 30px;
			background-position: center;
			cursor: pointer;
		}

		.toggle.active {
			background: url('https://nawaztechnologies.com/video//menu-btn.png');
			background-repeat: no-repeat;
			background-size: 25px;
			background-position: center;
			cursor: pointer;
		}

		.showcase {
			position: absolute;
			right: 0;
			width: 100%;
			min-height: 100vh;
			padding: 100px;
			display: flex;
			justify-content: space-between;
			align-items: center;
			background: #0aaaf2;
			color: white;
			transition: 0.5s;
			z-index: 2;
		}

		.showcase.active {
			right: 300px;
		}

		.showcase video {
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			height: 100%;
			object-fit: cover;
			opacity: 0.8;
		}


		.overlay {
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			height: 100%;
			background: #03a9f4;
			mix-blend-mode: overlay;
		}


		.text {
			position: relative;
			z-index: 10;
		}

		.text h2  {
			font-size: 5em;
			font-weight: 800;
			color: #fff;
			line-height: 1em;
			text-transform: uppercase;
		}

		.text h3 {
			font-size: 4em;
			font-weight: 700;
			color: #fff;
			line-height: 1em;
			text-transform: uppercase;
		}


		.text p{
			font-size: 1.1em;
			color: #fff;
			margin: 20px 0;
			font-weight: 400;
			max-width: 700px;
		}


		.text a {
			display: inline-block;
			font-size: 1em;
			background: #fff;
			padding: 10px 30px;
			text-transform: uppercase;
			text-decoration: none;
			font-weight: 500;
			margin-top: 10px;
			color: #111;
			letter-spacing: 2px;
			transition: 0.2s;
		}


		.text a:hover {
			letter-spacing: 6px;
		}


		.social {
			position: absolute;
			z-index: 10;
			bottom: 20px;
			display: flex;
			justify-content: center;
			align-items: center;
		}


		.social li {
			list-style: none;
		}


		.social li a {
			display: inline-block;
			margin-right: 20px;
			filter: invert(1);
			transform: scale(0.5);
			transition: 0.5s;
		}


		.social li a:hover{
			transform: scale(0.5) translateY(-15px);
		}


		.menu {
			position: absolute;
			top: 0;
			right: 0;
			width: 300px;
			height: 100%;
			display: flex;
			justify-content: center;
			align-items: center;
		}




		.menu ul {
			position: relative;
		}



		.menu ul li {
			list-style: none;
		}



		.menu ul li a {
			text-decoration: none;
			font-size: 24px;
			color: #111;
		}




		.menu ul li a:hover {
			color: #03a9f4;
		}

		@media (max-width: 991px)
		{
			.showcase,
			.showcase header
			{
				padding: 40px;
			}
			.text h2
			{
				font-size: 3em;
			}
			.text h3
			{
				font-size: 2em;
			}
		}

		.btn-primary {
			margin-top: 5px;
			color: #fff;
			background-color: #ef5350;
			padding: 2px;
			border: 2px solid black;
		}
	</style>

</head>
<!--  navbar   -->
<body>
<section class="showcase">
	<header>
		<h2 class="logo">Book Store</h2>
		<div class="toggle"></div>
	</header>
	<div class="container">
	<!-- navbar -->
	<form method="post" action="/bookEdit"
		enctype="multipart/form-data">
		<!-- Create Recipe Form -->
		<h1>Book Edit</h1>
		<c:forEach var="error" items="${errors}">
			<span style='color: red'>${error}</span>
			<br>
		</c:forEach>

		<br/>

		<div class="mb-3">
			<label for="formGroupExampleInput1" class="form-label">
				Product ID </label> <br/><input type="text" class="form-control"
											 id="fexampleFormControlInput1" name="id"
											 value="${form.id }" />
			<c:forEach items="${errorFields}" var="errorField">
				<c:if test='${errorField.getField().equals("id") }'>
					<br>
					<span style='color: red'>${errorField.defaultMessage}</span>

				</c:if>
			</c:forEach>
		</div>

		<div class="mb-3">
				<label for="formGroupExampleInput1" class="form-label">
					Book Name </label> <br/><input type="text" class="form-control"
					id="fexampleFormControlInput1" name="bookName"
					value="${form.bookName }" />
				<c:forEach items="${errorFields}" var="errorField">
					<c:if test='${errorField.getField().equals("bookName") }'>
						<br>
						<span style='color: red'>${errorField.defaultMessage}</span>

					</c:if>
				</c:forEach>
			</div>

		<div class="mb-3">
			<label for="formGroupExampleInput1" class="form-label">
				Author </label><br/> <input type="text" class="form-control"
										  id="fexampleFormControlInput1" name="author"
										  value="${form.author }" />
			<c:forEach items="${errorFields}" var="errorField">
				<c:if test='${errorField.getField().equals("author") }'>
					<br>
					<span style='color: red'>${errorField.defaultMessage}</span>

				</c:if>
			</c:forEach>
		</div>

			<div class="mb-3">
				<label for="formGroupExampleInput1" class="form-label">
					quantity </label><br/> <input type="number" class="form-control"
					id="fexampleFormControlInput1" name="quantity"
					value="${form.quantity }" />
				<c:forEach items="${errorFields}" var="errorField">
					<c:if test='${errorField.getField().equals("quantity") }'>
						<br>
						<span style='color: red'>${errorField.defaultMessage}</span>

					</c:if>
				</c:forEach>
			</div>

		<div class="mb-3">
			<label for="formGroupExampleInput1" class="form-label">
				price </label><br/> <input type="number" class="form-control"
										 id="fexampleFormControlInput1" name="price"
										 value="${form.price }" />
			<c:forEach items="${errorFields}" var="errorField">
				<c:if test='${errorField.getField().equals("price") }'>
					<br>
					<span style='color: red'>${errorField.defaultMessage}</span>

				</c:if>
			</c:forEach>
		</div>

		<div class="mb-3">
			<label for="formGroupExampleInput1" class="form-label">
				category </label> <br/><input type="text" class="form-control"
									  id="fexampleFormControlInput1" name="category"
									  value="${form.category }" />
			<c:forEach items="${errorFields}" var="errorField">
				<c:if test='${errorField.getField().equals("category") }'>
					<br>
					<span style='color: red'>${errorField.defaultMessage}</span>

				</c:if>
			</c:forEach>
		</div>

			<div>
				<button type="submit" value="submit" class="btn btn-primary">Edit</button>
			</div>

		</div>

		<br> <br>
	</form>

</section>

<!-- here i placed the menu under the section tag -->

<div class="menu">
	<ul>
		<li ><a href="/home">Home</a></li>
		<li ><a href="/bookDisplay">all Books</a></li>
		<li ><a href="/categoryDisplay">all Category</a></li>
		<li ><a href="/seller">Seller</a></li>
		<li ><a href="/buyer">Buyer</a></li>
		<li ><a href="/book">Add Book</a></li>
		<li ><a href="/bookEdit">Edit Book</a></li>
		<li ><a href="/cartDisplay">View Cart</a></li>
		<li ><a href="/logout">Logout</a>

	</ul>
</div>

<script type="application/javascript" >

	const menuToggle = document.querySelector('.toggle');
	const showcase = document.querySelector('.showcase');

	menuToggle.addEventListener('click', () => {
		menuToggle.classList.toggle('active')
		showcase.classList.toggle('active')
	})

</script>
</body>
</html>