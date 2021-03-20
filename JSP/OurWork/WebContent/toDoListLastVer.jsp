<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.io.PrintWriter" %> <!-- 자바 클래스 사용 -->

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>SEO HTML-5 Template </title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/icon.png">
    
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
    <!-- CSS here -->
  
    <link rel = "stylesheet" href = "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    
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

 

<style>
	body{
			background-image : url('assets/img/background.jpg');

			background-repeat : no-repeat;

			background-attachment: fixed;
			background-size : cover;"
			width : 300px;
			height : 1000px;
	}


/*기존 코드  */
.itemBox, .itemBoxHighlight {
	border: solid 2px #ff858f;
	border-radius: 10px;
	width: 400px;
	height: 60px;
	padding: 10px;
	margin-bottom: 10px;
}

.itemBoxHighlight {
	background-color: #ffc4c9;
}

.deleteBox {
	float: right;
	display: none;
	cursor: pointer;
}

.add_and_submmit {
	clear: both;
	margin-bottom: 15px;
}

.addItem, .submitItem, .editItem, .removeList {
	width: 100px;
	height: 40px;
	border-radius: 10px;
	background-color: #fd001b;
	border-color: #fd001b;
	color: white
}

.editItem {
	display: none;
}

#addList {
	width: 140px;
	height: 40px;
	margin-bottom: 20px;
	border-radius: 10px;
	background-color: #fd001b;
	border-color: #fd001b;
	color: white;
}

#rightDiv {
	display: inline-block;
	border: 3px solid #d0d0d0;
	padding: 3%;
	background-color: rgba(255 , 255, 255, 0.8);
 	border-radius: 30px;
	margin-left: 50px;
	
}

.addItem:hover, .submitItem:hover, .editItem:hover, #addList:hover {
	box-shadow: 0 0 0 .2rem rgba(220, 53, 69, .5);
}


tr,td{
	vertical-align: top;
	padding-right: 10px; /*마진은 요소들을 떨어뜨려 놓는건데 테이블은 td는 애초에 하나로 붙어있기 때문에 마진 안먹힘 -> 패딩은 요소 자체에 안쪽으로 여백을 주는 것 */
}
</style>

<script type="text/javascript">
	//<![CDATA[
	/** 아이템을 등록한다. */
	function submitItem(submit) {
		if (!validateItem()) {
			return;
		}
		alert("등록");
		// 저장 버튼 눌렀을때 읽기모드로  텍스트  고정 해주기
		
		$('.item').attr('readonly', 'readonly');
 		$('.editItem').css('display', 'inline-block'); // 편집 버튼 나오게 표시
		$(submit).css('display', 'none'); // 저장 버튼 숨기기
		
		//alert($(submit).parent().parent().children('.ui-sortable').attr('class')); // 버튼의 부모 자식 찾기 용
	}
	
	function editItem(edit) {
		alert("편집 모드");
		
		//편집 버튼 누르면 쓰기 모드로 전환
		$('.item').removeAttr('readonly');
 		$('.submitItem').css('display', 'inline-block'); // 저장 버튼 나오게 표시
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
		$(".itemBoxWrap").sortable({
			placeholder : "itemBoxHighlight",
			start : function(event, ui) {
				ui.item.data('start_pos', ui.item.index());
				
				$('.item').removeAttr('readonly');
				$('.submitItem').css('display', 'inline-block'); // 저장 버튼 나오게 표시
				$('.editItem').css('display', 'none'); // 편집 버튼은 숨기기
				
				//alert($('#itemBoxWrap').parent().children('.add_and_submmit').attr('class'));
			},
			stop : function(event, ui) {
				var spos = ui.item.data('start_pos');
				var epos = ui.item.index();
				reorder();
			}
		});
		
		
		$(".itemBoxWrap").disableSelection();
		$(".sortable").sortable();
		$(".sortable").disableSelection();
	});

	/** 아이템 순서 조정 */
	function reorder() {
		
/* 		$(".itemBox").each(function(i, box) {
			$(box).find(".itemNum").html("<div style='width:15px; float:left;'>"+(i+1)+"</div>"); // div는 블록태그라 무조건 한줄에 하나 -> float해서 div 사이드에 붙이기 가능
		}); */
			
		var resultStr = ""; 
		
		$(".itemBoxWrap").each(function(i, boxWrap) { //itemBoxWrap 마다 그 안의 아이템 박스를 돌아 즉 이중 for문
			$(boxWrap).children('.itemBox').each(function(n, box) {
				
				resultStr = 
					"<div style='width:15px; float:left;'>" 
					+	"<div class='projectNum' style='display : none'>"
					+ 		(i+1) 
					+ 	"</div>"
					+	"<div class='listNum'>"
					+ 		(n+1) 
					+ 	"</div>"
					+"</div>";
				
				$(box).find(".itemNum").html(resultStr);
			});
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
								$('.item').removeAttr('readonly');
								$('.submitItem').css('display', 'inline-block'); // 저장 버튼 나오게 표시
								$('.editItem').css('display', 'none'); // 편집 버튼은 숨기기
								reorder(); // 삭제하고 나서 다시 숫자 정렬
							}
						});
		// 숫자를 다시 붙인다.
		reorder();// 옮기든 언제든 숫자 정렬
		
		// 추가 버튼을 눌러주면 다시 편집 모드에서 저장 모드로 변경
		$('.item').removeAttr('readonly');
		$('.submitItem').css('display', 'inline-block'); // 저장 버튼 나오게 표시
		$('.editItem').css('display', 'none'); // 편집 버튼은 숨기기
	}

	function createList(){
     
		
        var $newCard =
        "<td>" +
	       	"<div style='width: 400px; margin-bottom: 60px;'>" +
				"<div class= 'add_and_submmit'>" +
					"<input class = 'addItem btn-danger' type='button' value= '추가하기' onclick='createItem(this);' > " +
					"<input class='removeList btn-danger' type='button' value= '리스트 삭제' onclick='deleteList(this);' >" +
	           	"</div>" + 
	           	"<div class='itemBoxWrap ui-sortable'></div>" + 
	        "</div>" +
	     "</td>";
       	 
        	$('#blog_left_sidebar').children().last().children().last().children().last().append($newCard);
   		$(".itemBoxWrap").sortable({
   			placeholder : "itemBoxHighlight",
   			start : function(event, ui) {
   				ui.item.data('start_pos', ui.item.index());
   				
   				
   				$('.item').removeAttr('readonly');
   				$('.submitItem').css('display', 'inline-block'); // 저장 버튼 나오게 표시
   				$('.editItem').css('display', 'none'); // 편집 버튼은 숨기기 
   				
   				//alert($('#itemBoxWrap').parent().children('.add_and_submmit').attr('class'));
   			},
   			stop : function(event, ui) {
   				var spos = ui.item.data('start_pos');
   				var epos = ui.item.index();
   				reorder();
   			}
   		});
   		
   		
   		$(".itemBoxWrap").disableSelection();
   		$(".sortable").sortable();
   		$(".sortable").disableSelection();
   		
   		
    }
	
	
	function deleteList(removeList) {
		$(removeList).parent().parent().parent().remove();
		reorder();
		$('.item').removeAttr('readonly');
		$('.submitItem').css('display', 'inline-block'); // 저장 버튼 나오게 표시
		$('.editItem').css('display', 'none'); // 편집 버튼은 숨기기
	}
	
	
	// 엔터키 엑션 구현 하다가 실패
	function enterkey(inputBox) {//엔터키 누르면 텍스트창 추가하고 커서 옮기는 기능
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
			
			$('.item').removeAttr('readonly');
			$('.submitItem').css('display', 'inline-block'); // 저장 버튼 나오게 표시
			$('.editItem').css('display', 'none'); // 편집 버튼은 숨기기

        }
	}

    	/** 아이템 박스 작성 */ //onkeydown='enterkey(this); 엔터키는 어떻게??
   	function createBox() {
   		var contents =
   			"<div class='itemBox'>" 
   				+ "<div style='float:left;'>"
   					+ "<span class='itemNum'></span> "
   					+ "<input class='item' type='text' name='item' onkeydown='enterkey(this);' style='width:300px; border-radius: 10px; border-color:red; clear:left;'/>"
   				+ "</div>"
   		  + "</div>";
   		return contents;
   	}	
	
	//]]>
</script>
</head>

<body>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("proj_name");
%>

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
                                <a href="afterLogProj.jsp" ><img src="assets/img/logo/logo.png" alt=""></a>
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
                                <a href="logoutAction.jsp" class="btn header-btn" style="background-color:#fd001b">로그아웃</a>
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
<!--     <section class="blog_area section-paddingr">
        <div class="">
            <div class="row">
                ================ Leftside Menu =================
                <div class="col-lg-2">
                    <div class="blog_right_sidebar">
                        <aside class="single_sidebar_widget post_category_widget">
                            <h4 class="widget_title">메뉴</h4>
                            <div> 
                            	<a href="#" class="d-flex">프로젝트</a>
                            	<a href="#" class="d-flex">템플릿</a>
                            	<a href="#" class="d-flex">팀</a>
							</div>
                        </aside>                    
                    </div>
                </div> -->
                
                <!--================ Rightside Main =================-->
                <div id='rightDiv'>
                	<div id='rightDivChild'>
	                    <div id="blog_left_sidebar" class="blog_left_sidebar">
	                    	<div>
	                    		<input id = 'addList' class='btn-danger' type='button' value= '리스트 추가하기' onclick='createList();' >
	                   			<input class = 'submitItem btn-danger' type='button' value= '저장하기' onclick='submitItem(this);'>
		                        <input class = 'editItem btn-danger' type='button' value= '편집하기' onclick='editItem(this);'>	
	                    	</div>
	                    	<table>
	                    	<tr>
	                    	<td>
	                    		<div style='width: 400px; margin-bottom: 60px;'>
								<div class= 'add_and_submmit'>
									<input class = 'addItem btn-danger' type='button' value= '추가하기' onclick='createItem(this);'>
									<input class='removeList btn-danger' type='button' value= '리스트 삭제' onclick='deleteList(this);' >														
								</div>
								<div class='itemBoxWrap ui-sortable'></div>
								</div>
							</td>
							</tr>
	                    	</table>
						</div>		
					</div>
                </div>
                
            </div>
        </div>
    </section>

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
                                  <a href="afterLogProj.jsp"><img src="assets/img/logo/logo2_footer.png" alt=""></a>
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

</body>


    <!-- JS here -->
	
	<!-- All JS Custom Plugins Link Here here -->
    <script src="./assets/js/vendor/modernizr-3.5.0.min.js"></script>

	<!-- Jquery, Popper, Bootstrap -->
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
    
    
</html>