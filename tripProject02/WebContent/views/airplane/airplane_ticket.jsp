<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/air_ticket.css?ver8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<div class="air_ticket text-center">
		<div class="air_title">
			<h3 class="ticket_title">
				<b>가는날</b> 항공편 <span style="font-size: 14px; color:#999; vertical-align: top;">2020.04.28 | 김포에서 제주 가는 항공편</span>
			</h3>
		</div>
		<div class="ticket_delete_btn">
			<input type="button" class="btn btn-xs btn-danger" value="x">
			
		</div>
		<div class="airport text-center">
			<img src="img/jeju.png" width="30px" height="30px">
			<div id="airline" class="bottom">
				<span>제주항공</span>
			</div>
		</div>
		<div class="airplane_info">
			<div class="start_info">
				<span class="airport_ticket_title">인천</span><br>
				<img src="img/start_spot.png"><br>
				<div class="airport_ticket_time">
					<span>6:00</span>
				</div>
			</div>
			
			<div class="line"></div>
			<div class="total_time_seat">
				<span style="font-size: 15px;">1시간 05분 일반석</span>
			</div>
			<div class="end_info">
				<span class="airport_ticket_title">제주</span><br>
				<img src="img/start_spot.png"><br>
				<div class="airport_ticket_time">
					<span>7:05</span>
				</div>
			</div>
			
		</div>
		<div class="airplane_reservation_btn">
			<input type="button" class="btn btn-sm btn-primary" value="예매하기">
		</div>
	</div>
</body>
</html>