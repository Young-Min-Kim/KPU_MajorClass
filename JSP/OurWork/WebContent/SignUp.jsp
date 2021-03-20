<%@page contentType="text/html; charset=utf-8"%>
<!doctype html>
<html class="no-js" lang="java">

<head>
	
	<meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>회원가입</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- <link rel="manifest" href="site.webmanifest"> -->
	<link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">
    <!-- Place favicon.ico in the root directory -->

   <!-- CSS here -->
   <link rel="stylesheet" href="assets/css/bootstrap.min.css">
   <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
   <link rel="stylesheet" href="assets/css/slicknav.css">
   <link rel="stylesheet" href="assets/css/animate.min.css">
   <link rel="stylesheet" href="assets/css/magnific-popup.css">
   <link rel="stylesheet" href="assets/css/fontawesome-all.min.css">
   <link rel="stylesheet" href="assets/css/themify-icons.css">
   <link rel="stylesheet" href="assets/css/themify-icons.css">
   <link rel="stylesheet" href="assets/css/slick.css">
   <link rel="stylesheet" href="assets/css/nice-select.css">
   <link rel="stylesheet" href="assets/css/style.css">
   <link rel="stylesheet" href="assets/css/responsive.css">
</head>

<body>
	 <header>
        <!-- Header Start -->
       <div>
            <div class="main-header header-sticky">
                <div class="container">
                    <div class="row align-items-center">
                        <!-- Logo -->
                        <div class="col-xl-2 col-lg-2 col-md-1">
                            <div class="logo">
                                <a href="index.html"><img src="assets/img/logo/worklogo.png" alt=""></a>
                            </div>
                        </div>
                        <div class="col-xl-8 col-lg-8 col-md-8">
                            <!-- Main-menu -->
                            <div class="main-menu f-right d-none d-lg-block">
                                <nav> 
                                    <ul id="navigation">    
                                        <div class="d-none d-md-block recommend"></div>
                                        <li><a href="Login.jsp">로그인</a></li>
                                        <li><a href="about.jsp">소개</a></li>
                                        
                                            <ul class="submenu">
                                                <li><a href="blog.html">Blog</a></li>
                                                <li><a href="single-blog.html">Blog Details</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="#"></a>
                                            
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                        </div>             
                        <div class="col-xl-2 col-lg-2 col-md-3">
                            <div class="header-right-btn f-right d-none d-lg-block">
                            </div>
                        </div>
                        <!-- Mobile Menu -->
                        <div class="col-12">
                            <div class="mobile_menu d-block d-lg-none"></div>
                        </div>
                    </div>
                </div>
            </div>
       </div>
        <!-- Header End -->
    </header>
    
    <!-- ================ contact section start ================= -->
    <section class="contact-section">
            <div class="container">
                <div class="d-none d-sm-block mb-5 pb-4">
                 	 <!--blank-->
                </div>
    
    			<!-- ================ widget start!! ================= -->
                <div class="row">
                    <div class="col-12">
                        <h2 class="contact-title">회원가입</h2>
                    </div>
                    <div class="col-lg-8">
                        <form class="form-contact contact_form" action="SignUp_process.jsp" method="post" id="contactForm" novalidate="novalidate">
                            <div class="row">
                                <!-- ================ 이름 ================= -->
                                <div class="col-12">
                                    <div class="form-group">
                                        <input class="form-control valid" name="name" type="text" onfocus="this.placeholder = ''" onblur="this.placeholder = '이름'" placeholder="이름">
                                    </div>
                                </div>
                                <!-- ================ 아이디 ================= -->
                                <div class="col-12">
                                    <div class="form-group">
                                        <input class="form-control" name="id" type="text" onfocus="this.placeholder = ''" onblur="this.placeholder = '아이디'" placeholder="아이디">
                                    </div>
                                </div>
                                <!-- ================ 비밀번호 ================= -->
                                <div class="col-12">
                                    <div class="form-group">
                                        <input class="form-control" name="passwd" type="passwd" onfocus="this.placeholder = ''" onblur="this.placeholder = '비밀번호'" placeholder="비밀번호">
                                    </div>
                                </div>
                                <!-- ================ 이메일================= -->
                                <div class="col-8">
                                    <div class="form-group">
                                        <input class="form-control valid" name="email" type="email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter email address'" placeholder="Email">
                                    </div>
                                </div>
                                <!-- ================ 인증버튼 ================= -->
                                <div class="col-4">
                                    <div class="form-group">
                                      <button type="submit" class="button button-contactForm boxed-btn">인증하기</button> 
                                    </div>
                                </div>
                                <!-- ================ 전화번호 ================= -->
                                <div class="col-12">
                                	<div calss="form-group">
                                		연락처
                                		<%
                                			out.println("<br>");
                                			out.println("<br>");
                                		%>				
                                		<select name="phone1">
                                			<option value="010">010</option>
                                			<option value="010">011</option>
                                			<option value="010">016</option>
                                			<option value="010">017</option>
                                			<option value="010">019</option>
                                	</select> - <input type="text" maxlength="4" size="4" name="phone2"> - <input type="text" maxlength="4" size="4" name="phone3">
                                	</div>
                                	<%
                                		out.println("<br>");
                                		out.println("<br>");
                                	%>		
                                </div>
                                <!-- ================ 자기소개 ================= -->
                                <div class="col-12">
                                    <div class="form-group">
                                        <textarea class="form-control w-100" name="introduce" cols="30" rows="9" onfocus="this.placeholder = ''" onblur="this.placeholder = '자기소개'" placeholder=" 자기 소개"></textarea>
                                       
                                    </div>
                            	</div>
                            </div>
                            
                            
                            <div class="form-group mt-3">
                                <button type="submit" class="button button-contactForm boxed-btn">가입 완료</button>
                            </div>
                        </form>
                    </div>
                    <div class="col-lg-3 offset-lg-1">
                        <div class="media contact-info">
                            <span class="contact-info__icon"><i class="ti-home"></i></span>
                            <div class="media-body">
                                <h3>hi</h3>
                                <p></p>
                            </div>
                        </div>
                        <div class="media contact-info">
                            <span class="contact-info__icon"><i class="ti-tablet"></i></span>
                            <div class="media-body">
                                <h3>+1 253 565 2365</h3>
                                <p>Mon to Fri 9am to 6pm</p>
                            </div>
                        </div>
                        <div class="media contact-info">
                            <span class="contact-info__icon"><i class="ti-email"></i></span>
                            <div class="media-body">
                                <h3>hancar2007@naver.com</h3>
                                <p>언제든지 의견을 이메일로 보내주세요!</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    <!-- ================ contact section end ================= -->
	

    
   



</body>