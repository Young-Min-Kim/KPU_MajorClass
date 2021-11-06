<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Subject List</title>
	<link rel="stylesheet" href="../resources/member.css" type="text/css"></link>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<div align=center>
		<header style="width:100%;text-align:left; padding-left: 160px">[과목 목록]</header><br>
<%-- 		<c:url value="/member/register" var="url"/><a href="${url}">학생 등록</a><br><br> --%>
		<table>
		<div style="width:100%;text-align:left; padding-left: 180px"><c:url value="/member/list" var="url"/><a href="${url}">[학생 목록 보기]</a></div>
		  <tr>
		    <th>SUBJECT</th><th>SUBJECTNAME</th><th>DEPARTNUM</th><th>SUBJECTDIV</th><th>SUBJECTCREDIT</th><th>PRESENTNUM</th><th>MAXNUM</th><th>PREFERENCE</th>
		    <th><c:url value="/member/subjectRegister" var="url"/><a href="${url}">추가하기</a></th>
		  </tr>
		  
		  
		  <!-- 여기 아래부터 고칠 것 -->
		  
		  <c:forEach var="member" items="${subjects}" >
			  <tr>
			    <td><c:out value="${member.subjectNum}"/></td>
			    <td><c:out value="${member.subjectName}"/></td>
			    <td><c:out value="${member.departNum}"/></td>
			    <td><c:out value="${member.subjectDiv}"/></td>
			    <td><c:out value="${member.subjectCredit}"/></td>
			    <td><c:out value="${member.presentNum}"/></td>
			    <td><c:out value="${member.maxNum}"/></td>
			    <td><c:out value="${member.preference}"/></td>
			    <td>
			      <c:url value="/member/subjectRead?subjectNum=${member.subjectNum}" var="url"/><a href="${url}">보기</a>
			      <c:url value="/member/subjectModify?subjectNum=${member.subjectNum}" var="url"/><a href="${url}">수정</a>
			      <c:url value="/member/subjectDelete?subjectNum=${member.subjectNum}" var="url"/><a href="${url}">삭제</a>
			    </td>
			  </tr>
		  </c:forEach>
		</table>
	</div>
</body>
</html>