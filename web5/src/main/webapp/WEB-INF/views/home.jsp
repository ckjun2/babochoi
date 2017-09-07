<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
	<title>WEB5</title>
</head>
<body>
<h1>[ WEB5 - 게시판 ]</h1>

<c:if test="${loginId != null}">
<p>* ${loginId}(${loginName})님 로그인 중</p>
</c:if>

<ul>
<c:if test="${loginId == null}">
<li><a href="customer/joinForm">회원가입</a></li>
<li><a href="customer/loginForm">로그인</a></li>
</c:if>

<c:if test="${loginId != null}">
<li><a href="customer/logout">로그아웃</a></li>
<li><a href="customer/updateForm">개인정보 수정</a></li>
</c:if>

<li><a href="board/list">게시판</a></li>

</ul>
</body>
</html>
