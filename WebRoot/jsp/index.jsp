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
<title>零食商城主界面</title>
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
<!-- slide -->
<script src="js/responsiveslides.min.js"></script>
   <script>
    $(function () {
      $("#slider").responsiveSlides({
      	auto: true,
      	speed: 500,
        namespace: "callbacks",
        pager: true,
      });
    });
  </script>
<script type="text/javascript">
  var loadHotData = false;
  var loadDisData = false;
  function startUp(){
	  $.ajax({
		  cache: true,
		  type: 'POST',
		  url:'${pageContext.request.contextPath }/product/selectAllByPage.action',
		  data: "pageNo=1",
		  async:false,
		  success:function(data){
			 $.each(data,function(index,obj){
				var hiddenInput ="<input type='hidden' name='pdid' id='"+obj.pdid+"' value='"+obj.pdid+"'/>";
				var pdid = obj.pdid;
				var price = null;
				if(obj.pdprice!=null){
					price = obj.pdprice;
				}else if(obj.disprice!=null){
					price = obj.disprice;
				}
				//加入购物车的id
				var addItem = "<a href='javascript:void(0)' onclick='addShopCart(\""+obj.pdid+"\",\""+obj.disprice+"\")' class='item_add' id='addShop'>加入购物车</a>";
				var selectInfoUrl = "<a href='${pageContext.request.contextPath }/product/selectByPdid.action?id="+obj.pdid+"'>"+obj.pdname+"</a>";
				var imageUrl = "<a href='${pageContext.request.contextPath }/product/selectByPdid.action?id="+obj.pdid+"'>"+
						"<img class='img-responsive' src='/pic/"+obj.pdimage+"' alt='' style='height:180px'/></a>";
				var content = "<div class='col-md-3 col-md2'>"+
				"<div class='col-md1 simpleCart_shelfItem'>"+
				imageUrl+
				"<h3>"+selectInfoUrl+"</h3>"+hiddenInput+
				"<div class='price'>"+
				"<h5 class='item_price'>"+"$"+price+"</h5>"+addItem+
				"<div class='clearfix'></div></div></div></div>";
				$("#contentDiv").append(content);
			 });
		  }
	  });
  }
  function addShopCart(pdid,odprice){
	  $.ajax({
		  cache: true,
		  type: 'POST',
		  url:'${pageContext.request.contextPath }/shop/AddShopCartByProId.action',
		  data:"pdid="+pdid+"&odprice="+odprice+"&odnumber=1",
		  async:false,
		  success:function(data){
			 if(data){
				 alert("添加成功！");
			 }else{
				 document.forms[0].action = "jsp/user/userLogin.jsp";
		         document.forms[0].submit(); 
				// window.location.href="jsp/user/userLogin.jsp";
			 }
		  }
	  });
  }
  function loadDisType(){
	  if(!loadDisData){
		  $.ajax({
			  cache: true,
			  type: 'POST',
			  url:'${pageContext.request.contextPath }/product/selectAllType.action',
			  async:false,
			  success:function(data){
				  $.each(data,function(index,obj){
					  var selectUrl = "<a href='${pageContext.request.contextPath }/product/selectByDisType.action?pageNo="+1+"&pdtype="+obj.pttype+"'>"+obj.pttype+"</a>";
					  var types1 = "<li>"+selectUrl+"</li>";
					  if(index < 5){ //只有5个菜单，就显示在第一个界面上
						  $("#dis1").append(types1);
					  }else if(index>6 && index<10){
						  $("#dis2").append(types1);
					  }else{
						  $("#dis3").append(types1);
					  }
					 });
			  }
		  });
		  //已经加载过数据 	
		  loadDisData = true;
	  }
  }
  function loadHotType(){
	  if(!loadHotData){
		  $.ajax({
			  cache: true,
			  type: 'POST',
			  url:'${pageContext.request.contextPath }/product/selectAllType.action',
			  async:false,
			  success:function(data){
				  $.each(data,function(index,obj){
					  var selectUrl = "<a href='${pageContext.request.contextPath }/product/selectByHotType.action?pageNo="+1+"&pdtype="+obj.pttype+"'>"+obj.pttype+"</a>";
					  var types1 = "<li>"+selectUrl+"</li>";
					  if(index < 5){ //只有5个菜单，就显示在第一个界面上
						  $("#hot1").append(types1);
					  }else if(index>6 && index<10){
						  $("#hot2").append(types1);
					  }else{
						  $("#hot3").append(types1);
					  }
					 });
			  }
		  });
		  //已经加载过数据 	
		  loadHotData = true;
	  }
  }
</script>
</head>
<body onload="startUp()">
<!--header-->
<div class="header">
	<div class="header-top">
		<div class="container">
		<div class="col-sm-4 world"></div>
				<div class="col-sm-4 logo">
					<a href="jsp/index.jsp"><img src="images/logo.png" alt=""></a>	
				</div>
			<div class="col-sm-4 header-left">	
					<c:choose>
						<c:when test="${userId == null}">
							<p class="log" ><a href="jsp/user/userLogin.jsp"  >登录</a>
							<span>or</span><a  href="jsp/user/userRegister.jsp">注册</a></p>
						</c:when>
						<c:otherwise>
						当前用户:<a href="javascript:void(0)" id="userView">${userName }</a>&nbsp;&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath }/user/userLogout.action">退出</a>
						</c:otherwise>
					</c:choose>
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
<!--banner-->
<div class="banner">
	<div class="col-sm-3 banner-mat">
		<img class="img-responsive"	src="images/ba1.jpg" alt="">
	</div>
	<div class="col-sm-6 matter-banner">
	 	<div class="slider">
	    	<div class="callbacks_container">
	      		<ul class="rslides" id="slider">
	        		<li>
	          			<img src="images/1.png" alt="">
	       			 </li>
			 		 <li>
	          			<img src="images/2.png" alt="">   
	       			 </li>
					 <li>
	          			<img src="images/3.jpg" alt="">
	        		</li>	
	      		</ul>
	 	 	</div>
		</div>
	</div>
	<div class="col-sm-3 banner-mat">
		<img class="img-responsive" src="images/ba.jpg" alt="">
	</div>
	<div class="clearfix"> </div>
</div>
<!--//banner-->
<!--content-->
<div class="content">
	<form method="post">
		<div class="container">
			<div class="content-top">
				<h1>热卖零食</h1>
				<div class="content-top1" id="contentDiv">
				</div>	
			</div>
		</div>
	</form>
</div>
</body>
</html>