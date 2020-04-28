<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./../../hotel/css/reservation.css">
</head>
<body>
	<div class="breadcumb-area bg-img bg-overlay"
		style="background-image: url(../css/img/bg-img/jeju.png)"></div>
	<section class="reservation-wrap">
	<ul class="reservation-tab-UI">
		<li name="0">체크인</li>

		<li name="1">체크아웃</li>

		<li name="2">인원선택</li>

	</ul>
	<c:set var="weekdayList">일,월,화,수,목,금,토</c:set>
	<div class="reservation-input"></div>
	<ul class="reservation-output">

		<li><img src="#"/></li>
		<li></li>
		<li>체크인</li>
		<li>체크아웃</li>
		<li>인원</li>
		<li>총 가격 견적</li>

	</ul>
	<div class="reservation-final-btn">예매하기</div>
	</section>

	<script src="./../../hotel/js/configuration/reservationConfiguration.js"></script>
	<script src="./../../hotel/js/reservation/reservation.js"></script>
	<script src="./../../hotel/js/ajax/ajax.js"></script>
	<script type="text/template" id="reservation-calender">
		<select class="year">
  			<option value="2020">2020년</option>
  			<option value="2021">2021년</option>
  			<option value="2022">2022년</option>
  			<option value="2023">2023년</option>
		</select>
		<select class="month">
  			<option value="1">1월</option>
  			<option value="2">2월</option>
  			<option value="3">3월</option>
  			<option value="4">4월</option>
			<option value="5">5월</option>
  			<option value="6">6월</option>
  			<option value="7">7월</option>
  			<option value="8">8월</option>
			<option value="9">9월</option>
  			<option value="10">10월</option>
  			<option value="11">11월</option>
  			<option value="12">12월</option>
		</select>
		<table>
			<tr>
			<c:forEach var="item" items="${weekdayList}">
				<th><c:out value="${item }"></c:out></th>
			</c:forEach>
			</tr>
			
			{calendarContent}
		</table>
	</script>
	<script type="text/template" id="reservation-inwon">
		<select class="inwon">
			<option value="0">0명</option>
  			<option value="1">1명</option>
  			<option value="2">2명</option>
  			<option value="3">3명</option>
  			<option value="4">4명</option>
			<option value="5">5명</option>
  			<option value="6">6명</option>
  			<option value="7">7명</option>
  			<option value="8">8명</option>
			<option value="9">9명</option>
  			<option value="10">10명</option>
  			<option value="11">11명</option>
  			<option value="12">12명</option>
		</select>

	</script>
</body>
</html>