<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="today" class="java.util.Date" />
<fmt:formatDate value="${today}" pattern="yyyy-MM-dd" var="today1" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
.row .table .success th {
	color: black;
}


.notice {
	background-color: #fffee4;
}
</style>
</head>
<body>
	<div class="breadcumb-area bg-img bg-overlay"
		style="background-image: url(../../template/css/img/bg-img/jeju.png)"></div>
	<div class="container">
		<div id="services" class="clear">
			<div class="text-center">
				<img src="../../board/images/QnA.png"
					style="width: 900px; height: 200px;">
			</div>
			<div class="row">
				<table class="table" style="width:1000px;">
					<tr>
						<c:if test="${sessionScope.email!=null }">
							<td><a href="qnainsert.do" class="btn btn-md btn-danger">새글</a>
							</td>
						</c:if>
					</tr>
				</table>
				<table class="table" style="width:1000px">
					<!--  style="width: 60%;  margin: 0px auto;"-->
					<tr class="danger">
						<th style="width:50px" class="text-center">번호</th>
						<th style="width:150px" class="text-center">제목</th>
						<th style="width:80px" class="text-center">작성자</th>
						<th  style="width:100px" class="text-center">작성일</th>
						<th style="width:50px" class="text-center">조회수</th>
					</tr>
					<c:forEach var="vo" items="${nlist }" varStatus="status">
						<fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd"
							var="regdate" />

						<tr class="notice">
							<td   style="width:50px" class="text-center"><img
								src="../../board/images/bell.png" /></td>
							<td  style="width:150px" class="text-center"><c:if
									test="${vo.group_tab>0 }">
									<c:forEach var="i" begin="1" end="${vo.group_tab }" step="1">
	  							&nbsp;&nbsp;
	  						</c:forEach>
									<img src="../../board/images/icon_reply.gif">
								</c:if> <c:if test="${today1 == regdate}">
									<img src="../../board/images/new.gif">
								</c:if> <a href="ndetail.do?no=${vo.no }">${vo.subject }<c:if
										test="${countList[status.index] !=0 }">(${countList[status.index] })</c:if></a></td>
							<td  style="width:80px" class="text-center">관리자</td>
							<td  style="width:100px" class="text-center">${regdate }</td>
							<td  style="width:50px" class="text-center">${vo.hit }</td>
						</tr>
					</c:forEach>
					<c:forEach var="vo" items="${list }">
						<fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd"
							var="regdate" />
						<tr>
							<td  style="width:50px" class="text-center">${vo.no }</td>
							<td  style="width:150px"><c:if test="${vo.group_tab>0 }">
									<c:forEach var="i" begin="1" end="${vo.group_tab }" step="1">
	  							&nbsp;&nbsp;
	  						</c:forEach>
									<img src="../../board/images/icon_reply.gif">
								</c:if> <a href="qna_detail.do?no=${vo.no }">${vo.subject }</a>
							<c:if test="${today1 == regdate}">
									<img src="../../board/images/new.gif">
								</c:if></td>
							<td  style="width:80px" class="text-center">${vo.name }</td>
							<td  style="width:100px"class="text-center">${regdate }</td>
							<td  style="width:50px" class="text-center">${vo.hit }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div style="text-align:center">
				<a href="qna.do?page=${curpage>1?curpage-1:curpage }"
					class="btn btn-md btn-primary">이전</a> ${curpage } page /
				${totalpage } pages <a
					href="qna.do?page=${curpage<totalpage?curpage+1:curpage }"
					class="btn btn-md btn-primary">다음</a>
			</div>
		</div>
	</div>

</body>
</html>

