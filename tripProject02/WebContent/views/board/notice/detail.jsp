<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h4>
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- Favicon -->
<link rel="icon" href="../css/img/core-img/favicon.ico">

<!-- Core Stylesheet -->
<link href="../css/style.css" rel="stylesheet">

<!-- Responsive CSS -->
<link href="../css/css/responsive/responsive.css" rel="stylesheet">
</head>
<body>
	<div class="breadcumb-area bg-img bg-overlay"
		style="background-image: url(../../template/css/img/bg-img/jeju.png)"></div>
	<div class="wrapper row2">
		<div id="services" class="clear">
			<div class="text-center">
				<img src="../../board/images/notice.jpeg">
			</div>
			<div class="container">
				<h2 class="text-center">내용보기</h2>
				<div class="row">
					<table class="table" style="width: 60%; margin: 0px auto;">
						<tr>
							<th class="text-center success" width=20% style="color: black;">번호</th>
							<td class="text-center" width=30%>${vo.no }</td>
							<th class="text-center success" width=20% style="color: black;">작성일</th>
							<td class="text-center" width=30%><fmt:formatDate
									value="${vo.regdate }" pattern="yyyy-MM-dd" /></td>
						</tr>
						<tr>
							<th class="text-center success" width=20% style="color: black;">이름</th>
							<td class="text-center" width=30%>${vo.name }</td>
							<th class="text-center success" width=20% style="color: black;">조회수</th>
							<td class="text-center" width=30%>${vo.hit }</td>
						</tr>
						<tr>
							<th class="text-center success" width=20% style="color: black;">제목</th>
							<td class="text-left" colspan="3">${vo.subject }</td>
						</tr>
						<tr>
							<td class="text-left" colspan="4" valign="top" height="200">${vo.content }</td>
						</tr>
						<tr>
							<td>
								<th>내용</th>
								<th>버튼</th>
							</td>
						</tr>
						<tr>
							<td style="height: 50px; line-height: 50px;">
								
							</td>
							<td >
								<textarea rows="3" cols="30"></textarea>
							</td>
						</tr>
						<tr>
							<td class="text-right" colspan="4"><a
								href="nupdate.do?no=${vo.no }" class="btn btn-md btn-success">수정</a>
								<a href="ndelete.do?no=${vo.no }" class="btn btn-md btn-info">삭제</a>
								<a href="notice.do" class="btn btn-md btn-warning">목록</a></td>
						</tr>
					</table>

				</div>
			</div>
		</div>
	</div>
	</div>
</body>
	</html>
</h4>