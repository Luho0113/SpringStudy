<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 목록</title>
</head>
<body>
	<h1>책 목록</h1>
	<!-- 검색창 영역 -->
	<!-- form의 기본 메소드는 get이기 때문에 검색 버튼을 클릭하면 검색 파라미터가 있는 목록 페이지로 넘어감 -->
	<!-- jstl문의 core를 선언해줘야 반복문의 문법을 사용할 수 있음 / prefix: uri를 줄여서 쓴다는 뜻 -->
	<p>
		<form>
			<input type="text" placeholder="검색" name="keyword" value="${keyword}" />
			<input type="submit" value="검색" />
		</form>
	</p>
	<table>
		<thead>
			<tr>
				<td>제목</td>
				<td>카테고리</td>
				<td>가격</td>
			</tr>
		</thead>
		<!-- 향상된 for문을 사용하는 것 -->
		<tbody>
			<c:forEach var="row" items="${data}">
				<tr>
					<td><a href="/detail?bookId=${row.book_id}"> ${row.title}</a></td>
					<td>${row.category}</td>
					<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${row.price}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="/create">생성</a>
	</p>
</body>
</html>