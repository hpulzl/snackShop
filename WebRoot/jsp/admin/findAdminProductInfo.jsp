<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
<title>管理员主页面</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/bootstrap-reset.css" type="text/css">
<link rel="stylesheet" href="assets/font-awesome/css/font-awesome.css" type="text/css">
<link href="assets/gritter/css/jquery.gritter.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" href="css/style2.css" type="text/css">
<link rel="stylesheet" href="css/style-responsive.css" type="text/css">
<script type="text/javascript">
//订单删除
function delProduct(pdid){
	 $.ajax({
		  cache: true,
		  type: 'POST',
		  url:'${pageContext.request.contextPath }/admin/delProductInfo.action',
		  data:"pdid="+pdid,
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
           		 <div class="col-sm-12 logo">
				   <h3>零食王国后台管理</h3>
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
                          <span>管理员操作</span>
                          <span class="arrow"></span>
                      </a>
                      <ul class="sub">
                          <li><a class="" href="admin/findAdminInfo.action">管理员信息</a></li>
                          <li><a class="" href="jsp/admin/adminUpdatePassword.jsp">修改密码</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" class="">
                          <i class="icon-cogs"></i>
                          <span>商品管理</span>
                          <span class="arrow"></span>
                      </a>
                      <ul class="sub">
                           <li><a class="" href="admin/findAdminProductInfo.action?pageNo=1">商品查询</a></li>
                           <li><a class="" href="jsp/admin/addProduct.jsp">添加商品</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="admin/adminLogout.action" class="">
                          <i class="icon-glass"></i>
                          <span>退出登录</span>
                          <span class="arrow"></span>
                      </a>
                  </li>
              </ul>
          </div>
      </aside>
      <!--sidebar end-->
      <!-- form -->
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
                                  <th><i class="icon-bullhorn"></i> 食品类别</th>
                                  <th class="hidden-phone"><i class="icon-question-sign">单价</i></th>
                                  <th><i class="icon-bookmark"></i> 优惠价</th>
                                  <th><i class="icon-bookmark"></i>添加时间</th>
                                  <th><i class=" icon-edit"></i> 操作</th>
                              </tr>
                              </thead>
                              <tbody>
                              <c:if test="${not empty productdetails}">
                              	<c:forEach items="${productdetails }" var="row" varStatus="index">
	                              <tr>
	                                  <td><a href="javaScript:;">${row.pdname }</a></td>
	                                  <td class="hidden-phone">${row.pdtype }</td>
	                                   <td>
		                                   <c:if test="${row.pdprice!=null }">
		                                  	<fmt:formatNumber pattern="0.00" maxFractionDigits="2">${row.pdprice}</fmt:formatNumber>元
		                                   </c:if>
		                                   <c:if test="${row.pdprice==null }">
		                                  	打折商品
		                                   </c:if>
	                                   </td>
	                                  <td>
		                                  <c:if test="${row.disprice !=null }">
		                                  	<fmt:formatNumber pattern="0.00" maxFractionDigits="2">${row.disprice }</fmt:formatNumber>元
		                                  </c:if>
		                                  <c:if test="${row.disprice ==null }">
		                                  	商品不打折
		                                  </c:if>
		                              </td>
	                                  <td><fmt:formatDate value="${row.createtime }" dateStyle="long"/></td>
	                                   <td><button class="btn btn-danger btn-xs" onclick="delProduct('${row.pdid}')"><i class="icon-trash "></i></button></td>
	                              </tr>
	                              </c:forEach>
                              </c:if>
                              </tbody>
                          </table>
                           <c:if test="${ productdetails == null}">
                              	<span class="label label-info label-mini">暂无订单信息</span></td>
                           </c:if>
                      </section>
                  </div>
                 </section>
              </div>
              <div class="row">
              	<div class="col-sm-6">
              		<div class="dataTables_info" id="sample_1_info">共${totalPageNo }页</div>
              	</div>
              	<div class="col-sm-6">
              	   <div class="dataTables_paginate paging_bootstrap pagination">
              		 <ul>
              		 <c:if test="${currentPageNo>1 }">
              		 	<li class="prev"><a href="admin/findAdminProductInfo.action?pageNo=${currentPageNo }&info=pre">← 上一页</a></li>
              		 </c:if>
              		 <c:if test="${currentPageNo<=1 }">
              		 	<li class="prev disabled"><a href="javaScript:;">上一页</a></li>
              		 </c:if>
              		 <c:if test="${currentPageNo >= totalPageNo }">
              		 	<li class="prev disabled"><a href="javaScript:;">下一页</a></li>
              		 </c:if>
              		  <c:if test="${currentPageNo < totalPageNo }">
              		 	<li class="prev disabled"><a href="admin/findAdminProductInfo.action?pageNo=${currentPageNo }&info=next">← 下一页</a></li>
              		 </c:if>
              		</ul>
              	  </div>
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
