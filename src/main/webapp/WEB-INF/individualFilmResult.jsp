<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Individual Film Result</title>
</head>
<body>
	<c:choose>
		<c:when test="${! empty film}">
			<h2>Individual Film Details</h2>
			<ul>
				<li><strong>Film ID:</strong> ${film.filmId}</li>
				<li><strong>Film Title:</strong> ${film.title}</li>
				<li><strong>Film Release Year:</strong> ${film.releaseYear}</li>
				<li><strong>Film Language:</strong> ${film.language}</li>
				<li><strong>Film Rental Duration:</strong> ${film.rental_duration} day(s)</li>
				<li><strong>Film Rental Rate:</strong> ${film.rental_rate} dollars</li>
				<li><strong>Film Replacement Cost:</strong> ${film.replacementCost} dollars</li>
				<li><strong>Film Length:</strong> ${film.length} minutes</li>
				<li><strong>Film Rating:</strong> ${film.rating}</li>
				<li><strong>Film Special Features:</strong> ${film.specialFeatures}</li>
				<li><strong>Film Category:</strong> ${film.category}</li>
			</ul>
			<div>
				<h4>Description</h4>
				<table>
					<tr>
						<td>${film.descriptionOffilm}</td>
					</tr>
				</table>
			</div>
			<h4>Cast:</h4>
			<ul>
				<c:forEach var="individualCastMember" items="${film.cast}">
					<li>${individualCastMember.lastName},
						${individualCastMember.firstName}</li>
				</c:forEach>
			</ul>
		</c:when>
		<c:otherwise>
			<p>No individual film found</p>
		</c:otherwise>
	</c:choose>
	<a href="home.do">Return Home</a>
</body>
</html>