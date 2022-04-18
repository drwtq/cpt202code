<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width",initial->
    <link rel="stylesheet" href="style.css">
    <title>world message board of the future</title>
</head>

<body background="pictures/02.jpg">
<div class="form-wrapper">
    <div class="header">
        Register
	</div>
	<form action="RegistServlet" method = "post">
	<!-- 浏览者单击发送按钮发送表单的时候，隐藏域的信息也被一起发送到服务器。 -->
		<input type="hidden" name="action" value="regist">
    <div class="input-wrapper">
    	<div class="border-wrapper">
        	<input type="text" name="username" placeholder="username" class="border-item">
    	</div>
        <div class="border-wrapper">
            <input type="text" name="password" placeholder="password" class="border-item">
		</div>
	<div class="border-wrapper">
		<input type="password" name="password2" placeholder="Confirm password" class="border-item">
	</div>
	<div class="action">
		<input type="submit" name="regist" class="btn" value="Regist" ><br>
	</div>
	</div>
	</form>
	<center>
		<!-- 获取注册是否成功信息 -->
		<p class="col">${message}</p>
	</center>
	</div>
</body>
</html>