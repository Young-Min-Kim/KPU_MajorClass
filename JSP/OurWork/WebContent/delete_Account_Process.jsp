<!--로그인 처리 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="user.UserDAO" %> <!-- userdao의 클래스 가져옴 -->
<%@ page import="java.io.PrintWriter" %> <!-- 자바 클래스 사용 -->
<% request.setCharacterEncoding("UTF-8"); %>

<!-- 한명의 회원정보를 담는 user클래스를 자바 빈즈로 사용 / scope:페이지 현재의 페이지에서만 사용-->

<jsp:useBean id="user" class="user.User" scope="request" />
<jsp:setProperty name="user" property="id" />
<jsp:setProperty name="user" property="passwd" /> 

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>우리할일</title>
</head>
<body>
	<%
		UserDAO userDAO = new UserDAO(); //인스턴스생성
		userDAO.conn();
		int result = userDAO.Delete(user.getId(), user.getPasswd());
		
		%>
		<%=user.getId() %>
		<%=user.getPasswd() %>
		<%=result %>
		<%
		
		//삭제 성공
		if(result == 1){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('계정이 삭제되었습니다.')");
			script.println("location.href = 'about.jsp'");
			script.println("</script>");
			session.setAttribute("id",user.getId());
		}
		//로그인 실패
		else if(result == 0){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('비밀번호가 틀립니다.')");
			script.println("history.back()");
			script.println("</script>");
		}
		//DB오류
		else if(result == -2){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('DB오류가 발생했습니다.')");
		script.println("history.back()");
		script.println("</script>");
		}	
		
	%>
</body>
</body>
</html>