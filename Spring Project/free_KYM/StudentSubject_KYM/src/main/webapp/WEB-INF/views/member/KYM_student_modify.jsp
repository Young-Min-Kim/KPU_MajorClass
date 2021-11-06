<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>정보 수정</title>
	<link rel="stylesheet" href="../resources/member.css" type="text/css"></link>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<div align=center>
		<header>[학생 정보 수정]</header>
		<form name=form1 action="http://localhost:8080/myweb/member/modify/" method="post">
		<table>
			<tr><th>LoginID</th><td><input type="text" name="id" readonly value="${student.id}"></td></tr>
			<tr><th>UserName</th><td><input type="text" name="name" value="${student.name}"></td></tr>
			<tr><th>StudentNumber</th><td><input type="text" name="studentNum" value="${student.studentNum}"></td></tr>
			<tr><th>Department</th><td><input type="text" name="depart" value="${student.depart}"></td></tr>
			<tr><th>DepartmentNumber</th><td><input type="text" name="departNum" value="${student.departNum}"></td></tr>
			<tr><th>PhoneNumber</th><td><input type="text" name="phoneNum" value="${student.phoneNum}"></td></tr>
		</table><br>
			<input type="submit" name="submit" value="수정하기">
			<input type="reset" name="reset" value="다시작성">
		</form>
	</div>
</body>
</html>