<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../resources/css/write.css">
<script type="text/javascript" src="../resources/js/write.js"></script>
<title>[write.jsp]</title>
</head>
<body>
<h1>[글쓰기]</h1>
<section>
<div>
<form method="post" action="rewrite" onsubmit="return finish()">
<table>
    
      <tr>
          <td class="col1">제목</td>
          <td class="col2"><input type="text" name="title" id="title" class="title"></td>
      </tr>
      <tr>         
      <td class="col1">내용</td>
          <td class="col2"><textarea name="content" id="content" class="content"></textarea></td>
      </tr>
      
      <tr>         
       <td class="col1">파일첨부</td>
       <td class="col2"><input type="button" value="파일선택">선택된 파일 없음</td>
      </tr> 
</table>
 <input type="submit" value="제출">
 </form>
 </div>
 </section>
</body>
</html>