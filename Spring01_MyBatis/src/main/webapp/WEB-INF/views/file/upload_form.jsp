<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/file/upload_form.jsp</title>
</head>
<body>
	<div class="container">
		<h1>파일 업로드 테스트</h1>
		<form action="upload.do" method="post" enctype="multipart/form-data"> <!-- 파일 업로드할때 enctype 속성을 써야 인코딩 된다. -->
			<input type="file" name="myFile" />
			<button type="submit">업로드</button>
		
		</form>
		<h1>파일 업로드 테스트2</h1>
		<form action="upload2.do" method="post" enctype="multipart/form-data">
			제목 <input type="text" name="title" />
			<br />
			첨부파일 <input type="file" name="myFile" />
			<br />
			<button type="submit">업로드</button>
		
		</form>
	</div>
</body>
</html>