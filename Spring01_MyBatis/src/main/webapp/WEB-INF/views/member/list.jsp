<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/member/list.jsp</title>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<a href="insertform.do">회원 추가하러 가기</a> <!-- 상대 경로 -->
		<a href="${pageContext.request.contextPath }/home.do">홈으로</a>
		<!-- <a href="${pageContext.request.contextPath }/member/insertform.do">회원 추가하러 가기</a> <!-- 절대 경로 -->
		<h1>회원 목록입니다.</h1>
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>주소</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tmp" items="${requestScope.list }">
					<tr>
						<td>${tmp.getNum() }</td> <!-- 함수로 호출해도 되지만 변수명으로 적어도 된다! -->
						<td>${tmp.name }</td>
						<td>${tmp.addr }</td>
						<td><a href="updateform.do?num=${tmp.num }">수정</a></td>
						<td><a href="delete.do?num=${tmp.num }">삭제</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>