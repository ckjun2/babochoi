<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ID중복확인</title>

<script>
//검색 폼 확인
function formCheck() {
	var id = document.getElementById('searchId');
	if (id.value.length < 3) {
		alert('검색할 ID는 3자 이상 입력하세요.');
		return false;
	}
	return true;
}

//ID사용하고 창 닫기
function selectId() {
	//부모창의 ID입력란에 값 대입
	var custid = opener.document.getElementById('custid');
	custid.value = '${searchId}';
	//현재창 닫기
	this.close();
}
</script>
</head>

<body>
<h1>[ ID 중복 확인 ]</h1>

<form action="idcheck"  method="post" onsubmit="return formCheck();">
	검색할 ID
	<input type="text" name="searchId" id="searchId" maxlength="10" value="${searchID}">
	<input type="submit" value="검색">
</form>
<br><br>

<!-- 검색 후 -->
<c:if test="${check}">
	<!-- 사용중인 아이디인 경우 -->
	<c:if test="${checkResult != null}">
		이미 사용중인 아이디입니다.<br>
	</c:if>
	<!-- 사용할 수 있는 아이디인 경우 -->
	<c:if test="${checkResult == null}">
		사용할 수 있는 아이디입니다.<br>
		<input type="button" value="ID사용하기" onclick="selectId()">
	</c:if>
</c:if>
	
</body>
</html>




