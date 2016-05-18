<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>用户登录</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Fashion Mania Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- start menu -->
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>
<script src="js/simpleCart.min.js"> </script>
<script src="js/shopMenu.js" type="text/javascript"></script>
<!-- slide -->
<script type="text/javascript">
	function userRegister(){
		var userphone = $('#userphone').val();
		var userpassword = $('#userpassword').val();
		var username = $('#username').val();
		if(userphone==null || userphone == ''){
			$('#up_info').append("请输入手机号");
			return false;
		}
		if(username==null || username == ''){
			$('#name_info').append("请输入用户名");
			return false;
		}
		if(userpassword==null || userpassword == ''){
			$('#psd_info').append("请输入密码");
			return false;
		}
		 $.ajax({
	        cache: true,
	        type: 'POST', 
	        url:'${pageContext.request.contextPath }/user/userRegister.action',
	        data: "userphone="+userphone+"&userpassword="+userpassword+"&username="+username,
	        async: false,
	        success: function(data) {
		        if(data ==false){
		        	alert("注册失败!");
		        }else{
		        	alert("注册成功!");
		        	document.forms[0].action = "jsp/user/userLogin.jsp";
		        	document.forms[0].submit();
		        }
	      	}
    	}); 
	}
</script>
</head>
<body>
<!--header-->
<div class="header">
	<div class="header-top">
		<div class="container">
		<div class="col-md-4 world">
					<ul >
						<li>
						</li>
						<li>
						</li>
					</ul>
				</div>
				<div class="col-md-4 logo">
					<a href="jsp/index.jsp"><img src="images/logo.png" alt="snackShop"></a>	
				</div>
		
			<div class="col-md-4 header-left">		
					<p class="log"><a href="jsp/user/userLogin.jsp"  >登录</a>
						<span>or</span><a  href="jsp/user/userRegister.jsp">注册</a></p>
					<div class="cart box_1">
						<a href="user/findOrderInfo.action">
						<h3><img src="images/cart.png" alt=""/></h3>
						</a>
						<p><a href="user/findOrderInfo.action" class="simpleCart_empty">购物车</a></p>

					</div>
					<div class="clearfix"> </div>
			</div>
				<div class="clearfix"> </div>
		</div>
		</div>
		<div class="container">
			<div class="head-top">
				<div class="col-sm-2 number">
				</div>
		 <div class="col-sm-8 h_menu4">
				<ul class="memenu skyblue">
					  <li class=" grid"><a  href="jsp/index.jsp">主页</a></li>	
				      <li onmouseover="loadHotType()"><a  href="javascript:void(0)">热销零食</a>
				      	<div class="mepanel">
						<div class="row" id="hotSnack">
							<div class="col1">
								<div class="h_nav">
									<ul id="hot1">
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<ul id="hot2">
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<ul id="hot3">
									</ul>	
								</div>												
							</div>
						  </div>
						</div>
					</li>
				    <li class="grid" onmouseover="loadDisType()"><a  href="javascript:void(0)">打折零食</a>
					  	<div class="mepanel" id="disSnack">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<ul id="dis1">
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<ul id="dis2">
									</ul>
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<ul id="dis3">
									</ul>	
								</div>												
							</div>
						  </div>
						</div>
			    </li>
				<li><a class="color6" href="user/userHomePage.action">个人中心</a></li>
			  </ul> 
			</div>
				<div class="col-sm-2 search">		
			<a class="play-icon popup-with-zoom-anim" href="#small-dialog"><i class="glyphicon glyphicon-search"> </i> </a>
		</div>
		<div class="clearfix"> </div>
				<!---pop-up-box---->
				<link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
				<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
					<!---//pop-up-box---->
				<div id="small-dialog" class="mfp-hide">
				<div class="search-top">
						<div class="login">
							<input type="submit" value="">
							<input type="text" value="Type something..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}">		
						</div>
						<p>	Shopping</p>
					</div>				
				</div>
				 <script>
						$(document).ready(function() {
						$('.popup-with-zoom-anim').magnificPopup({
							type: 'inline',
							fixedContentPos: false,
							fixedBgPos: true,
							overflowY: 'auto',
							closeBtnInside: true,
							preloader: false,
							midClick: true,
							removalDelay: 300,
							mainClass: 'my-mfp-zoom-in'
						});
																						
						});
				</script>			
		</div>
	</div>
</div>
<!--//header-->
<div class="account">
	<div class="container">
		<h1>Register</h1>
		<div class="account_grid">
		   <div class="col-md-6 login-right">
			<form method="post">
				<span>手机号</span>
				<input type="text" name="user.userphone" id="userphone"> 
				<p class="text-warning" id="up_info"></p>
				<span>用户名</span>
				<input type="text" name="user.username" id="username"> 
				<p class="text-warning" id="name_info"></p>
				<span>密码</span>
				<input type="password" name="user.userpassword" id="userpassword" style="width:515px;height:40px;"> 
				<p class="text-warning" id="psd_info"></p>
				<div class="word-in">
					 <a class="forgot" href="jsp/user/userLogin.jsp">已有账号?</a>
			 		 <input type="submit" value="注册" onclick="userRegister()">
			  	</div>
		    </form>
		   </div>	
	 </div>
	</div>
</div>
</body>
</html>