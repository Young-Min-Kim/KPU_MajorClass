<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="project.projectDAO" %> 
<%@ page import="java.io.PrintWriter" %> <!-- 자바 클래스 사용 -->
<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="project" class="project.project" scope="page" />
<jsp:setProperty name="project" property="proj_name" />

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>우리할일</title>
</head>
<body>
	<%
	
		String userID = null;
		if (session.getAttribute("id") != null) {
			userID = (String) session.getAttribute("id");
		}
		
		if (project.getProj_name() == null){
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('프로젝트 이름을 입력해 주십시오')");
				script.println("history.back()");
				script.println("</script>");
			} else{
				projectDAO pro = new projectDAO(); //인스턴스생성
				pro.conn();
			    int count = pro.ProCount(userID);
			    int number = count+1;
				int result = pro.AddPro(userID, project.getProj_name(), number);								
				if(result == -1){ // 아이디가 기본키기. 중복되면 오류.
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('이미 존재하는 프로젝트 이름입니다.')");
					script.println("history.back()");
					script.println("</script>");
				}
				//가입성공
				else {
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('프로젝트가 생성 되었습니다.')");
					script.println("location.href = 'afterLogProj.jsp'");
					script.println("</script>");
				}
			}
			%>
</body>
</body>
</html>