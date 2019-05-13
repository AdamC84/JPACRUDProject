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
	<form:form action="updateGolfer.do" method="GET" modelAttribute="golfer">
		<form:input path="id" type="hidden" value="${newGolfer.id }"/> 
		First Name:<form:input path="firstName" value="${newGolfer.firstName }"/><br> 
		Last Name:<form:input path="lastName" value="${newGolfer.lastName }"/><br>
		PGA Wins:<form:input path="pgaWins" value="${newGolfer.pgaWins }"/><br> 
		College Attended:<form:input path="collegeAttended" value="${newGolfer.collegeAttended }"/><br> 
		PGA Earnings:<form:input path="totalEarnings" value="${newGolfer.totalEarnings }"/><br> 
	    <input type="submit" value="Submit"/>
		</form:form>
</body>
</html>