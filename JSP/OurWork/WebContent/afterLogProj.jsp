<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="project.projectDAO"%>
<head>
<!--세션의 id 가져옴-->
<%
		String userID = null;
		if (session.getAttribute("id") != null) {
			userID = (String) session.getAttribute("id");
		}
	%>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Projects</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- <link rel="manifest" href="site.webmanifest"> -->
<link rel="shortcut icon" type="image/x-icon" href="assets/img/icon.png">
<!-- Place favicon.ico in the root directory -->

<!-- CSS here -->
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/owl.carousel.min.css">
<link rel="stylesheet" href="assets/css/slicknav.css">
<link rel="stylesheet" href="assets/css/animate.min.css">
<link rel="stylesheet" href="assets/css/magnific-popup.css">
<link rel="stylesheet" href="assets/css/fontawesome-all.min.css">
<link rel="stylesheet" href="assets/css/themify-icons.css">
<link rel="stylesheet" href="assets/css/slick.css">
<link rel="stylesheet" href="assets/css/nice-select.css">
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="assets/css/responsive.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

</head>

<body>
	<!-- Preloader Start -->
	<div id="preloader-active">
		<div
			class="preloader d-flex align-items-center justify-content-center">
			<div class="preloader-inner position-relative">
				<div class="preloader-circle"></div>
				<div class="preloader-img pere-text">
					<img src="assets/img/icon.png" alt="">
				</div>
			</div>
		</div>
	</div>
	<!-- Preloader Start-->

	<header>
		<!-- Header Start -->
		<div class="header-area header-transparrent " style="margin-top: 30px">
			<div class="main-header header-sticky">
				<div class="container">
					<div class="row align-items-center">
						<!-- Logo -->
						<div class="col-xl-2 col-lg-2 col-md-2">
							<div class="logo">
								<a href="afterLogProj.jsp"><img
									src="assets/img/logo/worklogo.png" alt=""></a>
							</div>
						</div>


						<div class="col-xl-8 col-lg-8 col-md-8">
							<!-- Main-menu -->
							<div class="main-menu f-right d-none d-lg-block">
								<nav>
									<ul id="navigation">

										<li><a href="#" onclick="crayBtn1()" title="새 프로젝트 생성"><img
												src="assets/img/add.png"></a></li>
										<!-- 프로젝트 생성다이얼로그 -->
										<div id="newProject-dialog" title="새 프로젝트 생성"
											style='display: none'>
											<form action="ProjectAdd_Process.jsp" method="post" )>
												<p>
													프로젝트 이름: <input type="text" name="proj_name"> <br>
													<br> <input type="submit" value="생성"> <input
														type="reset" value="취소">
											</form>
										</div>
										
										<li><a href="#" title="설정"><img
												src="assets/img/setting.png"></a>
											<ul class="submenu">
												<li><a href="#" onclick= "crayBtn3()">계정 설정</a></li>
												<div id="setting-dialog" title="설정" style='display: none'>
													
													<ul>
																								
															
															<li>
																<a href="#" onclick= "crayBtn5()" style="width:100% ;margin-bottom:5px" class="button button-contactForm boxed-btn">
																	계정 삭제</a>
																<div id="deleteAcc-dialog" title="계정 삭제" style='display: none'>
																	<form method="post" action="delete_Account_Process.jsp">
																		<h4>비밀번호를 입력하세요.</h4>
																		<input class="form-control"  type="text" name="id" id="id" value="<%=userID%>"  readonly >
																		<input class="form-control" name="passwd" id="passwd" type="password" onfocus="this.placeholder = ''" onblur="this.placeholder = '비밀번호'" placeholder="비밀번호">
																		<br><button type="submit" style="width:100%" class="button button-contactForm boxed-btn">확인</button>
																	</form>
																</div>
															</li>
													</ul>
												</div>
												
												<li><a href="#" onclick="crayBtn2()">Help</a></li>
												<!-- HELP -->
												<div id="help-dialog" title="Help" style='display: none'>
													<h4>문제가 발생하면 언제나 연락주세요!</h4>
													<br>
													<p>
														<b>Phone:</b> 010 - 1231 - 1242
													</p>
													<p>
														<b>Email:</b> ourwork@kpu.ac.kr
													</p>
												</div>
											</ul></li>
									</ul>
								</nav>
							</div>
						</div>
						<div class="col-xl-2 col-lg-2 col-md-2">
							<div class="header-right-btn f-right d-none d-lg-block">
								<a href="logoutAction.jsp" class="btn header-btn"">로그아웃</a>
							</div>
						</div>
						<!-- Mobile Menu -->
						<div class="col-12">
							<div class="mobile_menu d-lg-none"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Header End -->
	</header>

	<!-- Slider Area Start-->
	<div class="services-area"></div>
	<!-- Slider Area End-->

	<!--================Blog Area =================-->

	<section class="blog_area section-paddingr">
		<div class="container">
			<div class="row">
				<!--================ 왼쪽 메뉴 =================-->
				<div class="col-xl-2 col-lg-2">
					<div class="blog_right_sidebar">
						<aside class="single_sidebar_widget post_category_widget">
							<h4 class="widget_title">
								<b>메뉴</b>
							</h4>
							<ul class="list cat-list">
								<li><a href="afterLogProj.jsp" class="d-flex">
										<p>프로젝트</p>
								</a></li>
								
								<li><a href="afterLogTeam.jsp" class="d-flex">
										<p>팀</p>
								</a></li>
							</ul>
						</aside>


					</div>
				</div>

				<!--================ 오른쪽 내용 =================-->
				<div class="col-xl-10 col-lg-10 mb-6 mb-lg-0"
					style="height: 550px; border: 3px solid #d0d0d0; padding: 3%; background-color: #fbf9ff";>
					<div class="blog_left_sidebar">
						<article class="blog_item">

							<%
								projectDAO pro = new projectDAO();
								pro.conn();
							    int proNum = pro.ProCount(userID);
							    for(int i=1 ;i<proNum+1;i++){
							    String name = pro.ProName(userID, i);
							       %>
							<a href="toDoListLastVer.jsp?proj_name=<%=name%>">
								<button type="button" value=<%=name%>
									class="button button-contactForm boxed-btn"
									style="width: 26.5%; height: 140px; border-radius: 10px; margin: 3%">
									<%=name%>
								</button>
							</a>
							<%}%>
						</article>
					</div>
				</div>

			</div>
		</div>
	</section>
	<!--================Blog Area =================-->


	<!-- 밑에는 신경안써도도미~~~~~ -->
	<footer> </footer>

	<!-- JS here -->


	<script>
function crayBtn1()
{
	$('#newProject-dialog').dialog({
		modal: true, 
	});
}

function crayBtn2()
{
	$('#help-dialog').dialog({
		modal: true, 
	});
}

function crayBtn3()
{
	$('#setting-dialog').dialog({
		modal: true, 
	});
}

function crayBtn4()
{
	$('#pwdchange-dialog').dialog({
		modal: true, 
	});
}

function crayBtn5()
{
	$('#deleteAcc-dialog').dialog({
		modal: true, 
	});
}
</script>

	<!-- All JS Custom Plugins Link Here here -->
	<script src="./assets/js/vendor/modernizr-3.5.0.min.js"></script>

	<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
	<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script src="./assets/js/popper.min.js"></script>

	<!-- Jquery Mobile Menu -->
	<script src="./assets/js/jquery.slicknav.min.js"></script>

	<!-- Jquery Slick , Owl-Carousel Plugins -->
	<script src="./assets/js/owl.carousel.min.js"></script>
	<script src="./assets/js/slick.min.js"></script>

	<!-- One Page, Animated-HeadLin -->
	<script src="./assets/js/wow.min.js"></script>
	<script src="./assets/js/animated.headline.js"></script>

	<!-- Scrollup, nice-select, sticky -->
	<script src="./assets/js/jquery.scrollUp.min.js"></script>
	<script src="./assets/js/jquery.nice-select.min.js"></script>
	<script src="./assets/js/jquery.sticky.js"></script>
	<script src="./assets/js/jquery.magnific-popup.js"></script>

	<!-- contact js -->
	<script src="./assets/js/contact.js"></script>
	<script src="./assets/js/jquery.form.js"></script>
	<script src="./assets/js/jquery.validate.min.js"></script>
	<script src="./assets/js/mail-script.js"></script>
	<script src="./assets/js/jquery.ajaxchimp.min.js"></script>

	<!-- Jquery Plugins, main Jquery -->
	<script src="./assets/js/plugins.js"></script>
	<script src="./assets/js/main.js"></script>

</body>
</html>


<!-- 
알림 서브메뉴처럼
설정

 -->