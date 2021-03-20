<%@ page contentType="text/html; charset=utf-8"%>
<head>
	<style>
		body{
			background-image : url('assets/img/background.jpg');

			background-repeat : no-repeat;

			background-size : cover;"
			width : 300px;
			height : 1000px;
	</style>
<link rel = "stylesheet" href = "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
   <title>SEO HTML-5 Template </title>
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
  <link rel="stylesheet" href="assets/css/themify-icons.css">
  <link rel="stylesheet" href="assets/css/slick.css">
  <link rel="stylesheet" href="assets/css/nice-select.css">
  <link rel="stylesheet" href="assets/css/style.css">
  <link rel="stylesheet" href="assets/css/responsive.css">


<!--드래그 할일 목록  -->
<link href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css">
<style>




/*기존 코드  */

.itemBox {
	border: solid 2px #ff858f;
	border-radius: 10px;
	width: 600px;
	height: 60px;
	padding: 10px;
	margin-bottom: 10px;
}

.itemBoxHighlight {
	border: solid 2px #ff858f;
	border-radius: 10px;
	width: 600px;
	height: 60px;
	padding: 10px;
	margin-bottom: 10px;
	background-color: #ffc4c9;
}

.deleteBox {
	float: right;
	display: none;
	cursor: pointer;
}
</style>
<style>
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script type="text/javascript">
	//<![CDATA[
	/** 아이템을 등록한다. */
	function submitItem(submit) {
		if (!validateItem()) {
			return;
		}
		alert("등록");
		// 저장 버튼 눌렀을때 읽기모드로  텍스트  고정 해주기
		
		$(submit).parent().parent().children('.ui-sortable').children('.itemBox').children().children('.item').attr('readonly', 'readonly');
 		$(submit).parent().children('#editItem').css('display', 'inline-block'); // 편집 버튼 나오게 표시
		$(submit).css('display', 'none'); // 저장 버튼 숨기기


		//alert($(submit).parent().parent().children('.ui-sortable').attr('class')); // 버튼의 부모 자식 찾기 용
	}
	
	function editItem(edit) {
		alert("편집 모드");
		
		//편집 버튼 누르면 쓰기 모드로 전환
		$(edit).parent().parent().children('.ui-sortable').children('.itemBox').children().children('.item').removeAttr('readonly');
 		$(edit).parent().children('#submitItem').css('display', 'inline-block'); // 저장 버튼 나오게 표시
		$(edit).css('display', 'none'); // 편집 버튼은 숨기기
	}

	/** 아이템 체크 */
	function validateItem() {
		var items = $("input[type='text'][name='item']");
		if (items.length == 0) {
			alert("작성된 아이템이 없습니다.");
			return false;
		}

		var flag = true;
		for (var i = 0; i < items.length; i++) {
			if ($(items.get(i)).val().trim() == "") {
				flag = false;
				alert("내용을 입력하지 않은 항목이 있습니다.");
				break;
			}
		}

		return flag;
	}

	/** UI 설정 */
	$(function() {
		$("#itemBoxWrap").sortable({
			placeholder : "itemBoxHighlight",
			start : function(event, ui) {
				ui.item.data('start_pos', ui.item.index());
				
				
				$('#itemBoxWrap').children('.itemBox').children().children('.item').removeAttr('readonly');
				$('#itemBoxWrap').parent().children('.add_and_submmit').children('#submitItem').css('display', 'inline-block'); // 저장 버튼 나오게 표시
				$('#itemBoxWrap').parent().children('.add_and_submmit').children('#editItem').css('display', 'none'); // 편집 버튼은 숨기기 
				
				//alert($('#itemBoxWrap').parent().children('.add_and_submmit').attr('class'));
			},
			stop : function(event, ui) {
				var spos = ui.item.data('start_pos');
				var epos = ui.item.index();
				reorder();
			}
		});
		
		
		$("#itemBoxWrap").disableSelection();
		$("#sortable").sortable();
		$("#sortable").disableSelection();
	});

	/** 아이템 순서 조정 */
	function reorder() {
		$(".itemBox").each(function(i, box) {
			$(box).find(".itemNum").html("<div style='width:15px; float:left;'>"+(i+1)+"</div>"); // div는 블록태그라 무조건 한줄에 하나 -> float해서 div 사이드에 붙이기 가능
		});
	}

	/** 아이템 추가 */
	function createItem(project) {
		$(createBox())
				/* .appendTo("#itemBoxWrap") */
				.appendTo($(project).parent().parent().children().last()) 
				.hover(function() {// hover -> 마우스 올렸을 때 / 첫번쨰 펑션은 마우스 올렸을 때 , 두번째 펑션은 마우스 내렸을 때
					$(this).css('backgroundColor', '#ffebeb'); // 백그라운드 색 바꾸고
					$(this).find('.deleteBox').show(); // 마우스 올리면 보이게
				}, function() { // 두번쨰 펑션
					$(this).css('background', 'none'); // 원상 복귀
					$(this).find('.deleteBox').hide(); // 삭제 버튼 숨기기
				})
				.append("<div class='deleteBox'>[삭제]</div>")
				.find(".deleteBox")
				.click(
						function() {
							var valueCheck = false;
							$(this).parent().find('input').each(
									function() {
										if ($(this).attr("name") != "type"
												&& $(this).val() != '') {
											valueCheck = true;
										}
									});

							if (valueCheck) {
								var delCheck = confirm('입력하신 내용이 있습니다.\n삭제하시겠습니까?');
							}
							if (!valueCheck || delCheck == true) {
								$(this).parent().remove();
								reorder(); // 삭제하고 나서 다시 숫자 정렬
							}
						});
		// 숫자를 다시 붙인다.
		reorder();// 옮기든 언제든 숫자 정렬
		
		// 추가 버튼을 눌러주면 다시 편집 모드에서 저장 모드로 변경
		$(project).parent().parent().children('.ui-sortable').children('.itemBox').children().children('.item').removeAttr('readonly');
		$(project).parent().children('#submitItem').css('display', 'inline-block'); // 저장 버튼 나오게 표시
		$(project).parent().children('#editItem').css('display', 'none'); // 편집 버튼은 숨기기
	}

	// 엔터키 엑션 구현 하다가 실패
	var enterkey = function(inputBox) {//엔터키 누르면 텍스트창 추가하고 커서 옮기는 기능
        if (window.event.keyCode == 13) { //13번이 엔터키/if 엔터키 눌렀을 때
        	$(createBox())
			// .appendTo("#itemBoxWrap") 
			.appendTo($(inputBox).parent().parent().parent().parent().children().last()) 
			.hover(function() {// hover -> 마우스 올렸을 때 / 첫번쨰 펑션은 마우스 올렸을 때 , 두번째 펑션은 마우스 내렸을 때
				$(this).css('backgroundColor', '#ffebeb'); // 백그라운드 색 바꾸고
				$(this).find('.deleteBox').show(); // 마우스 올리면 보이게
			}, function() { // 두번쨰 펑션
				$(this).css('background', 'none'); // 원상 복귀
				$(this).find('.deleteBox').hide(); // 삭제 버튼 숨기기
			})
			.append("<div class='deleteBox'>[삭제]</div>")
			.find(".deleteBox")
			.click(
					function() {
						var valueCheck = false;
						$(this).parent().find('input').each(
								function() {
									if ($(this).attr("name") != "type"
											&& $(this).val() != '') {
										valueCheck = true;
									}
								});

						if (valueCheck) {
							var delCheck = confirm('입력하신 내용이 있습니다.\n삭제하시겠습니까?');
						}
						if (!valueCheck || delCheck == true) {
							$(this).parent().remove();
							reorder(); // 삭제하고 나서 다시 숫자 정렬
						}
					});
			// 숫자를 다시 붙인다.
			reorder();// 옮기든 언제든 숫자 정렬
     	
			$(inputBox).parent().parent().parent().children().last().children().first().children().last().focus();
	        //alert($(inputBox).parent().parent().parent().parent().children().last().children().first().children().children('.item').attr('class'));
	        
			
         
        }
	}

    	/** 아이템 박스 작성 */ //onkeydown='enterkey(this); 엔터키는 어떻게??
    	function createBox() {
    		var contents = "<div class='itemBox'>" + "<div style='float:left;'>"
    				+ "<span class='itemNum'></span> "
    				+ "<input class='item' type='text' name='item' onkeydown='enterkey(this);' style='width:500px; border-radius: 10px; border-color:red; clear:left;'/>"
    				+ "</div>" + "</div>";
    		return contents;
    	}	
	
    	
    	
    	
    function btnFocus(btn){
    	$(btn).css('box-shadow', '0 0 0 .2rem rgba(220,53,69,.5)');
    }
    
    function btnLeave(btn){
    	$(btn).css('box-shadow','0 0 0 0');
    }
	
	//]]>
</script>
</head>

<body>
    <!-- Preloader Start -->
    <div id="preloader-active">
        <div class="preloader d-flex align-items-center justify-content-center">
            <div class="preloader-inner position-relative">
                <div class="preloader-circle"></div>
                <div class="preloader-img pere-text">
                    <img src="assets/img/logo/logo.png" alt="">
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
                        <div class="col-xl-2 col-lg-2 col-md-1">
                            <div class="logo">
                                <a href="index.html" ><img src="assets/img/logo/logo.png" alt=""></a>
                            </div>
                        </div>
                        
                        <div class="col-xl-8 col-lg-8 col-md-8">
                            <!-- Main-menu -->
                            <div class="main-menu f-right d-none d-lg-block" >
                                <nav> 
                                    <ul id="navigation">    
                                        <li><a href="index.html"><img src="assets/img/add.png"></a></li>
                                        <li><a href="about.html"><img src="assets/img/not.png"></a></li>
                                        <li><a href="services.html"><img src="assets/img/setting.png"></a></li>
                                    </ul>
                                </nav>
                            </div>
                        </div>             
                        <div class="col-xl-2 col-lg-2 col-md-3">
                            <div class="header-right-btn f-right d-none d-lg-block">
                                <a href="#" class="btn header-btn" style="background-color:#fd001b">로그아웃</a>
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
    <div class="services-area">  
    </div>
    <!-- Slider Area End-->

    <!--================Blog Area =================-->
    <section class="blog_area section-paddingr">
        <div class="container">
            <div class="row">
                <!--================ 왼쪽 메뉴 =================-->
                <div class="col-lg-2">
                    <div class="blog_right_sidebar">
                        <aside class="single_sidebar_widget post_category_widget">
                            <h4 class="widget_title">메뉴</h4>
                            <ul class="list cat-list">
                                <li>
                                    <a href="#" class="d-flex">
                                        <p >프로젝트</p>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="d-flex">
                                        <p>템플릿</p>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="d-flex">
                                        <p>팀</p>
                                    </a>
                                </li>
                            </ul>
                        </aside>                    
                    </div>
                </div>
                
                <!--================ 오른쪽 내용 =================-->
                <div class="col-lg-10 mb-6 mb-lg-0" style="border: 3px solid #d0d0d0; padding:3%; background-color:#fbf9ff">
                	<div style="border: 4px solid #d0d0d0; padding:3%; background-color:#fbf9ff">
	                    <div class="blog_left_sidebar">
							<div>
								<div class= 'add_and_submmit' style='clear: both; margin-bottom:15px;'>
									<input id = 'addItem' type='button' value= '추가하기' onclick='createItem(this);' onmouseover="btnFocus(this);" onmouseleave="btnLeave(this);" class='btn-danger' 
		                            style='width:15%; height: 40px; border-radius: 10px; background-color: #fd001b; border-color: #fd001b; color : white;'>
		                            <input id = 'submitItem' type='button' value= '저장하기' onclick='submitItem(this);' onmouseover="btnFocus(this);" onmouseleave="btnLeave(this);" class='btn-danger' 
		                            style='width:15%; height: 40px; border-radius: 10px; background-color: #fd001b; border-color: #fd001b; color : white;'>
		                            <input id = 'editItem' type='button' value= '편집하기' onclick='editItem(this);' onmouseover="btnFocus(this);" onmouseleave="btnLeave(this);" class='btn-danger' 
		                            style='width:15%; height: 40px; border-radius: 10px; background-color: #fd001b; border-color: #fd001b; color : white; display: none;'>	
															
								</div>
								<div id='itemBoxWrap' class='ui-sortable'></div>
							</div>
							
						</div>		
					</div>
                </div>
                
            </div>
        </div>
    </section>
    <!--================Blog Area =================-->











<!-- 밑에는 신경안써도도미~~~~~ -->
    <footer>

        <!-- Footer Start-->
       <div class="footer-main" data-background="assets/img/shape/footer_bg.png">
         <div class="footer-area footer-padding">
             <div class="container">
                 <div class="row d-flex justify-content-between">
                     <div class="col-lg-3 col-md-4 col-sm-8">
                        <div class="single-footer-caption mb-50">
                          <div class="single-footer-caption mb-30">
                               <!-- logo -->
                              <div class="footer-logo">
                                  <a href="index.html"><img src="assets/img/logo/logo2_footer.png" alt=""></a>
                              </div>
                              <div class="footer-tittle">
                                  <div class="footer-pera">
                                      <p class="info1">221B Baker Street, P.O Box 353 Park <br> Road, USA - 215431</p>
                                      <p class="info2">info@yourdomain.com</p>
                                 </div>
                              </div>
                              <div class="footer-social">
                                 <a href="#"><i class="fab fa-facebook-f"></i></a>
                                 <a href="#"><i class="fab fa-twitter"></i></a>
                                 <a href="#"><i class="fas fa-globe"></i></a>
                                 <a href="#"><i class="fab fa-behance"></i></a>
                             </div>
                          </div>
                        </div>
                     </div>
                     <div class="col-lg-2 col-md-4 col-sm-5">
                         <div class="single-footer-caption mb-50">
                             <div class="footer-tittle">
                                 <h4>Quick Links</h4>
                                 <ul>
                                     <li><a href="about.html">About</a></li>
                                     <li><a href="about.html">Features</a></li>
                                     <li><a href="single-blog.html">Pricing</a></li>
                                     <li><a href="blog.html">Blog</a></li>
                                     <li><a href="contact.html">Contact</a></li>
                                 </ul>
                             </div>
                         </div>
                     </div>
                     <div class="col-lg-2 col-md-4 col-sm-7">
                         <div class="single-footer-caption mb-50">
                             <div class="footer-tittle">
                                 <h4>Support</h4>
                                 <ul>
                                     <li><a href="#">Privacy Policy</a></li>
                                     <li><a href="#">Terms & Conditions</a></li>
                                     <li><a href="#"> Sitemap</a></li>
                                     <li><a href="#">FAQs</a></li>
                                     <li><a href="#">Report a bugb</a></li>
                                 </ul>
                             </div>
                         </div>
                     </div>
                     <div class="col-lg-3 col-md-4 col-sm-5">
                         <div class="single-footer-caption mb-50">
                             <div class="footer-tittle">
                                 <h4>Core Features</h4>
                                 <ul>
                                  <li><a href="#">Email Marketing</a></li>
                                  <li><a href="#"> Offline SEO</a></li>
                                  <li><a href="#">Social Media Marketing</a></li>
                                  <li><a href="#">Lead Generation</a></li>
                                  <li><a href="#"> 24/7 Support</a></li>
                              </ul>
                             </div>
                         </div>
                     </div>
                 </div>
             </div>
         </div>
         <!-- footer-bottom aera -->
         <div class="footer-bottom-area footer-bg">
             <div class="container">
                 <div class="footer-border">
                      <div class="row d-flex align-items-center">
                          <div class="col-xl-12 ">
                              <div class="footer-copy-right text-center">
                                  <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="ti-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                              </div>
                          </div>
                      </div>
                 </div>
             </div>
         </div>
       </div>
        <!-- Footer End-->
 
    </footer>

<!-- JS here -->
	
		<!-- All JS Custom Plugins Link Here here -->
        <script src="./assets/js/vendor/modernizr-3.5.0.min.js"></script>
		
		<!-- Jquery, Popper, Bootstrap -->
<!-- 		<script src="./assets/js/vendor/jquery-1.12.4.min.js"></script> -->
        <script src="./assets/js/popper.min.js"></script>
        <script src="./assets/js/bootstrap.min.js"></script>
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