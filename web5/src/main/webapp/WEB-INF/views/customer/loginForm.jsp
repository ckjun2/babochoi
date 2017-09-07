<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>

<link rel="stylesheet" type="text/css" href="../resources/css/default.css" />

<script>
//로그인폼 확인
function formCheck() {
	var id = document.getElementById('id');
	var pw = document.getElementById('password');
	
	if (id.value == '') {
		alert("ID를 입력하세요.");
		return false;
	}
	if (pw.value == '') {
		alert("비밀번호를 입력하세요.");
		return false;
	}
	return true;
}
</script>
</head>

<body>
<div class="centerdiv">
<h1>[ 로그인 ]</h1>

<form action="login"  method="post" onsubmit="return formCheck();">
<table>
	<tr>
		<th>ID</th>
		<td>
			<input type="text" name="id" id="id" maxlength="10" />
		</td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type="password" name="password" id="password" /><br>
	</tr>
	<tr>
		<td colspan="2" style="text-align:center;"><input type="submit" value="Login" /></td>
	</tr>
</table>
</form>

</div>
</body>
</html>
