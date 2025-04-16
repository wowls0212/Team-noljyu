<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style type="text/css">
td, th 
{
	text-align: center;
}
</style>
</head>
<body>

	<!-- 일반 로그인 폼 -->
	<form action="logincheck" method="post">
		<table border="3" width="330px" align="center">
			<caption>로그인화면</caption>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr style="text-align: center;">
				<td colspan="2">
					<input type="submit" value="로그인">&emsp;
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>

	<!-- 로그인 폼 하단 -->
	<div style="text-align: center; margin-top: 30px;">
		<p>
			<strong>SNS 계정으로 로그인</strong>
		</p><div style="display: inline-flex; gap: 20px; justify-content: center;">
			<!-- 카카오 로그인 -->
			<a href="https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=20a5e796e82f7a14c3129cd0e99636cd&redirect_uri=http://localhost:8080/kakaoLogin&prompt=consent&scope">
				카카오로 로그인 </a>

			<!-- 네이버 로그인 -->
			<a href="https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=cBWORgjiixKTzRa29Ipm3&redirect_uri=http://localhost:8080/naverSignup&state=1234">
				네이버로 로그인 </a>

		</div>
	</div>