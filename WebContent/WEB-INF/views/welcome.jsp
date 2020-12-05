<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<span style="position:absolute;right:10px;top:10px">您好,${user.userName},欢迎登陆！</span><br>
<hr/>
	<a href="getUserById?id=1" >根据id获取用户信息：getUserById(id)</a><br/>
	<a href="getAllUser">获取所有用户信息</a><br/>
	<a href="pages/userTable.html">获取数据库中所有用户信息</a><br/>

<script type="text/javascript">

</script>
</body>
</html>