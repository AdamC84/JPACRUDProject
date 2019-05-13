<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PGA Player Database</title>
</head>
<body>
	<h2>Enter the ID of the Golfer you'd like to find.</h2>
	<form action="findGolferByID.do" method="GET">
		<label for="golferID">Film ID:</label><input type="text" name="id"><br />
		<input type="submit" value="Submit">
	</form>
	<h2>Search by Keyword</h2>
	<form action="keyword.do" method="GET">
		<label for="keyword">Keyword:</label><input type="text" name="keyword"><br />
		<input type="submit" value="Submit">
	</form>
	
	<br>
	<h2>Would you like to add a Golfer to the database?</h2>
	<form action="addGolfer.do" method="GET">
		<label for="addGolfer"> Add Golfer:</label> <input type="submit"
			value="ADD Golfer">
	</form>
</body>

</html>