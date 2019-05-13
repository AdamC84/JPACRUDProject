<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Please Fill Out The Golfer Form</title>
</head>
<body>
	<form:form action="createGolfer.do" method="GET" modelAttribute="golfer">
		First Name:<form:input type="text" path="firstName"/><br /> 
		Last Name:<form:input type="text" path="lastName"/><br>
		PGA Wins:<form:input type="text" path="pgaWins"/><br /> 
		College Attended:<form:input type="text" path="collegeAttended"/><br /> 
		PGA earnings:<form:input type="text" path="totalEarnings"/><br /> 
		<input type="submit" value="Submit">
	</form:form>
</body>

</html>