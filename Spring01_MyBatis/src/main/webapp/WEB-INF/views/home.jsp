<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/home.jsp</title>

</head>
<body>
	<div class="container">
		<h1>인덱스 페이지 입니다.</h1>
		<ul>
			<li><a href="member/list.do">회원 목록 보기</a></li>
			<li><a href="member/list2.do">회원 목록 보기2</a></li>
			<li><a href="todo/list.do">할일 목록 보기</a></li>
			<li><a href="study.jsp">테스트</a></li>
			<li><a href="send.do">Map : json 테스트</a></li>
			<li><a href="send2.do">Dto : json 테스트</a></li>
			<li><a href="send3.do">list&lt;string&gt; : json 테스트</a></li>
			<li><a href="send4.do">list&lt;dto&gt; : json 테스트</a></li>
			<li><a href="file/upload_form.do">파일 업로드 테스트</a></li>
			
		</ul>
		
		<h2>공지 사항</h2>
		<ul>
			<c:forEach var="tmp" items="${requestScope.noticeList }">
				<li>${tmp }</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>
