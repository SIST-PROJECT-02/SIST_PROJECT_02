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
<link href="../css/css/responsive/responsive.css" rel="stylesheet">

<style type="text/css">
.row .table .success th {
	color: black;
}

#paging {
	margin: 0px auto;
	display: block;
	width: 300px;
}

.row>#notice {
	margin: 0px auto;
	border: 1px solid red;
	width: 60%;
	height: 50px;
}
</style>
</head>
<body>
	<div class="breadcumb-area bg-img bg-overlay"
		style="background-image: url(../../template/css/img/bg-img/jeju.png)"></div>
	<div class="wrapper row2">
		<div id="services" class="clear">
			<div class="text-center">
				<img src="../../board/images/notice.jpeg" style="width:900px;height:200px;">
			</div>
			<div class="row">
				<table class="table" style="width: 60%; margin: 0px auto;">
					<c:if test="${sessionScope.admin==1 }">
						<tr>
							<td><a href="notice_insert.do" class="btn btn-md btn-danger">새글</a>
							</td>
						</tr>
					</c:if>
				</table>
				<table class="table" style="width: 60%; margin: 0px auto;">
					<tr class="success">
						<th width="10%" class="text-center">번호</th>
						<th width="45%" class="text-center">제목</th>
						<th width="15%" class="text-center">작성자</th>
						<th width="20%" class="text-center">작성일</th>
						<th width="10%" class="text-center">조회수</th>
					</tr>
					<c:forEach var="vo" items="${nlist }" varStatus="status">
						<fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd"
							var="regdate" />
						<tr>
							<td width="10%" class="text-center">${vo.no }</td>
							<td width="45%"><c:if test="${today1 == regdate}">
									<img src="../../board/images/new.gif">
								</c:if> <c:if test="${vo.group_tab>0 }">
									<c:forEach var="i" begin="1" end="${vo.group_tab }" step="1">
	  							&nbsp;&nbsp;
	  						</c:forEach>
									<img src="../../board/images/icon_reply.gif">
								</c:if> <a href="ndetail.do?no=${vo.no }">${vo.subject }<c:if test="${countList[status.index] !=0 }">(${countList[status.index] })</c:if></a></td>
							<td width="15%" class="text-center">관리자</td>
							<td width="20%" class="text-center">${regdate }</td>
							<td width="10%" class="text-center">${vo.hit }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div id="paging">
				<a href="notice.do?page=${ncurpage>1?ncurpage-1:ncurpage }"
					class="btn btn-md btn-primary">이전</a> ${ncurpage } page /
				${ntotalpage } pages <a
					href="notice.do?page=${ncurpage<ntotalpage?ncurpage+1:ncurpage }"
					class="btn btn-md btn-primary">다음</a>
			</div>
		</div>
	</div>

</body>
	</html>
</h4>
