<!-- 사용자에게 보여지는 글쓰기 화면 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h4>
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
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
				<h2>글쓰기</h2>
				<div class="row">
					<form method=post action="notice_insert_ok.do">
						<table class="table table-hover"
							>
							<tr>
								<th width=20% class="text-right success">이름</th>
								<td width=80% data-name="${name }"><c:out value="${name }"></c:out>
								</td>
							</tr>
							<tr>
								<th width=20% class="text-right success">제목</th>
								<td width=80%><input type="text" name="subject" size=50
									required></td>
							</tr>
							<tr>
								<th width=20% class="text-right success">내용</th>
								<td width=80%><textarea rows="8" cols="50" name="content"
										required></textarea></td>
							</tr>
							<tr>
								<td class="text-center" colspan="2"><input type="submit"
									value="글쓰기" class="btn btn-sm btn-primary"> <input
									type="button" value="취소" class="btn btn-sm btn-danger"
									onclick="javascript:history.back()"></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
		</div>
	s
</body>
	</html>
</h4>
