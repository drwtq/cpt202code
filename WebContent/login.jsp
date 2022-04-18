<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width",initial->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="mui.css">
    <title>shopping mall</title>
</head>

<body background="pictures/03.jpg">
<img alt="" src="images/simpool.jpg" class="mui-pull-left" width=200px; height= 125px; style="position:absolute;top:0;left:1"">
<div class="form-wrapper">
    <div class="header">
        login
	</div>
	<form action="LoginServlet" method = "post">
		<input type="hidden" name="action" value="login">
    <div class="input-wrapper">
    	<div class="border-wrapper">
        	<input type="text" name="username" placeholder="input username" class="border-item">
    	</div>
        <div class="border-wrapper">
            <input type="password" name="password" placeholder="password" class="border-item">
        </div>
      
    </div>
	<div class="action">
		<input type="submit" name="login" formaction="index.html" class="btn" value="Sign in" ><br>
		<button type="submit" formaction="register.jsp"  class="btn">register</button>
	</div>
	</form>
	<center>
		
		<p class="col">${message}</p>
	</center>
</div>
</body>
</html>