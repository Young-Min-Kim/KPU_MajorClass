<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>과목 정보</title>
	<link rel="stylesheet" href="../resources/member.css" type="text/css"></link>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<div align=center>
		<header>[과목 정보]</header><br>
		<div style="width:100%;text-align:left; padding-left: 515px"><c:url value="/member/subjectList" var="url"/><a href="${url}">[과목 목록 보기]</a></div>
		<table>
		    <tr><th> SubjectNumber </th><td><c:out value="${subject.subjectNum}"/></td></tr>
			<tr><th> SubjectName </th><td><c:out value="${subject.subjectName}"/></td></tr>
			<tr><th> DepartmentNumber </th><td><c:out value="${subject.departNum}"/></td></tr>
			<tr><th> SubjectDivsion </th><td><c:out value="${subject.subjectDiv}"/></td></tr>
			<tr><th> SubjectCredit </th><td><c:out value="${subject.subjectCredit}"/></td></tr>
			<tr><th> PresentNumber </th><td><c:out value="${subject.presentNum}"/></td></tr>
			<tr><th> MaxNumber </th><td><c:out value="${subject.maxNum}"/></td></tr>
		</table>

	</div>
</body>
</html>