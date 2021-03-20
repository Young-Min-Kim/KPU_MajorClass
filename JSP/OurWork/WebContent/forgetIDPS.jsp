<%@page contentType="text/html; charset=utf-8"%>
<!doctype html>
<html class="no-js" lang="java">

<head>
	
	<meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>아이디/비밀번호 찾기</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- <link rel="manifest" href="site.webmanifest"> -->
	<link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">
    <!-- Place favicon.ico in the root directory -->
	<style>
	#section_connector{
		
    	position:absolute;
    	/* width:100%; */
    	left:50px;
    	top:300px;
	}
	</style>
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
       <div >
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
                                <a href="#" class="btn header-btn">회원가입</a>
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
    
   	<div class="row" style="position: relative; left: 300px; top: 180px;">
   	 	<div class="col-12">
     		<h2 class="contact-title">아이디/비밀번호 찾기</h2>
     	</div>
     
   		<div class="col-lg-8">
                        <form class="form-contact contact_form" action="forgetID_process.jsp" method="post" id="contactForm" novalidate="novalidate">
                            
                            <!-- 아이디 찾기 시작 -->
                                <div class="col-12">
                                    <div class="form-group">
                                        <h3>아이디 찾기</h3>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <input class="form-control valid" name="name" id="name" type="text" onfocus="this.placeholder = ''" onblur="this.placeholder = '이름'" placeholder="이름">
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <input class="form-control" name="email" id="email" type="text" onfocus="this.placeholder = ''" onblur="this.placeholder = '이메일'" placeholder="이메일">
                                    </div>
                                </div>
                               
                                
                                <div class="form-group mt-3">
                                
                                	<button type="submit" class="button button-contactForm boxed-btn">아이디 찾기 완료</button>
                           		</div>
                                <!-- 아이디 찾기 끝 -->
                                
                                </form>
                                
                                <form class="form-contact contact_form" action="forgetPS_process.jsp" method="post" id="contactForm" novalidate="novalidate">
                                <!-- 비밀번호 찾기 시작 -->
                                <div class="col-12">
                                	<div class="form-group">
                                        <h3>비밀번호 찾기</h3>
                                    </div>
                                </div>
                           
                                <div class="col-12">
                                    <div class="form-group">
                                        <input class="form-control" name="name_ps" id="name_ps" type="text" onfocus="this.placeholder = ''" onblur="this.placeholder = '이름'" placeholder="이름">
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <input class="form-control" name="id_ps" id="id_ps" type="text" onfocus="this.placeholder = ''" onblur="this.placeholder = '아이디'" placeholder="아이디">
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <input class="form-control" name="email_ps" id="email_ps" type="text" onfocus="this.placeholder = ''" onblur="this.placeholder = '이메일'" placeholder="이메일">
                                    </div>
                                </div>
                                <%
                                	out.println("<br>");
                                %>
                                
                                <div class="form-group mt-3">
                                	<button type="submit" class="button button-contactForm boxed-btn">비밀번호 찾기완료</button>
                           		</div>
                           		<!-- 비밀번호 찾기 끝 -->
                           		
                                </form>
                        </div>
                            
                    
             </div>
</body>