<%@page import="hpu.zyf.entity.User"%>
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
  <script type="text/javascript">
   var loadHotData = false;
   var loadDisData = false;
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
  $(function(){
	var t = $("#text_box");
	var evePrice = $("#evePrice").val(); 
	var totalPrice =$("#totalPrice");
	setTotal($("#evePrice").val() * t.val());
    $("#add").click(function(){       
        t.val(parseInt(t.val())+1);
        if(t.val()>=10){
        	 $('#add').attr('disabled',true);
        }
        if(t.val()>1){
        	 $('#min').attr('disabled',false);
        }
        var total = parseFloat(evePrice * t.val());
        setTotal(total);
    });
    $("#min").click(function(){
        t.val(parseInt(t.val())-1);
        if(t.val()<1){
       	  $('#min').attr('disabled',true);
        }
        if(t.val()<10){
        	$('#add').attr('disabled',false);
        }
        var total = parseFloat(evePrice * t.val());
        setTotal(total);
    });
    //设置总共的价格
    function setTotal(total){
    	totalPrice.val(total);
    }
  });
  //点击加入购物车按钮
  function addShopCart(pdid){
	  var totalPrice = $("#totalPrice").val();
	  var textBox = $("#text_box").val();
	  //将用户的id和购买商品的具体明细和商品id传入的后台
	  $.ajax({
		  cache: true,
		  type: 'POST',
		  url:'${pageContext.request.contextPath }/shop/AddShopCartByProId.action',
		  data:"pdid="+pdid+"&odprice="+totalPrice+"&odnumber="+textBox,
		  async:false,
		  success:function(data){
			 if(data){
				 alert("添加成功！");
			 }else{
				 alert("添加失败！");
				 if($("#isUserId").val()==null || $("#isUserId").val()==''){
					 document.forms[0].action = "jsp/user/userLogin.jsp";
			         document.forms[0].submit();
				 }
			 }
		  }
	  });
  }
//点击购买商品，也同样是添加到购物车中
  function addShopCart1(pdid){
	  var totalPrice = $("#totalPrice").val();
	  var textBox = $("#text_box").val();
	  //将用户的id和购买商品的具体明细和商品id传入的后台
	  $.ajax({
		  cache: true,
		  type: 'POST',
		  url:'${pageContext.request.contextPath }/shop/AddShopCartByProId.action',
		  data:"pdid="+pdid+"&odprice="+totalPrice+"&odnumber="+textBox,
		  async:false,
		  success:function(data){
			 if(data){
				 alert("已经添加到购物车，请前往购物车付款！");
			 }else{
				 alert("购买失败！");
				 if($("#isUserId").val()==null || $("#isUserId").val()==''){
					 document.forms[0].action = "jsp/user/userLogin.jsp";
			         document.forms[0].submit();
				 }
			 }
		  }
	  });
	}
  //加载评论
  function startUp(pdid){
	   $.ajax({
		  cache: true,
		  type: 'POST',
		  url:'${pageContext.request.contextPath }/product/selectCommentBypdid.action',
		  data:"pdid="+pdid,
		  async:false,
		  success:function(data){
			  $.each(data,function(index,obj){
				 var content = "<div class='single-para simpleCart_shelfItem'><label class='add-to item_price'><h5>用户:"+obj.username+"</h5></label></div>"+
				 "<div class='single-para simpleCart_shelfItem'><h6 class='best2'></h6><span class='price-in1'>"+obj.content+"</span></div>";
					$("#contentDiv").append(content);
				 });
		  }
	  }); 
  }
  </script>
</head>
<body onload="startUp('${productdetail.pdid}')">
<!--header-->
<div class="header">
	<div class="header-top">
		<div class="container">
		<div class="col-sm-4 world"></div>
				<div class="col-sm-4 logo">
					<a href="jsp/index.jsp"><img src="images/logo.png" alt=""></a>	
				</div>
			<div class="col-sm-4 header-left">	
				<input type="hidden" name="isUserId" id="isUserId" value="${userId}"/>	
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
				<div class="single">
				<form method="post">
					<div class="container">
					<div class="col-md-9">
						<div class="col-md-5 grid">		
							<div class="flexslider">
								  <ul class="slides">
								    <li data-thumb="images/si.jpg">
								        <div class="thumb-image"> <img src="/pic/${productdetail.pdimage}" data-imagezoom="true" class="img-responsive"> </div>
								    </li>
								  </ul>
							</div>
						</div>	
					<div class="col-md-7 single-top-in">
						<div class="single-para simpleCart_shelfItem">
							<h1>详细描述</h1>
							<c:if test="${productdetail.pddetail !=null }">
								<p>${productdetail.pddetail}</p>
							</c:if>
							<p></p>
							<div class="star-on">
							<div class="clearfix"> </div>
							</div>
							<label  class="add-to item_price">${productdetail.disprice}元/斤</label>
							<div class="available">
								<h6>购买选项:</h6>
								<ul>
									
								<li>数量:
									<input id="min" name="" type="button" value="-" />

									<input id="text_box" name="goodnum" type="text" value="1" style="width:50px;" disabled="disabled"/>
									
									<input id="add" name="" type="button" value="+" />
								</li>
								<li>价格:
									 <input id="totalPrice" name="totalPrice" type="button" value="" disabled="disabled" style="width:100px"/>
									 <input id="evePrice" name="evePrice" type="hidden" value="${productdetail.disprice}" />
								</li>
							</ul>
						</div>
								<a href='javascript:void(0)' class="cart item_add" onclick='addShopCart1("${productdetail.pdid}")'>点击购买</a>
								<a href='javascript:void(0)' onclick='addShopCart("${productdetail.pdid}")' class="cart item_add">加入购物车</a>
						</div>
					</div>
					<div class="clearfix"> </div>
				</div>
<!----->
<div class="col-md-3 product-bottom">
			<!--categories-->
				<div class=" rsidebar span_1_of_left"></div>
			<!--seller-->
				<div class="product-bottom" >
						<h3 class="cate">相关评论</h3>
						 <div class="product-go" id="contentDiv">
						 </div>
				</div>
		</div>
		<div class="clearfix"> </div>
	</div>
	 </form>
	</div>
<!-- slide -->
<script src="js/jquery.min.js"></script>
<script src="js/imagezoom.js"></script>
<!-- start menu -->
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>
<script src="js/simpleCart.min.js"> </script>
<!--initiate accordion-->
						<script type="text/javascript">
							$(function() {
							    var menu_ul = $('.menu-drop > li > ul'),
							           menu_a  = $('.menu-drop > li > a');
							    menu_ul.hide();
							    menu_a.click(function(e) {
							        e.preventDefault();
							        if(!$(this).hasClass('active')) {
							            menu_a.removeClass('active');
							            menu_ul.filter(':visible').slideUp('normal');
							            $(this).addClass('active').next().stop(true,true).slideDown('normal');
							        } else {
							            $(this).removeClass('active');
							            $(this).next().stop(true,true).slideUp('normal');
							        }
							    });
							
							});
						</script>
						<!-- FlexSlider -->
  <script defer src="js/jquery.flexslider.js"></script>
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />

<script>
// Can also be used with $(document).ready()
$(window).load(function() {
  $('.flexslider').flexslider({
    animation: "slide",
    controlNav: "thumbnails"
  });
});
</script>
<!---pop-up-box---->
					<link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
					<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
					<!---//pop-up-box---->
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
</body>
</html>