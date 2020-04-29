<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="today" class="java.util.Date" />
<fmt:formatDate value="${today}" pattern="yyyy-MM-dd" var="today1" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h4>
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../../board/css/board.css" rel="stylesheet">
<style type="text/css">
.blist {
	border: 1px grey solid;
	width: 150px;
	height: 800px;
	margin-left: 100px;
	margin-right: 40px;
}

.boardtable {
	border: 0px blue solid;
	margin-left: 0px;
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
			<img src="../../board/images/free.png" style="text-align:center;width:100%; height:120px;"/></div>
			<div class="row">
				<div class="blist">
					<h1>커뮤니티</h1>
					<ul>
						<li><a href="notice.do"><h3>공지사항</h3></a></li>
						<li><a href="free.do"><h3>자유게시판</h3></a></li>
						<li><a href="qna.do"><h3>QnA</h3></a></li>
					</ul>
				</div>
				<div class="boardtable">
					<table class="table" style="width: 90%; margin: 0px auto;">
						<c:if test="${sessionScope.admin==1 }">
							<tr>
								<td><a href="free_insert.do" class="btn btn-md btn-danger">새글</a>
								</td>
							</tr>
						</c:if>
					</table>
					<table class="table"
						style="width: 90%; margin: 0px auto; table-layout: fixed">
						<tr style="background-color: #7643ea">
							<th style="width: 50px" class="text-center">번호</th>
							<th style="width: 150px" class="text-center">제목</th>
							<th style="width: 80px" class="text-center">작성자</th>
							<th style="width: 100px" class="text-center">작성일</th>
							<th style="width: 50px" class="text-center">조회수</th>
						</tr>
						<c:forEach var="vo" items="${nlist }" varStatus="status">
							<fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd"
								var="regdate" />
							<tr class="notice2">
								<td style="width: 50px;" class="text-center">${vo.no }</td>
								<td
									style="width: 150px; text-overflow: ellipsis; overflow: hidden; white-space: nowrap;"><c:if
										test="${today1 == regdate}">
										<sup><img src="../../board/images/new.gif"></sup>
									</c:if> <c:if test="${vo.group_tab>0 }">
										<c:forEach var="i" begin="1" end="${vo.group_tab }" step="1">
	  							&nbsp;&nbsp;
	  						</c:forEach>
										<img src="../../board/images/icon_reply.gif">
									</c:if> <a href="fdetail.do?no=${vo.no }">${vo.subject }<c:if
											test="${countList[status.index] !=0 }">
											<em style="color: #7643ea">(${countList[status.index] })</em>
										</c:if></a></td>
								<td
									style="width: 80px; text-overflow: ellipsis; overflow: hidden"
									class="text-center">${name }</td>
								<td
									style="width: 100px; text-overflow: ellipsis; overflow: hidden"
									class="text-center">${regdate }</td>
								<td
									style="width: 50px; text-overflow: ellipsis; overflow: hidden"
									class="text-center">${vo.hit }</td>
							</tr>
						</c:forEach>
					</table>
					<div style="text-align: center">
						<a href="free.do?npage=${ncurpage>1?ncurpage-1:ncurpage }"
							class="btn btn-md btn-primary">이전</a> ${ncurpage } page /
						${ntotalpage } pages <a
							href="free.do?npage=${ncurpage<ntotalpage?ncurpage+1:ncurpage }"
							class="btn btn-md btn-primary">다음</a>
					</div>
				</div>
			</div>

		</div>
	</div>
	<!-- </section> -->
</body>
	</html>
</h4>
