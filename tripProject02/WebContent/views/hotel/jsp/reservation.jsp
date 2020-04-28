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

		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>

	</ul>
	</section>

	<script src="./../../hotel/js/reservation/reservation.js"></script>
	<script src="./../../hotel/js/ajax/ajax.js"></script>
	<script type="text/template" id="reservation-calender">
		<table>
`

			<tr>
			<c:forEach var="item" items="${weekdayList}">
				<th><c:out value="${item }"></c:out></th>
			</c:forEach>
			</tr>
			
			{calendarContent}
		</table>
	</script>
</body>
</html>