<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Student List</title>
	<link rel="stylesheet" href="../resources/member.css" type="text/css"></link>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<div align=center>
		  <header style="width:100%;text-align:left; padding-left: 220px">[학생 목록]</header>
<%-- 		<c:url value="/member/register" var="url"/><a href="${url}">학생 등록</a><br><br> --%>
		<table>
		<div style="width:100%;text-align:left; padding-left: 250px"><c:url value="/member/subjectList" var="url"/><a href="${url}">[과목 목록 보기]</a></div>
		  <tr>
		    <th>ID</th><th>NAME</th><th>STUDENTNUM</th><th>DEPART</th><th>DEPARTNUM</th><th>PHONENUM</th><th>수강가능</th><th>미리담기</th>
		    <th><c:url value="/member/register" var="url"/><a href="${url}">추가하기</a></th>
		  </tr>
		  
		  
		  <!-- 여기 아래부터 고칠 것 -->
		  
		  <c:forEach var="member" items="${students}" >
			  <tr>
			    <td><c:out value="${member.id}"/></td>
			    <td><c:out value="${member.name}"/></td>
			    <td><c:out value="${member.studentNum}"/></td>
			    <td><c:out value="${member.depart}"/></td>
			    <td><c:out value="${member.departNum}"/></td>
			    <td><c:out value="${member.phoneNum}"/></td>
			    <td><c:url value="/member/matchSubject?departNum=${member.departNum}&studentNum=${member.studentNum}" var="url"/><a href="${url}">목록보기</a></td>
			    <td><c:url value="/member/preferList?studentNum=${member.studentNum}" var="url"/><a href="${url}">미리담기</a></td>
			    <td>
			      <c:url value="/member/read?id=${member.id}" var="url"/><a href="${url}">보기</a>
			      <c:url value="/member/modify?id=${member.id}" var="url"/><a href="${url}">수정</a>
			      <c:url value="/member/delete?id=${member.id}" var="url"/><a href="${url}">삭제</a>			      		  
			    </td>
			  </tr>
		  </c:forEach>
		</table>
		
	</div>
</body>
</html>