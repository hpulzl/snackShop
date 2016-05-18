<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<base href="<%=basePath%>">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <link rel="shortcut icon" href="img/favicon.html">

    <title>管理员登录界面</title>
	<script src="js/jquery.min.js"></script>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom styles for this template -->
    <link href="css/style2.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet" />

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
<script type="text/javascript">
	function adminLogin(){
		var adminphone = $('#adminphone').val();
		var adminpassword = $('#adminpassword').val();
		if(adminphone==null || adminphone == ''){
			$('#phone_info').append("请输入手机号");
			return false;
		}
		if(adminpassword==null || adminpassword == ''){
			$('#psd_info').append("请输入密码");
			return false;
		}
		$.ajax({
	        cache: true,
	        type: 'POST', 
	        url:'${pageContext.request.contextPath }/admin/adminLogin.action',
	        data: "adminname="+adminphone+"&adminpassword="+adminpassword,
	        async: false,
	        success: function(data) {
		        if(data ==false){
		        	alert("登录失败!");
		        }else{
		        	alert("登录成功!");
		        	document.forms[0].action = "jsp/admin/adminHomePage.jsp";
		        	document.forms[0].submit();
		        }
	      	}
    	});
	}
</script>
</head>

  <body class="login-body">

    <div class="container">
      <form class="form-signin" method="post">
        <h2 class="form-signin-heading">管理员登录</h2>
        <div class="login-wrap">
            <input type="text" class="form-control" placeholder="手机号" id="adminphone" autofocus>
            <h4><span class="text-warning" id="phone_info"></span></h4>
            <input type="password" class="form-control" placeholder="密码" id="adminpassword">
            <h4><span class="text-warning" id="psd_info"></span></h4>
            <button class="btn btn-lg btn-login btn-block" type="button" onclick="adminLogin(this)">登录</button>
            <a href="jsp/admin/adminRegister.jsp">注册管理员</a>
        </div>
      </form>
    </div>
  </body>
</html>
