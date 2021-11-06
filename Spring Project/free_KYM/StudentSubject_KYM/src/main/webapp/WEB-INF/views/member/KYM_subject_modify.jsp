<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>과목 정보 수정</title>
	<link rel="stylesheet" href="../resources/member.css" type="text/css"></link>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<div align=center>
		<header>[과목 정보 수정]</header>
		<form name=form1 action="http://localhost:8080/myweb/member/subjectModify/" method="post">
		<table>
			<tr><th>SubjectNumber</th><td><input type="text" name="subjectNum" readonly value="${subject.subjectNum}"></td></tr>
			<tr><th>SubjectName</th><td><input type="text" name="subjectName" value="${subject.subjectName}"></td></tr>
			<tr><th>DepartmentNumber</th><td><input type="text" name="departNum" value="${subject.departNum}"></td></tr>
			<tr><th>SubjectDivsion</th><td><input type="text" name="subjectDiv" value="${subject.subjectDiv}"></td></tr>
			<tr><th>SubjectCredit</th><td><input type="text" name="subjectCredit" value="${subject.subjectCredit}"></td></tr>
			<tr><th>PresentNumber</th><td><input type="text" name="presentNum" readonly value="${subject.presentNum}"></td></tr>
			<tr><th>MaxNumber</th><td><input type="text" name="maxNum" value="${subject.maxNum}"></td></tr>
		</table><br>
			<input type="submit" name="submit" value="수정하기">
			<input type="reset" name="reset" value="다시작성">
		</form>
	</div>
</body>
</html>