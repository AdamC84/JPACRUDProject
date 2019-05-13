<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PGA Golfer Query</title>
</head>
<body>

	<c:if test="${empty newGolfer }">
		<h2>Your query returned no results.</h2>
	</c:if>
	<c:if test="${not empty newGolfer }">
	<h3>${newGolfer.firstName }${newGolfer.lastName }</h3>
			<ul>
				<li>PGA wins: ${newGolfer.pgaWins}</li>
				<li>College Attended: ${newGolfer.collegeAttended}</li>
				<li>Total PGA earnings ${newGolfer.totalEarnings}</li>
			</ul>
	</c:if>
		
	
		<form action="updateGolfer.do?value=${newGolfer.id }" method="GET">
			<input type="submit" value="Edit">
		</form>
		<h2>Would you like to delete this Golfer?</h2>
		<form action="deleteGolfer.do" method="GET">
			<label for="deleteGolfer">Type yes.</label><input type="text"
				name="yes"><br /> <input type="submit" value="Submit">
		</form>
		<form action="home.do" method="GET">
			<label for="home"></label><input type="submit" value="Home" />
		</form>
</body>
</html>