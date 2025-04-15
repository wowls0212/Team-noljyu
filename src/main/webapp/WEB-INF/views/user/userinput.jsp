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


<script>
$(document).ready(function(){
    $("select[name='admin']").change(function(){
        if($(this).val() === "admin") {
            $("#adminPwRow").show();
        } else {
            $("#adminPwRow").hide();
            $("#adminPass").val(""); // 비우기
        }
    });
});
</script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="usersave" method="post">
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
				<th>아이디</th>
				<td>
				<input type="text" name="id" id="id"> 
				<input type="button" id="idcheck" value="id 중복확인">
				</td>
			</tr>

			<tr>
				<th>패스워드</th>
				<td><input type="text" name="pw"></td>
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
				<th>나의 반려동물</th>
				<td><input type="text" name="myanimal"></td>
			</tr>

			<tr style="text-align: center;">
				<td colspan="2">
				<input type="submit" value="입력">&emsp;
				<input type="button" value="취소" onclick="location.href='main'">
			</tr>


		</table>
	</form>
</body>
</html>