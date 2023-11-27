<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Film Site</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>

	<h1>Welcome to Diego's Film Site</h1><br>

	<!-- Find by Film ID -->
	<div>
		<h3>Search by Film ID:</h3>
		<form action="GetFilmData.do" method="get">
			<label for="filmId">Film ID:</label> <br>
			<input type="number" name="filmId"> 
			<input class="btn btn-success" type="submit" value="Search">
		</form>
	</div>
	<!-- Find by Film some matching string -->
	<div>
		<h3>Film Name or Description:</h3>
		<form action="GetFilmData.do" method="get">
			<label for="searchString">Some Matching Search String related to Film:</label><br> 
			<input type="text" name="searchString">
			<input class="btn btn-success" type="submit" value="Search">
		</form>
	</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>