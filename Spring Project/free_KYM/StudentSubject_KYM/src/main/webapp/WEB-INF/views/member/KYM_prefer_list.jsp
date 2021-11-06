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
		<header style="width:100%;text-align:left; padding-left: 140px">[미리담기 과목 목록]</header><br>
		<table>
		<div style="width:100%;text-align:left; padding-left: 170px"><c:url value="/member/list" var="url"/><a href="${url}">[학생 목록 보기]</a></div>
		<div style="width:100%;text-align:left; padding-left: 170px"><c:url value="/member/subjectList" var="url"/><a href="${url}">[과목 목록 보기]</a></div>
		<div style="width:100%;text-align:left; padding-left: 170px"><a>[신청한 학점 합계: </a><c:out value="${creditCnt}"/><a> ]</a></div>
		  <tr>
		    <th>SUBJECTNUMBER</th><th>SUBJECTNAME</th><th>DEPARTNUM</th><th>SUBJECTDIV</th><th>SUBJECTCREDIT</th><th>PRESENTNUM</th><th>MAXNUM</th><th>PREFERENCE</th><th>미리담기취소</th>
		  </tr>
		  
		  
 
		  <c:forEach var="member" items="${prefer}" >
			  <tr>
			    <td><c:out value="${member.subjectNum}"/></td>
			    <td><c:out value="${member.subjectName}"/></td>
			    <td><c:out value="${member.departNum}"/></td>
			    <td><c:out value="${member.subjectDiv}"/></td>
			    <td><c:out value="${member.subjectCredit}"/></td>
			    <td><c:out value="${member.presentNum}"/></td>
			    <td><c:out value="${member.maxNum}"/></td>
			    <td><c:out value="${member.preference}"/></td>
			    <td><c:url value="/member/preferDelete?studentNum=${studentNum}&subjectNum=${member.subjectNum}" var="url"/><a href="${url}">취소</a></td>
			    <td>
			    </td>
			  </tr>
		  </c:forEach>
		</table>
			
	</div>
</body>
</html>