<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../resources/css/board.css">
<script type="text/javascript" src="../resources/js/write.js"></script>
<title>[board.jsp]</title>
</head>
<body>
   <section>
      <h1><a href="">게시판</a></h1>
<!--       게시판 글목록 영역 -->
      <table>
      <tr>
      <td class="full">전체:${fn:length(board)}</td>
      </tr>
      </table>
      <table>
         <tr class="header">
            <td class="num">번호</td>
            <td class="title">제목</td>
            <td class="writer">작성자</td>
             <td class="visit_num">조회수</td>
             <td class="created_at">작성일</td>  
         </tr>

<!--          게시글 아이템 영역 -->
       <c:forEach items="${board}" var="value">     
         <tr class="item">
            <td class="num">${value.boardnum}</td>
            <td class="title">
            <a href="read?boardnum=${value.boardnum}">
            ${value.title}</a></td>
            <td class="writer">${value.id}</td>
            <td class="visit_num">${value.hits}</td>
             <td class="created_at">${value.inputdate}</td>
         </tr>
         </c:forEach>
      </table>
      
<!--       게시판 관련 버튼 영역 -->
      <c:if test="${loginId!=null}">
      <div class="button_pane">
         <input type="button" value="글쓰기" onclick="write2()">
      </div>
      </c:if>
       <div class="button_pane">
         <input type="button" value="돌아가기" onclick="return1()">
      </div>
<!--       페이지 이동 영역 -->
      <div class="page_navi">
         <a href="">◁◁</a>
         <a href="">◀</a>
         <a href="">1</a>
         <a href="">2</a>
         <a href="">3</a>
         <a href="">4</a>
         <a href="">5</a>
         <a href="">▶</a>
         <a href="">▷▷</a>
      </div>
<!--       검색 폼 영역 -->
      <div class="search_form">
            <form method="get" action="search" onsubmit="return search()" >
            <input type="text" placeholder="검색어 입력" name="title" id="title"> 
            <input type="submit" value="검색">
            </form>
      </div>
   </section>
   
</body>
</html>
