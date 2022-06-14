<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/todo/updateform.jsp</title>
</head>
<body>
	<div class="container">
		<form action="update.do" method="POST">
			<input type="hidden" name="num" value="${dto.num }"/>
			<div>
				<label for="num">번호</label>
				<input type="text" name="num" id="num" value="${dto.num }" disabled />
			</div>
			<div>
				<label for="content">내용</label>
				<input type="text" name="content" id="content" value="${dto.content }" />
			</div>
			<button type="submit">수정</button>
			<button type="reset">취소</button>
		</form>
	</div>
</body>
</html>