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
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<style type="text/css">
.row {
	margin: 0 auto;
}

h2 {
	text-align: center;
}

#update {
	margin: 0px auto;
	display: block;
	width: 800px;
}
</style>
</head>
<body>

	<div class="breadcumb-area bg-img bg-overlay"
		style="background-image: url(../../template/css/img/bg-img/jeju.png)"></div>
	<div class="wrapper row2">
		<div id="services" class="clear">
			<div style="width:1000px;height: 150px;margin-left:300px;">
			<img src="../../board/images/free.png" style="text-align:center;width:100%; height:120px;"/></div>
			<div class="container">
				<div  id="update">
					<form method=post action="free_insert_ok.do">
						<table class="table table-hover"
							style="width: 80%; margin: 0px auto;">
							<tr>
								<th width=20% class="text-right" style="background-color: #7643ea;">이름</th>
								<td width=80% data-name="${name }"><c:out value="${name }"></c:out>
								</td>
							</tr>
							<tr>
								<th width=20% class="text-right"style="background-color: #7643ea;">제목</th>
								<td width=80%><input type="text" name="subject" size=50
									required></td>
							</tr>
							<tr>
								<th width=20% class="text-right"style="background-color: #7643ea;">내용</th>
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
