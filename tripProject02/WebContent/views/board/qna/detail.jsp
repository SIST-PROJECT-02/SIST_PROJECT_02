<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h4>
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../../board/css/board.css" rel="stylesheet">
<style type="text/css">
.white{
 background-color: white;
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
				<div class="row">
				
					<table class="table" style="width: 60%; margin: 0px auto;">
						<tr>
							<th class="text-center"  width=20% style="background-color: #7643ea;">번호</th>
							<td class="text-center white" width=30%>${vo.no }</td>
							<th class="text-center " width=20% style="background-color: #7643ea;">작성일</th>
							<td class="text-center white" width=30%><fmt:formatDate
									value="${vo.regdate }" pattern="yyyy-MM-dd" /></td>
						</tr>
						<tr style="background-color:white;">
							<th class="text-center" width=20% style="background-color: #7643ea;">이름</th>
							<td class="text-center white" width=30%>${vo.name }</td>
							<th class="text-center " width=20% style="background-color: #7643ea;">조회수</th>
							<td class="text-center white" width=30%>${vo.hit }</td>
						</tr>
						<tr>
							<th class="text-center" width=20% style="background-color: #7643ea;">제목</th>
							<td class="text-left" style="background-color:white;width:80%;colspan:3;text-overflow:ellipsis; overflow:hidden; white-space:nowrap;">${vo.subject }</td>
						</tr>
						<tr>
							<td class="text-left white" colspan="4" valign="top" height="200">${vo.content }</td>
						</tr>
						<tr>
							<td class="text-right" colspan="4">
							<c:if test="${sessionScope.admin == 1}">
							<a href="qna_reply.do?no=${vo.no }" class="btn btn-md btn-danger">답변</a></c:if>
								<c:if test="${sessionScope.email == vo.pwd}">
									<a href="qna_update.do?no=${vo.no }"
										class="btn btn-md btn-success">수정</a>
									<a href="qna_delete_ok.do?no=${vo.no }"
										class="btn btn-md btn-info">삭제</a>
								</c:if> <a href="qna.do" class="btn btn-md btn-warning">목록</a></td>
						</tr>
					</table>

				</div>
			</div>
		</div>
</body>
	</html>
</h4>