<!doctype html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>login</title>
<link rel="stylesheet" type="text/css" href="/static/css/login_styles.css">
</head>
<body>

<div class="htmleaf-container">
		<div class="wrapper">
			<div class="container">
				<h1>Welcome</h1>

				<form class="form" action="<%=request.getContextPath() %>/login" method="post">
					<input type="text" placeholder="userName" name="userName">
					<input type="password" placeholder="password" name="password">
					<button type="submit" id="login-button" class="button">Login</button>
				</form>
			</div>
		</div>

</div>

<%--<script src="/static/js/jquery-2.1.1.min.js" type="text/javascript"></script>--%>
<script>
// $('#login-button').click(function (event) {
// 	event.preventDefault();
// 	$('form').fadeOut(500);
// 	$('.wrapper').addClass('form-success');
// });
</script>

</body>
</html>