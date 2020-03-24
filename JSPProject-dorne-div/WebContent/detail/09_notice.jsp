<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- ***** Breadcumb Area Start ***** -->
    <div class="breadcumb-area bg-img bg-overlay" style="background-image: url(../css/img/bg-img/jeju.png)"></div>
    <!-- ***** Breadcumb Area End ***** -->
	<section class="dorne-listing-destinations-area section-padding-100-50">
	<div class="container">
		<div class="row">
			<div class="col-12">
				<div class="section-heading dark text-center">
				<span></span>
                <h4>공지사항</h4>
                <p>Editor’s pick</p>
                </div>
            </div>
		</div>
	</div>
	<!-- board_side_left는 ../css/bootstrap/bootstrap.min.css안에 있다. -->     
    <div class="board_side_left" >
    	<div class="section-heading dark" style="border: 1px solid red">
			<th><h4>게시판</h4></th><br>
	        <td>공지사항</td><br>
	        <td>자유게시판</td><br>
	        <td>후기&팁</td><br>
	        <td>Q&A</td>
        </div>
	</div>
   	<div class="container" style="border: 1px solid blue">
		<table class="dorne-table" style="border: 1px solid blue;">
			<tr>
				<td class="text-right" id="dorne-board-newwriting">
				<a href="#">새글쓰기</a>
				</td>
			</tr>
		</table>
		<br/>
		<table class="dorne-table">
			<tr style="border: 1px solid black;">
				<th width="10%" class="text-center">번호</th>
				<th width="45%" class="text-center">제목</th>
				<th width="15%" class="text-center">이름</th>
				<th width="20%" class="text-center">작성일</th>
				<th width="10%" class="text-center">조회수</th>
			</tr>
<!-- 		<tr>
				<td>&nbsp;</td>	
			</tr>
 -->
			<tr style="border: 1px solid orange;">
				<td width="10%" class="text-center">1</td>
				<td width="45%" class="text-center">여행복행입니다</td>
				<td width="15%" class="text-center">관리자</td>
				<td width="20%" class="text-center">2020-03-23</td>
				<td width="10%" class="text-center">5</td>
			</tr>
		</table>
	</div>
	</section>
</body>
</html>