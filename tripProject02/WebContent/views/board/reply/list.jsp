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
	width: 60%;
	height: 50px;
}
.notice{
	background-color:#fffee4;
}

</style>
</head>
<body>
	<div class="breadcumb-area bg-img bg-overlay"
		style="background-image: url(../../template/css/img/bg-img/jeju.png)"></div>
	<div class="wrapper row2">
		<div id="services" class="clear">
			<div class="text-center">
				<img src="../../board/images/QnA.png">
			</div>
			<div class="row">

				<table class="table" id="notice">

				</table>
				<table class="table" style="width: 60%; margin: 0px auto;">
					<tr>
						<td><a href="insert.do" class="btn btn-md btn-danger">새글</a>
						</td>
					</tr>
				</table>
				<table class="table" style="width: 60%; margin: 0px auto;">
					<tr class="danger">
						<th width="10%" class="text-center">번호</th>
						<th width="45%" class="text-center">제목</th>
						<th width="15%" class="text-center">작성자</th>
						<th width="20%" class="text-center">작성일</th>
						<th width="10%" class="text-center">조회수</th>
					</tr>
					<c:forEach var="vo" items="${nlist }">
						<fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd"
							var="regdate" />
						<tr class="notice">
							<td width="10%" class="text-center"><img
								src="../../board/images/bell.png" /></td>
							<td width="45%" class="text-center"><c:if
									test="${today1 == regdate}">
									<img src="../../board/images/new.gif">
								</c:if> <a href="ndetail.do?no=${vo.no }">${vo.subject }</a></td>
							<td width="15%" class="text-center">관리자</td>
							<td width="20%" class="text-center">${regdate }<!--<fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd"/>-->
							</td>
							<td width="10%" class="text-center">${vo.hit }</td>
						</tr>
					</c:forEach>
					<tr class="success">
					</tr>
					<c:forEach var="vo" items="${list }">
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
<<<<<<< HEAD
									<img src="../../board/images/icon_reply.gif">
								</c:if> <a href="detail.do?no=${vo.no }">${vo.subject }</a></td>
							<td width="15%" class="text-center">${vo.name }</td>
							<td width="20%" class="text-center">${regdate }<!--<fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd"/>-->
							</td>
							<td width="10%" class="text-center">${vo.hit }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div id="paging">
				<a href="qna.do?page=${curpage>1?curpage-1:curpage }"
					class="btn btn-md btn-primary">이전</a> ${curpage } page /
				${totalpage } pages <a
					href="qna.do?page=${curpage<totalpage?curpage+1:curpage }"
					class="btn btn-md btn-primary">다음</a>
			</div>
		</div>
	</div>
=======
	  						<img src="icon_reply.gif">
	  					</c:if>
	  					<a href="detail.do?no=${vo.no }">${vo.subject }</a>
	  				</td>
	  				<td width="15%" class="text-center">${vo.name }</td>
	  				<td width="20%" class="text-center">
						<fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd"/>
					</td>
	  				<td width="10%" class="text-center">${vo.hit }</td>
  				</tr>
  			</c:forEach>
  		</table>
  	</div>
  	<div id="paging">
  		<a href="qna.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-md btn-primary">이전</a>
  		${curpage } page / ${totalpage } pages
  		<a href="qna.do?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-md btn-primary">다음</a>
  	</div>
  </div>
</div>
>>>>>>> b6e4fa33b9a83ac70b406cda243605983a3666c7

</body>
	</html>
</h4>
