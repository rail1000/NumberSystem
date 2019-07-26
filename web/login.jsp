<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN" class="bootstrap-admin-vertical-centered">
<head>
<meta>
<title>补号管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="static/css/bootstrap.min.css">
<link rel="stylesheet" href="static/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="static/css/bootstrap-admin-theme.css">
<script src="static/js/jquery-3.1.1.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
</head>
<style type="text/css">
.alert {
	margin: 0 auto 20px;
	text-align: center;
}
</style>
<script type="text/javascript">
	$(function(){

	});	
</script>

<body class="bootstrap-admin-without-padding" style="background:#e9ecf3">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="alert alert-info" style="max-width:400px;">
					欢迎登录补号管理系统
				</div>

				<form class="bootstrap-admin-login-form" id="loginForm" method="post" action="LoginServlet">
					<div class="form-group">
						<label class="control-label" for="username">账&nbsp;号</label> <input
							type="text" class="form-control" id="username" name="username"
							placeholder="帐号" /> 
					</div>
					
					<div class="form-group">
						<label class="control-label" for="password">密&nbsp;码</label> <input
							type="password" class="form-control" id="password"
							name="password"  placeholder="密码" />
					</div>
					<div style="font-size:14px;">
						<input type="radio" name="role" value="1" style="width: 20px;height: 20px;"><span style="font-size:15px;">申请人</span>
						<input type="radio" name="role" value="2"  style="width: 20px;height: 20px;"><span style="font-size:15px;">审核人</span>
						<input type="radio" name="role" value="3" style="width: 20px;height: 20px;"><span style="font-size:15px;">补号人</span>
						<input type="radio" name="role" value="4" style="width: 20px;height: 20px;"><span style="font-size:15px;">管理员</span>
					</div>
					<br> <input type="button"  id="loginBtn" class="btn btn-lg btn-primary" value="登&nbsp;&nbsp;&nbsp;&nbsp;录"  onclick="login()"/>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function login(){
			var username =document.getElementById("username").value;
			var password =document.getElementById("password").value;
			var roles=document.getElementsByName("role");
			var role="";
			 for (i=0;i<roles.length;i++){
			   if(roles[i].checked){
			   		role=roles[i].value;
			   }
			}
			if(username==""){
				alert("请输入用户名");
			}else if(username==""){
				alert("请输入密码");
			}else if(role==""){
				alert("请选择登录角色");
			}else{
				document.getElementById("loginForm").submit();
			}
		}
	</script>
</body>
</html>