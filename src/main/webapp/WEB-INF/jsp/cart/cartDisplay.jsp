<%@ page import="lombok.var" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
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

		.content-table {
			border-collapse: collapse;
			margin: 25px 0;
			font-size: 0.9em;
			min-width: 400px;
			border-radius: 5px 5px 0 0;
			overflow: hidden;
			box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
			color: #111111;
		}

		.content-table thead tr {
			background-color: #2691d9;
			color: #ffffff;
			text-align: left;
			font-weight: bold;
		}

		.content-table th,
		.content-table td {
			padding: 12px 15px;
		}

		.content-table tbody tr {
			border-bottom: 1px solid #dddddd;
		}

		.content-table tbody tr:nth-of-type(even) {
			background-color: #f3f3f3;
		}

		.content-table tbody tr:last-of-type {
			border-bottom: 2px solid #2691d9;
		}

		.content-table tbody tr.active-row {
			font-weight: bold;
			color: #2691d9;
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
	<!-- navbar -->
	<div class="container">
	<h1> Cart </h1>


		<c:choose>
			<c:when test="${empty carts }">
				<h1>Please Add Books To Cart.</h1>
			</c:when>
			<c:otherwise>
				<table class="content-table">
					<tr>
						<td><b>ID</b></td>
						<td><b>Book name</b></td>
						<td><b>Author</b></td>
						<td><b>Price</b></td>
						<td><b>Quantity</b></td>
						<td><b>Amount</b></td>
						<td><b>Action</b></td>
					</tr>


					<%! float total = 0; %>
					<c:forEach items="${carts}" var="carts">
						<c:set var="total" value="${total + carts.price * carts.quantity }"></c:set>
						<tr>

							<td>${carts.id }</td>
							<td>${carts.bookName }</td>
							<td>${carts.author }</td>
							<td>${carts.price }</td>
							<td><form method="get" action="/editCart"><input type="hidden" name="id" value="${carts.id }">  <input type="number" name="quentity" value="${carts.quantity }" style="width: 50px" > <input type="hidden" name="bookName" value="${carts.bookName }" > <input type="hidden" name="author" value="${carts.author }" > <input type="hidden" name="price" value="${carts.price }" > <input type="submit" value="Edit" > </form></td>
							<td>${carts.price * carts.quantity }</td>

							<td><a href="/deleteCart?id=${carts.id }">Delete</a> </td>
						</tr>
					</c:forEach>
					<tr style="border: 1px solid black">
						<td colspan="5"  align="right">Total</td>
						<td>${total }</td>
						<td  align="right"><a href="/checkout">Checkout</a></td>
					</tr>
				</table>

			</c:otherwise>
		</c:choose>

	</div>
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