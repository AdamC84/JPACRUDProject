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

	
		
	<c:forEach var="golferList" items="${golferList }">

			<h3>${golferList.firstName }${golferList.lastName }</h3>
			<ul>
				<li>PGA wins: ${golferList.pgaWins}</li>
				<li>College Attended: ${golferList.collegeAttended}</li>
				<li>Total PGA earnings ${golferList.totalEarnings}</li>
			</ul>
		<form action="updateGolfer.do?id=${golferList.id }" method="GET">
			<input type="submit" value="Edit">
		</form>
		<h2>Would you like to delete this Golfer?</h2>
		<form action="deleteGolfer.do" method="GET">
			<label for="deleteGolfer">Type yes.</label><input type="text"
				name="yes"><br /> <input type="submit" value="Submit">
		</form>
		</c:forEach>
		<form action="home.do" method="GET">
			<label for="home"></label><input type="submit" value="Home" />
		</form>
</body>
</html>