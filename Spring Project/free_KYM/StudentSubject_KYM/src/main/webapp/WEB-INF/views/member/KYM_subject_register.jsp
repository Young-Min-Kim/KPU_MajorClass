<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>과목 등록</title>
	<link rel="stylesheet" href="../resources/member.css" type="text/css"></link>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<div align=center>
		<header>[과목 정보 등록]</header>
		<form name=form1 action="http://localhost:8080/myweb/member/subjectRegister/" method="post">
		<table>	
			<tr><th>SubjectNumber</th><td><input type="text" name="subjectNum" autofocus placeholder="공백없이 입력하세요"></td></tr>
			<tr><th>SubjectName</th><td><input type="text" name="subjectName" placeholder="공백없이 입력하세요"></td></tr>
			<tr><th>DepartmentNumber</th><td><input type="text" name="departNum"  placeholder="공백없이 입력하세요"></td></tr>
			<tr><th>SubjectDivsion</th><td><input type="text" name="subjectDiv" placeholder="공백없이 입력하세요"></td></tr>
			<tr><th>SubjectCredit</th><td><input type="text" name="subjectCredit" placeholder="최소학점: 0/최대학점: 4"></td></tr>
			<tr><th>PresentNumber</th><td><input type="text" name="presentNum" placeholder="공백없이 입력하세요"></td></tr>
			<tr><th>MaxNumber</th><td><input type="text" name="maxNum" placeholder="공백없이 입력하세요"></td></tr>
		</table>
		<dl>
			<dd><input type="submit" name="submit" value="보내기"></dd>
			<dd><input type="reset" name="reset" value="다시 작성"></dd>
		</dl>
		</form>
	</div>
</body>
</html>