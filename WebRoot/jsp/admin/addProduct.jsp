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
<script src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript">
	 function addProduct(){
		var pdname = $("#pdname").val();
		var pdtype = $("#pdtype option:selected").text();
		var price = $("#price").val();
		var isPrice = $("#isPrice").val();
		var picFile = $("#picFile").val();
		var pddetail = $("#mydetail").val();
		if(pdname==null||pdname==""){
			$("#name_info").append("商品名称不能为空！");
			return false;
		}
		if(price==null||price==""){
			$("#pddetail").append("商品价格不能为空！");
			return false;
		}
		if(price==null||price==""){
			$("#detail_info").append("描述不能为空！");
			return false;
		}
		var disprice = null;
		var pdprice = null;
		if(isPrice=="是"){
			disprice = price;
			$("#bbb").val(parseFloat(disprice));
		}else{
			pdprice = price;
			$("#ccc").val(parseFloat(pdprice));
		}
		$("#aaa").val(pdtype);
		document.forms[0].action = "${pageContext.request.contextPath }/admin/addProduct.action";
    	document.forms[0].submit();
		return true;
		/*  $("#mForm").ajaxSubmit({
				  cache: true,
				  type: 'POST',
				  url:'${pageContext.request.contextPath }/admin/addProduct.action',
				  data:"pdname="+pdname+"&pdtype="+pdtype+"&disprice="+parseFloat(disprice)+"&pdprice="+
				  		parseFloat(pdprice)+"&pddetail="+pddetail+"&picFile="+picFile,
				  success:function(data){
					 if(data){
						 alert("添加成功！");
						 window.location.reload();
					 }else{
						 alert("添加失败！");
					 }
				  }
		 }); */
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
			<div class="col-lg-12">
				<section class="panel">
				<header class="panel-heading"> 添加商品 </header>
				 <div class="panel-body">
                    <form role="form" class="form-horizontal" method="post" action="${pageContext.request.contextPath }/admin/addProduct.action" enctype="multipart/form-data">
                           <div class="form-group">
                               <label class="col-lg-2 control-label">商品名称</label>
                               <div class="col-lg-6">
                                   <input type="text" placeholder="商品名称" class="form-control" name="pdname" id="pdname">
                                   <p class="help-block" id="name_info"></p>
                               </div>
                           </div>
                           <div class="form-group">
                               <label class="col-lg-2 control-label">商品类型</label>
                               <div class="col-lg-6">
                                 <select class="form-control m-bot15" id="pdtype">
                                     <option value="水果">水果</option>
                                     <option value="蔬菜">蔬菜</option>
                                     <option value="甜品">甜品</option>
                                     <option value="海外食品">海外食品</option>
                                     <option value="大陆食品">大陆食品</option>
                                     <option value="进口食品">进口食品</option>
                                     <option value="香港特惠食品">香港特惠食品</option>
                                     <option value="辣子鸡系列">辣子鸡系列</option>
                                     <option value="奶制品">奶制品</option>
                                 </select>
                                 <input type="hidden" id="aaa" name="pdtype" value="">
                               </div>
                           </div>
                            <div class="form-group">
                               <label class="col-lg-2 control-label">商品单价</label>
                               <div class="col-lg-6">
                                 <div class="input-group m-bot15">
                                     <span class="input-group-addon">$</span>
                                     <input type="text" class="form-control" placeholder="商品单价" id="price">
                                      <input type="hidden" id="bbb" name="disprice" value="">
                                      <input type="hidden" id="ccc" name="pdprice" value="">
                                 </div>
                                  <p class="help-block" id="price_info"></p>
                               </div>
                           </div>
                           <div class="form-group">
                               <label class="col-lg-2 control-label" >是否打折</label>
                               <div class="col-lg-6">
                                   <div class="row m-bot15">
                                      <select class="form-control m-bot15" id="isPrice">
	                                     <option value="是">是</option>
	                                     <option value="否">否</option>
	                                 </select>
                                    </div>
                               </div>
                           </div>
                           <div class="form-group">
                               <label class="col-lg-2 control-label">上传图片</label>
                               <div class="col-lg-6">
                                   <div class="form-group">
                                      <input type="file" id="picFile" name="picFile">
                                      <p class="help-block">选择要上传的图片</p>
                                  </div>
                               </div>
                           </div>
                            <div class="form-group">
                               <label class="col-lg-2 control-label">商品的描述</label>
                               <div class="col-lg-6">
                                   <textarea id="mydetail" name="pddetail" class="form-control input-lg p-text-area" rows="1" placeholder="写下商品的描述..."></textarea>
                                   <p class="help-block" id="detail_info"></p>
                               </div>
                           </div>
                           <div class="form-group">
                               <div class="col-lg-offset-2 col-lg-10">
                            		${message }<button class="btn btn-danger" type="button" onclick="addProduct(this)">添加</button>
                               </div>
                           </div>
                       </form>
                    </div>
				</section>
		    </div>
		  </div>
		  </section>
		 </section> 
</section>
    <!-- js placed at the end of the document so the pages load faster -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.scrollTo.min.js"></script>
    <script src="js/jquery.nicescroll.js" type="text/javascript"></script>

  <!--common script for all pages-->
  <script src="js/common-scripts.js"></script>
</body>
</html>
