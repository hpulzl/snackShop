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
	//订单删除
	function delOrder(orderid,odid){
		 $.ajax({
			  cache: true,
			  type: 'POST',
			  url:'${pageContext.request.contextPath }/user/deleteOrderInfo.action',
			  data:"orderid="+orderid+"&odid="+odid,
			  async:false,
			  success:function(data){
				 if(data){
					 alert("删除成功！");
					 window.location.reload();
				 }else{
					 alert("删除失败！");
				 }
			  }
		  });
	}
	//订单支付
	function purchaseOrder(orderid){  
		   if(confirm("确定支付吗？")){
			   //确定支付，执行支付逻辑
			   $.ajax({
					  cache: true,
					  type: 'POST',
					  url:'${pageContext.request.contextPath }/user/payerOrder.action',
					  data:"orderid="+orderid,
					  async:false,
					  success:function(data){
						 if(data){
							 alert("支付成功，可以前去评论该商品！");
							 window.location.reload();
						 }else{
							 alert("支付失败！");
						 }
					  }
				  });
		    }else{
		    	//取消支付
		    	return false;
			}
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
                              	<b>购物清单</b>
                          </header>
                          <table class="table table-striped table-advance table-hover">
                              <thead>
                              <tr>
                                  <th><i class="icon-bullhorn"></i> 零食名称</th>
                                  <th class="hidden-phone"><i class="icon-question-sign">单价</i></th>
                                  <th><i class="icon-bookmark"></i> 个数</th>
                                  <th><i class="icon-bookmark"></i> 总价</th>
                                  <th><i class="icon-bookmark"></i>时间</th>
                                  <th><i class=" icon-edit"></i> 操作</th>
                              </tr>
                              </thead>
                              <tbody>
                              <c:if test="${not empty userCustom}">
                              	<c:forEach items="${userCustom.userOrderList }" var="row" varStatus="index">
	                              <tr>
	                                  <td><a href="javaScript:;">${row.orderdetails.productCustom.pdname }</a></td>
	                                  <td>
		                                  <c:if test="${row.orderdetails.productCustom.disprice!=null }">
		                                  	优惠价:<fmt:formatNumber pattern="0.00" maxFractionDigits="2">${row.orderdetails.productCustom.disprice }</fmt:formatNumber>元
		                                  </c:if>
		                                   <c:if test="${row.orderdetails.productCustom.pdprice!=null }">
		                                  	<fmt:formatNumber pattern="0.00" maxFractionDigits="2">${row.orderdetails.productCustom.pdprice }</fmt:formatNumber>元
		                                  </c:if>
	                                  </td> 
	                                  <td><fmt:formatNumber pattern="0">${row.orderdetails.odnumber}</fmt:formatNumber> 个</td>
	                                  <td><fmt:formatNumber pattern="0.00" maxFractionDigits="2">${row.orderdetails.odprice }</fmt:formatNumber>元</td>
	                                  <td><fmt:formatDate value="${row.ordertime }" dateStyle="long"/></td>
	                                  <td>
	                                      <button class="btn btn-danger btn-xs" onclick="delOrder('${row.orderdetails.orderid}','${row.orderdetails.odid}')"><i class="icon-trash "></i></button>
	                                      <c:if test="${row.ispay == true}">
		                                  	<button class="btn btn-success btn-xs" disabled="disabled">已支付</button>
		                                  </c:if>
		                                  <c:if test="${row.ispay == false}">
		                                  	<button class="btn btn-success btn-xs" onclick="purchaseOrder('${row.orderdetails.orderid}')">未支付</button>
		                                  </c:if>
	                                  </td>
	                              </tr>
	                              </c:forEach>
                              </c:if>
                              <c:if test="${ userCustom == null}">
                              	<span class="label label-info label-mini">暂无订单信息</span></td>
                              </c:if>
                              </tbody>
                          </table>
                      </section>
                  </div>
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
