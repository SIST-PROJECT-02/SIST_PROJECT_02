<!-- 사용자에게 보여지는 글쓰기 화면 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h4><html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- Favicon -->
<link rel="icon" href="../css/img/core-img/favicon.ico">

<!-- Core Stylesheet -->
<link href="../css/style.css" rel="stylesheet">

<!-- Responsive CSS -->
<link href="../css/css/responsive/responsive.css" rel="stylesheet">
<!-- require 쓰기 위해서 HTML 5 버젼 쓰자 ==> head 부분을 HTML5 양식으로 고쳤음 -->
<style type="text/css">
 .row{
	margin: 0px auto;
} 
h2 {
	text-align: center;
}
 #reply{
	margin: 0px auto;
	display: block;
	width: 1000px;
} 
</style>
</head>
<body>
<div class="breadcumb-area bg-img bg-overlay" style="background-image: url(../../template/css/img/bg-img/jeju.png)"></div>
<div class="wrapper row2">
  <div id="services" class="clear">
  <div class="text-center">
  		<img src="../../board/images/QnA.png">
  	</div> 
	<div class="container">
		<h2>글쓰기</h2>
		<div id="reply">
			<form method=post action="reply_ok.do">
			 <!-- action: insert_ok.jsp 에서 데이터 받아서 처리 -->
			 <!-- 업로드게시판: enctype="multipart/form-data" 써야 파일첨부됨 (cos.jar 이용한것) -->
				<table class="table table-hover" style="width:60%; margin:0px auto;">
					<tr>
						<th width=20% class="text-right success">이름</th>
						<td width=80%>
							<input type="text" name="name" size=15 required>
							<input type=hidden name=pno value="${pno }">
						</td>
					</tr>
					<tr>
						<th width=20% class="text-right success">제목</th>
						<td width=80%>
							<input type="text" name="subject" size=50 required>
						</td>
					</tr>
					<tr>
						<th width=20% class="text-right success">내용</th>
						<td width=80%>
							<textarea rows="8" cols="50" name="content" required></textarea>
						</td>
					</tr>
					<tr>
						<th width=20% class="text-right success">비밀번호</th>
						<td width=80%>
							<input type="password" name="pwd" size=10 required>
						</td>
					</tr>
					<tr>
						<td class="text-center" colspan="2">
							<input type="submit" value="답변" class="btn btn-sm btn-primary">
							<input type="button" value="취소" class="btn btn-sm btn-danger"
							onclick="javascript:history.back()">
						</td>
					</tr>
				</table>
			</form>
		</div>
		</div>
		</div>
		</div>
	</div>
</body>
</html></h4>
