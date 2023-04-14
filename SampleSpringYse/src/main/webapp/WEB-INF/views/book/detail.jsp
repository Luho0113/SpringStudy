<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 상세</title>
</head>
<body>
	<h1>책 상세</h1>
	<!-- detailMap에서 받아온 data 주소 -->
	<p>책번호 : ${data.book_id}</p> 
	<p>제목 : ${data.title}</p>
	<p>카테고리 : ${data.category}</p>
	<p>
		가격 :
		<fmt:formatNumber type="number" maxFractionDigits="3"
			value="${data.price}"></fmt:formatNumber>
	</p>
	<p>
		입사일 :
		<fmt:formatDate value="${data.insert_date}"
			pattern="yyyy.MM.dd HH:mm:ss" />
	</p>
	<p>
		<a href="/update?bookId=${bookId}">수정</a>
	</p>
	<form method="post" action="/delete">
		<input type="hidden" name="bookId" value="${bookId}" /> <input
			type="submit" value="삭제" />
	</form>
	<p>
		<a href="/list"> 목록으로 </a>
	</p>
	
	<%--  jsp 주석 
  	<p> bookId값 : ${bookId} </p>
  	<p> 책의 큐알은? : ${bookQrAName}  </p>
  	<p> 출판사는? : ${bookPubAName} </p>  
   	<p> A값은 : ${aAN}</p>
   	<p> B값은 : ${bAN}</p>
   	<p> C값은 : ${cAN}</p> --%>

</body>
</html>