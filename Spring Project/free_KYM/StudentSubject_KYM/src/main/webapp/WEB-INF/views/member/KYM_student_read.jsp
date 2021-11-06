<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>학생 정보</title>
	<link rel="stylesheet" href="../resources/member.css" type="text/css"></link>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<div align=center>
		<header>[학생 정보]</header><br>
		<table>
		<div style="width:100%;text-align:left; padding-left: 500px"><c:url value="/member/list" var="url"/><a href="${url}">[학생 목록 보기]</a></div>
		    <tr><th> LoginID </th><td><c:out value="${student.id}"/></td></tr>
			<tr><th> UserName </th><td><c:out value="${student.name}"/></td></tr>
			<tr><th> StudentNumber </th><td><c:out value="${student.studentNum}"/></td></tr>
			<tr><th> Department </th><td><c:out value="${student.depart}"/></td></tr>
			<tr><th> DepartmentNumber </th><td><c:out value="${student.departNum}"/></td></tr>
			<tr><th> PhoneNumber </th><td><c:out value="${student.phoneNum}"/></td></tr>
		</table>
		
	</div>
</body>
</html>