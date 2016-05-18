<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en" style="overflow: hidden;">
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="description">
<meta content="Mosaddek" name="author">
<meta content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina" name="keyword">
<link href="img/favicon.html" rel="shortcut icon">
<title>左边导航</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/bootstrap-reset.css" type="text/css">
<link rel="stylesheet" href="assets/font-awesome/css/font-awesome.css" type="text/css">
<link href="assets/gritter/css/jquery.gritter.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" href="css/style2.css" type="text/css">
<link rel="stylesheet" href="css/style-responsive.css" type="text/css">
<script type="text/javascript">
	function submitComment(){
		var content = $("#myContent").val();
		var pdid = $("#pdid").val();
		if(content==null|| content==''){
			$("#comment_info").append("评论内容不能为空");
			return false;
		}
		$.ajax({
			 cache: true,
			  type: 'POST',
			  url:'${pageContext.request.contextPath }/product/addComment.action',
			  data:"content="+content+"&pdid="+pdid,
			  async:false,
			  success:function(data){
				 if(data){
					 alert("提交成功！");
				 }else{
					 alert("提交失败！");
				 }
			  }
		});
	}
</script>
</head>
<body>
  <section id="container" class="">
      <!--header start-->
      <header class="header white-bg">
        <div class="sidebar-toggle-box">
          <div data-original-title="Toggle Navigation" data-placement="right" class="icon-reorder tooltips"></div>
      </div>
        <div class="nav notify-row" id="top_menu">
           		<div class="col-sm-4 logo">
					<a href="jsp/index.jsp"><img src="images/logo2.png" alt=""></a>	
				</div>
        </div>
      </header>
      <!--header end-->
      <!--sidebar start-->
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu">
                  <li class="sub-menu">
                      <a href="javascript:;" class="">
                          <i class="icon-book"></i>
                          <span>用户管理</span>
                          <span class="arrow"></span>
                      </a>
                      <ul class="sub">
                          <li class="active"><a class="" href="user/findUserInfo.action">查看用户</a></li>
                          <li><a class="" href="jsp/user/updatePassword.jsp">修改密码</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" class="">
                          <i class="icon-cogs"></i>
                          <span>订单管理</span>
                          <span class="arrow"></span>
                      </a>
                      <ul class="sub">
                          <li><a class="" href="user/findOrderInfo.action">购物车</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" class="">
                          <i class="icon-tasks"></i>
                          <span>评论管理</span>
                          <span class="arrow"></span>
                      </a>
                      <ul class="sub">
                          <li><a class="" href="product/findCommentInfo.action">商品评论</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="jsp/index.jsp" class="">
                          <i class="icon-glass"></i>
                          <span>回到主页</span>
                          <span class="arrow"></span>
                      </a>
                  </li>
              </ul>
              <!-- sidebar menu end-->
          </div>
      </aside>
      <!--sidebar end-->
      <!-- form -->
       <section id="main-content">
          <section class="wrapper">
       		<div class="row">
                 <section class="panel">
                          <div class="col-lg-12">
		                      <section class="panel">
		                          <header class="panel-heading">
		                              	<b>用户评论</b>
		                          </header>
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
											<div class="star-on">
											<div class="clearfix"> </div>
											</div>
											<c:if test="${productdetail.disprice !=null }">
												<p>${productdetail.disprice}元/斤</p>
											</c:if>
											<c:if test="${productdetail.pdprice !=null }">
												<p>${productdetail.pdprice}元/斤</p>
											</c:if>
										</div>
									</div>
									<input type="hidden" name="pdid" value="${productdetail.pdid }" id="pdid" >
									<div class="clearfix"> </div>
								</div>
		                         <form method="post">
									<textarea id="myContent" class="form-control input-lg p-text-area" rows="7" placeholder="写下您的评价..."></textarea>
									<footer class="panel-footer">
									<span id="comment_info" class="text-warning"> </span>
		                              <button class="btn btn-danger pull-right" onclick="submitComment(this)">提交 </button>
		                          </footer>
								</form>
		                      </section>
                  		</div>
                 </section>
            </div>
         </section>
         </section>
      </section>
    <!-- js placed at the end of the document so the pages load faster -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.scrollTo.min.js"></script>
    <script src="js/jquery.nicescroll.js" type="text/javascript"></script>

  <!-- BEGIN:File Upload Plugin JS files-->
  <script src="assets/jquery-file-upload/js/vendor/jquery.ui.widget.js"></script>
  <!-- The Templates plugin is included to render the upload/download listings -->
  <script src="assets/jquery-file-upload/js/vendor/tmpl.min.js"></script>
  <!-- The Load Image plugin is included for the preview images and image resizing functionality -->
  <script src="assets/jquery-file-upload/js/vendor/load-image.min.js"></script>
  <!-- The Canvas to Blob plugin is included for image resizing functionality -->
  <script src="assets/jquery-file-upload/js/vendor/canvas-to-blob.min.js"></script>
  <!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
  <script src="assets/jquery-file-upload/js/jquery.iframe-transport.js"></script>
  <!-- The basic File Upload plugin -->
  <script src="assets/jquery-file-upload/js/jquery.fileupload.js"></script>
  <!-- The File Upload file processing plugin -->
  <script src="assets/jquery-file-upload/js/jquery.fileupload-fp.js"></script>
  <!-- The File Upload user interface plugin -->
  <script src="assets/jquery-file-upload/js/jquery.fileupload-ui.js"></script>
  <!--common script for all pages-->
  <script src="js/common-scripts.js"></script>
</body>
</html>
