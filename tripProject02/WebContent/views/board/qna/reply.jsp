<!-- 사용자에게 보여지는 글쓰기 화면 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<h4>
	<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row {
	margin: 0px auto;
}

h2 {
	text-align: center;
}

#reply {
	margin: 0px auto;
	display: block;
	width: 1000px;
}
</style>
</head>
<body>
	<div class="breadcumb-area bg-img bg-overlay"
		style="background-image: url(../../template/css/img/bg-img/jeju.png)"></div>
		<div class="wrapper row2">
			<div id="services" class="clear">
				<div style="width:1000px;height: 150px;margin-left:300px;">
			<img src="../../board/images/qna.jpg" style="text-align:center;width:100%; height:120px;"/></div>
				<div class="container">
					<div id="reply">
						<form method=post action="qna_reply_ok.do">
							<table class="table table-hover"
								style="width: 60%; margin: 0px auto;">
								<tr>
									<th width=20% class="text-right"style="background-color: #7643ea" >이름</th>
									<td width=80% style="background-color:white;"data-name="${name }"><c:out value="${name }"></c:out>
										<input type=hidden name=pno value="${pno }"></td>
								</tr>
								<tr>
									<th width=20% class="text-right "style="background-color: #7643ea">제목</th>
									<td width=80%><input type="text" name="subject" size=50
										required></td>
								</tr>
								<tr>
									<th width=20% class="text-right"style="background-color: #7643ea">내용</th>
									<td width=80%><textarea rows="8" cols="50" name="content"
											required></textarea></td>
								</tr>
								<tr>
									<td class="text-center" colspan="2"><input type="submit"
										value="답변" class="btn btn-sm btn-primary"> <input
										type="button" value="취소" class="btn btn-sm btn-danger"
										onclick="javascript:history.back()"></td>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
</body>
	</html>
</h4>
