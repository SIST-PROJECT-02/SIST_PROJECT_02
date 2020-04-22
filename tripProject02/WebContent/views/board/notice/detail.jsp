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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- Favicon -->
<link rel="icon" href="../css/img/core-img/favicon.ico">

<!-- Core Stylesheet -->
<link href="../css/style.css" rel="stylesheet">

<!-- Responsive CSS -->
<link href="../css/css/responsive/responsive.css" rel="stylesheet">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('.nr').click(function(){
		var content=$('#nreply').val();
	$.ajax({
		type:'post',
		url:'nrinsert_ok.do',
		data:{"content":content},
		success:function(res)
		{
			$('#').html(res);
		}
	});
  });
})	
</script>
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

						<table class="table" style="width: 60%; margin: 0px auto;">
							<tr class="danger">
								<th width="10%" class="text-center">작성자</th>
								<th width="50%" class="text-center">내용</th>
								<th width="20%" class="text-center">작성일</th>
							</tr>
							<c:forEach var="vo" items="${nrlist }">
								<tr>
									<td width="10%" class="text-center" id="nrname"></td>
									<td width="50%" class="text-center" id="nrcontent"></td>
									<td width="20%" class="text-center" id="regdate"></td>
									</td>
								</tr>
							</c:forEach>
						</table>
						<table class="table" style="width: 60%; margin: 0px auto;">
							<tr>
								<th width=20% class="text-right success">내용</th>
								<td width=80%>
									<textarea rows="8" cols="50" id="nreply" required></textarea>
								</td>
								<td class="text-center"><span class="btn btn-md btn-danger nr">댓글등록</span>
								</td>
							</tr>
						</table>
						<table class="table" style="width: 60%; margin: 0px auto;">
							<tr>
								<td class="text-right" colspan="2"><c:if
										test="${sessionScope.admin==1 }">
										<a href="nupdate.do?no=${vo.no }"
											class="btn btn-md btn-success">수정</a>
										<a href="ndelete.do?no=${vo.no }" class="btn btn-md btn-info">삭제</a>
									</c:if> <a href="notice.do" class="btn btn-md btn-warning">목록</a></td>
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