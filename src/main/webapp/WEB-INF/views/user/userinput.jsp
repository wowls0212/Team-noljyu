<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
td, th {
	text-align: center;
}

</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    // ID 체크
    $("#idcheck").click(function() {
        var id = $("#id").val();
        $.post("idcheck2", { id: id }, function(res) {
            alert(res === "ok" ? "사용가능 ID입니다." : "이미 사용중인 ID입니다.");
        });
    });

    // 닉네임 체크
    $("#nicknameCheck").click(function() {
        var nickname = $("#nickname").val();
        $.post("nicknamecheck", { nickname: nickname }, function(res) {
            alert(res === "ok" ? "사용 가능한 닉네임입니다." : "이미 사용 중인 닉네임입니다.");
        });
    });

    // 관리자 선택
    $("select[name='admin']").change(function() {
        if ($(this).val() === "admin") {
            $("#adminPwRow").show();
        } else {
            $("#adminPwRow").hide().val("");
        }
    });
});
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="usersave" method="post" enctype="multipart/form-data">
		<table border="3" width="450px" align="center">
			<caption>회원가입</caption>

			<c:if test="${not empty msg}">
				<div style="color: red">${msg}</div>
			</c:if>

			<tr>
				<th>회원 유형</th>
				<td><select name="admin">
						<option value="user">일반 사용자</option>
						<option value="admin">관리자</option>
				</select></td>
			</tr>

			<tr id="adminPwRow" style="display: none;">
				<th>관리자용 비밀번호</th>
				<td><input type="password" name="adminPass" id="adminPass"></td>
			</tr>

			<tr>
				<th>프로필 사진</th>
				<td style="text-align: right;">
				<input type="file" name="uploadfile" accept="image/*" style="float: right;" /></td>
			</tr>

			<tr>
				<th>아이디</th>
				<td>
				<input type="text" name="id" id="id"> 
				<input type="button" id="idcheck" value="id 중복확인">
				</td>
			</tr>

			<tr>
				<th>패스워드</th>
				<td><input type="password" name="pw"></td>
			</tr>

			<tr>
				<th>이름</th>
				<td><input type="text" name="name"></td>
			</tr>

			<tr>
				<th>주소</th>
				<td><input type="text" name="address"></td>
			</tr>

			<tr>
				<th>연락처</th>
				<td>
				<input type="text" name="phone" placeholder="000-0000-0000"
				 pattern="\d{3}-\d{3,4}-\d{4}" title="형식: 010-1234-5678" required>
				</td>
			</tr>

			<tr>
				<th>닉네임</th>
				<td>
				<input type="text" name="nickname" id="nickname"> 
				<input type="button" id="nicknameCheck" value="닉네임 중복확인"></td>
			</tr>


			<tr>
				<th>반려동물 종류</th>
				<td><input type="text" name="myanimal" required></td>
			</tr>
			<tr>
				<th>반려동물 이름</th>
				<td><input type="text" name="petName" required>
					<div style="font-size: 0.8em; color: #555;">
					(비밀번호 찾기 시, 본인 확인용으로 사용됩니다)
					</div>
				</td>
			</tr>


			<tr style="text-align: center;">
				<td colspan="2">
				<input type="submit" value="입력">&emsp;
				<input type="button" value="취소" onclick="location.href='main'">
			</tr>


		</table>
	</form>
	
<!-- 회원가입 폼 하단 -->
<div style="text-align: center; margin-top: 30px;">
  <p><strong>SNS 계정으로 회원가입</strong></p>
  <div style="display: inline-flex; gap: 20px; justify-content: center;">
    <!-- 카카오 회원가입 -->
    <a href="https://kauth.kakao.com/oauth/authorize?client_id=20a5e796e82f7a14c3129cd0e99636cd&amp;redirect_uri=http://localhost:8080/kakaoSignup&amp;response_type=code">
      카카오로 회원가입
    </a>
    <!-- 네이버 로그인 -->
	<a href="https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=cBWORgjiixKTzRa29Ipm3&redirect_uri=http://localhost:8080/naverSignup&state=1234">
	  네이버로 회원가입 </a>
  </div>
</div>
