<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
	function updatePassword(){
		var oldpsw = $("#oldpassword").val();
		var newpsw = $("#newpsw").val();
		var confirmpsw = $("#confirmPsw").val();
		if(oldpsw==null||oldpsw==''){
			$("#oldpsw_info").append("原始密码不能为空");
			return false;
		}
		if(newpsw==null||newpsw==''){
			$("#psw_info").append("新密码不能为空");
			return false;
		}
		if(confirmpsw==null||confirmpsw==''){
			$("#confirmpsw_info").append("确认密码不能为空");
			return false;
		}
		if(confirmpsw != newpsw ){
			$("#total_info").append("确认密码和新密码不一致");
			return false;
		}
		if(confirmpsw == oldpsw && newpsw == olspsw){
			$("#total_info").append("原始密码和新密码不能相同！");
			return false;
		}
		$.ajax({
	        cache: true,
	        type: 'POST', 
	        url:'${pageContext.request.contextPath }/admin/findupdateAdminInfo.action',
	        data: "password="+newpsw,
	        async: false,
	        success: function(data) {
		        if(data){
		        	alert("修改成功!");
		        }else{
		        	alert("修改失败!");
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
       <section id="main-content">
          <section class="wrapper">
       		<div class="row">
       		 <section class="panel">
                          <header class="panel-heading">
                              	<b>修改密码</b>
                          </header>
                 <form class="form-horizontal" id="default" method="post">
                           <div class="form-group">
                               <label class="col-lg-2 control-label">原始密码</label>
                               <div class="col-lg-10">
                                   <input id="oldpassword" type="password" class="form-control" placeholder="原始密码">
                                    <p class="text-warning" id="oldpsw_info"></p>
                                   <input id="moldpassword" type="hidden" class="form-control" value="${admin.adminpassword }">
                               </div>
                           </div>
                           <div class="form-group">
                               <label class="col-lg-2 control-label">新密码</label>
                               <div class="col-lg-10">
                                   <input type="password" class="form-control" id="newpsw" placeholder="新密码">
                                   <p class="text-warning" id="psw_info"></p>
                               </div>
                           </div>
                           <div class="form-group">
                               <label class="col-lg-2 control-label">确认密码</label>
                               <div class="col-lg-10">
                                   <input type="password" class="form-control" id="confirmPsw" placeholder="确认密码">
                                    <p class="text-warning" id="confirmpsw_info"></p>
                               </div>
                           </div>
                            <p class="text-warning" id="total_info"></p>
                            <div class="col-lg-offset-2 col-lg-10">
								  <input type="submit" class="finish btn btn-danger" value="提交" onclick="updatePassword(this)"/>
							</div>
                   </form>
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
