<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/login.css">
	<title>ログイン</title>
</head>

<body>
	<h1>社員管理システム</h1>
	<!-- ログインID、パスワードが間違っていた場合エラーメッセージを表示 -->
	<a id="error" style="background-color: red; color: #fff;">${message}</a>
	<!-- ログインID、パスワードのフォーム -->
	<form action="login" method="post">
		<div class="form_contents">
			<ul>
				<!-- ログインID -->
				<li>
					<label for="loginId">ログインID</label>
					<input type="text" size="30" id="loginId" name="loginId"  maxlength='20'>
				</li>
				<!-- パスワード -->
				<li class="pass">
					<label for="password">パスワード</label>
					<input type="password" size="30" id="password" name="password"  maxlength='20'>
				</li>
			</ul>
		</div>
		<!-- ログインボタン -->
		<input type="submit" class="button" value="ログイン">
	</form>
</body>

</html>