<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE >
<html>
<head>
<title>xx系统</title>
</head>
<body>
	<div class="wrapper">
		<form class="form-signin" action="/login" method="post">
			<h2 class="form-signin-heading">Please login 1212</h2>
			<input type="text" class="form-control" name="username" value="admin"
				placeholder="账号" required="" autofocus="" /> <input type="password"
				class="form-control" name="password" value="admin" placeholder="密码" required="" />
			<label class="checkbox"> <input type="checkbox"
				value="remember-me" id="rememberMe" name="rememberMe">
				Remember me
			</label>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
		</form>
	</div>
</body>
</html>