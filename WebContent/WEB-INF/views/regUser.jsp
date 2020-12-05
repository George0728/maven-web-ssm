<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSM框架项目</title>
<link rel="icon" href="static/img/favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="static/img/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="static/css/regUser.css" />
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>	

	
	<div class="div_base">
		<div class="inner">
			<h2 align="center" >注册界面</h2>
			<label for="userName">用户名：</label><input type="text" id="c" name="userName" autocomplete="off"/><br><br>
			<label for="userName">密&#12288;码：</label><input type="text" id="password" name="password" autocomplete="off"/><br><br>
			<label for="age">年&#12288;龄：</label><input type="text" id="age" name="age" autocomplete="off"/><span class="span_err" >${msg}</span><br><br>
		</div>
		<div>
			<input type="button" value="注册用户" onclick ="regUser()"  style="width: 100px;"/>
			<a class="a_user"  href="login.jsp" >返回登录</a>
		</div>
	<br>
	
	</div>
	<script type="text/javascript">
		
	//注册用户
		function regUser(){
			var userName = $("#userName").val();
			var password = $("#password").val();
			var age = $("#age").val();
			var data = {"userName":userName, "password":password,"age":age};

		if ("" == userName) {
				alert("请输入用户名！");
			} else if ("" == password) {
				alert("请输入密码！");
			} else {
				 	$.ajax({
						type : "POST",
						url : "regUser",
						data : data,
						contenType : "json",
						success : function(result){
							 var new_doc = document.open("text/html","replace");
							    new_doc.write(result);
							    new_doc.close();
					},
					error : function(e) {
						if(e.status == "400"){
							msg ="注册失败！";
							alert("注册失败，请重新输入！");
						}
					}
				});
			}
		}
	
/* 		//注册后登录
		function checkUser(){
			var userName = $("#userName").val();
			var password = $("#password").val();
			var data = {"userName":userName, "password":password};
			if(userName == ""){
				alert("请输入用户名！");
			}else if(password == ""){
				alert("请输入密码！");
			}else{
				$.ajax({
					type : "POST",
					url : "login",
					data : data,
					contenType : "json",
					success : function(result){
						document.open();
						      document.write(result);
					},
					error : function(e){
						console.log(e.status);
					}
				});
			}
		}
	 */
	</script>
</body>
</html>