<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../resources/css/read.css"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>read</title>
</head>
<body>
       <h1>[게시판 글 읽기]</h1>
   <section>
   <div>
      <table>
         <tr>
            <td class="col1">
                작성자
            </td>
            <td class="col2">
               ${board.id}
            </td>
         </tr>
         <tr>
            <td class="col1">
               작성일
            </td>
            <td class="col2">
               ${board.inputdate}
            </td>
         </tr>
         <tr>
            <td class="col1">
               조회수
            </td>
            <td class="col2">
               ${board.hits}
            </td>
         </tr>
         <tr>
            <td class="col1">
               제목
            </td>
            <td class="col2">
               ${board.title}
            </td>
         </tr>
         <tr>
            <td class="col1">
               내용
            </td>
            <td class="col2">
               ${board.content}
            </td>
         </tr>
         <tr>
            <td class="col1">
               파일첨부
            </td>
            <td class="col2">
               ${board.savedfile}
            </td>
         </tr>
      </table>
      
      <table>
          
     <tr class=tr2>
       <c:if test="${loginId != null}">     
       <c:if test="${loginId==board.id }">    
      <td><a href="eraser">삭제</a></td>
      <td><a href="rewrite">수정</a></td></c:if></c:if>
      <td><a href="list">목록보기</a></td>
     </tr>  
      </table>
      
      <c:if test="${loginId!=null}">
       <form method="post" action="replyWrite">
            리플내용
       <input type="text" id="text" name="text">
       <input type="hidden" id="boardnum" name="boardnum" value="${board.boardnum}">
       <input type="submit" value="확인"> 
       </form>
       </c:if>
     <br>   
        <table>
     
     <c:forEach items="${list}" var="list">   
     <c:if test="${list.boardnum==board.boardnum}">   
     <tr>      
      <td class="col1">${list.id}</td>
      <td class="col3">${list.text}</td>
      <c:if test="${list.id==loginId}">
       <td class="col4"><a href="update2?replynum=${list.replynum}">[수정]</a></td>
      <td class="col4"><a href="delete2?replynum=${list.replynum}&boardnum=${list.boardnum}">[삭제]</a></td>
     </c:if>
     </tr>
     </c:if>
     </c:forEach>
     
     

      </table>
      
      
      
      
      
      
   </div>
   </section>
</body>
</html>