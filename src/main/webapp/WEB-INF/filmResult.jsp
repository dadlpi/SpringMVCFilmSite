<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movie Results</title>
</head>
<body>
	<c:choose>
		<c:when test="${! empty films}">
			<h2>Movie Search Results Found for search string "${searchString}":</h2>
			<p>Click on the movie for full movie details:</p>
			<ol>
				<c:forEach var="individualFilm" items="${films}">
					<li><a href="GetFilmData.do?filmId=${individualFilm.filmId}">Id: ${individualFilm.filmId} &ensp;| Name:
						${individualFilm.title} &ensp;| Rating: ${individualFilm.rating}</a></li>
				</c:forEach>
			</ol>

		</c:when>
		<c:otherwise>
			<p>No film found</p>
		</c:otherwise>
	</c:choose>
	<a href="home.do">Return Home</a>
</body>
</html>