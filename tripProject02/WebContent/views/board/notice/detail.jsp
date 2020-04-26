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
var u=0;
var i=0;
$(function(){
	$('.upBtn').click(function(){
		$('.reply_update').hide();
		$('.reply_insert').hide();
		var no=$(this).attr("data-no");
		if(u==0)
		{
			$('#m'+no).show();
			u=1;
		}
		else
		{
			$('#m'+no).hide();
			u=0;
		}
	});
	
	$('.inBtn').click(function(){
		$('.reply_update').hide();
		$('.reply_insert').hide();
		var no=$(this).attr("data-no");
		if(i==0)
		{
			$('#i'+no).show();
			i=1;
		}
		else
		{
			$('#i'+no).hide();
			i=0;
		}
	});
});
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
						</table>
						</div>
						</div>
			<!-- 공지댓글 시작 -->
			<div style="height:20px"></div>		
     <table class="table" style="width: 60%; margin: 0px auto;">
				<c:forEach var="rvo" items="${nlist }">
					<tr>
						<td class="text-left"><c:if test="${rvo.group_tab>0 }">
								<c:forEach var="i" begin="1" end="${rvo.group_tab }">
               &nbsp;&nbsp;
             </c:forEach>
								<img src="../images/icon_reply.gif" />
							</c:if> ${rvo.name }&nbsp;<span style="color: #999">(${rvo.dbday })</span>
						</td>
						<td class="text-right"><c:if
								test="${rvo.msg!='관리자가 삭제한 댓글입니다' }">
								<c:if test="${sessionScope.email==rvo.email }">
									<span class="btn btn-xs btn-primary upBtn" data-no="${rvo.no }">수정</span>
									<a
										href="../freeboard/reply_delete.do?no=${rvo.no }&bno=${vo.no}"
										class="btn btn-xs btn-danger">삭제</a>
								</c:if>
								<span class="btn btn-xs btn-success inBtn" data-no=${rvo.no }>댓글</span>
							</c:if></td>
					</tr>
					<tr>
						<td colspan="2" class="text-left" valign="top">f <pre
								style="white-space: pre-wrap; border: none">${rvo.msg }</pre>
						</td>
					</tr>
					<tr id="m${rvo.no }" style="display: none" class="reply_update">
						<td colspan="2">
							<form method="post" action="../freeboard/reply_update.do">
								<input type=hidden name=bno value="${vo.no }"> <input
									type=hidden name=no value="${rvo.no }">
								<textarea rows="5" cols="125" name="msg" style="float: left">${rvo.msg }</textarea>
								<input type="submit" class="btn btn-sm btn-primary"
									style="height: 100px; float: left" value="수정하기">
							</form>
						</td>
					</tr>

					<tr id="i${rvo.no }" style="display: none" class="reply_insert">
						<td colspan="2">
							<form method="post" action="nreply_ok.do">
								<input type=hidden name=bno value="${vo.no }"> <input
									type=hidden name=pno value="${rvo.no }">
								<textarea rows="5" cols="125" name="msg" style="float: left"></textarea>
								<input type="submit" class="btn btn-sm btn-primary"
									style="height: 100px; float: left" value="댓글쓰기">
							</form>
						</td>
					</tr>
				</c:forEach>
				<tr>
           <td class="text-center" colspan="2">
            <a href="#" class="btn btn-xs btn-danger">이전</a>
             ${curpage } page / ${totalpage } pages
            <a href="#" class="btn btn-xs btn-danger">다음</a>
           </td>
         </tr>
     </table>
     <table class="table" style="width: 60%; margin: 0px auto;">
       <tr>
         <td>
           <form method="post" action="noticereply_insert.do">
             <input type=hidden name=bno value="${vo.no }">
             <textarea rows="5" cols="120" name="msg" style="float: left"></textarea>
             <input type="submit" class="btn btn-sm btn-primary" style="height: 100px;float: left" value="댓글쓰기">
           </form>
         </td>
       </tr>
     </table>
    </div>
						<!-- 공지댓글 끝 -->
						<table class="table" style="width: 60%; margin: 0px auto;">
							<tr>
								<td class="text-right" colspan="2"><c:if
										test="${sessionScope.admin=='y' }">
										<a href="nupdate.do?no=${vo.no }"
											class="btn btn-md btn-success">수정</a>
										<a href="ndelete.do?no=${vo.no }" class="btn btn-md btn-info">삭제</a>
									</c:if> <a href="notice.do" class="btn btn-md btn-warning">목록</a></td>
							</tr>
						</table>
						</div>
					
	</body>
</html>
</h4>