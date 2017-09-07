<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>개인정보 수정</title>

<link rel="stylesheet" type="text/css" href="../resources/css/default.css" />

<script>
//수정폼 확인
function formCheck() {
	var pw = document.getElementById('password');
	var pw2 = document.getElementById('password2');
	var name = document.getElementById('name');
	
	if (pw.value != '' && pw.value.length < 3 || pw.value.length > 10) {
		alert("비밀번호는 3~10자로 입력하세요.");
		pw.focus();
		pw.select();
		return false;
	}
	if (pw.value != pw2.value) {
		alert("비밀번호를 정확하게 2번 입력하세요.");
		pw.focus();
		pw.select();
		return false;
	}
	if (name.value == '') {
		alert("이름을 입력하세요.");
		name.focus();
		name.select();
		return false;
	}
	return true;
}
</script>
</head>

<body>
<div class="centerdiv">
<h1>[ 개인정보 수정 ]</h1>

<form action="update"  method="post" onsubmit="return formCheck();">
<table>
	<tr>
		<th>ID</th>
		<td>${customer.custid}</td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type="password" name="password" id="password" placeholder="비밀번호 입력" /><br>
		<input type="password" id="password2" placeholder="비밀번호 다시 입력" /></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><input type="text" name="name" id="name" value="${customer.name}" /></td>
	</tr>
	<tr>
		<th>이메일</th>
		<td><input type="text" name="email" id="email" value="${customer.email}" /></td>
	</tr>
	<tr>
		<th>고객구분</th>
		<td>
			<input type="radio" name="division" value="personal" 
			<c:if test="${customer.division == 'personal'}">
			checked
			</c:if>
			>개인
			
			<input type="radio" name="division" value="company">기업
		</td>
	</tr>
	<tr>
		<th>식별번호</th>
		<td>
			<input type="text" name="idno" id="idno" value="${customer.idno}">
		</td>
	</tr>
	<tr>
		<th>주소</th>
		<td><input type="text" name="address" value="${customer.address}" style="width:300px;" /></td>
	</tr>
</table>
	<br>

<input type="submit" value="수정" />
<input type="reset" value="다시 쓰기" />

</form>

</div>

</body>
</html>
