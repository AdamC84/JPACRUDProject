<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Please Fill Out The Film Form</title>
</head>
<body>
	<form action="createGolfer.do" method="GET">
		<label for="golfer_first_name">First Name:</label><input type="text"name="firstName"><br /> 
			<label for="golfer_last_name">Last Name:</label><input type="text" name="lastName"><br>
		<label for="PGA_wins">PGA Wins:</label><input type="text" name="pgaWins"><br /> 
		<label for="College_Attended">College Attended:</label><input type="text" name="collegeAttended"><br /> 
		<label for="PGA_earnings">PGA earnings:</label><input type="text" name="earnings"><br /> 
		</select><br /> <input type="submit" value="Submit">
	</form>
</body>

</html>