<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="air_ticket2" data-start-airport2="start_airport"
		data-end-airport2="end_airport" data-airline2="airline"
		data-start-time2="start_time_hidden" data-end-time2="end_time_hidden"
		data-airway2="airway" data-total-time2="total_time"
		data-start-hour2="start_hour" data-end-hour2="end_hour"
		data-seattype2="seattype" data-inwon="inwon" data-plane-id="plane_id">
		<div class="air_title">
			<h3 class="ticket_title">
				<b>오는날</b> 항공편 &nbsp; <span style="font-size: 14px; color: #999; vertical-align: top;">start_airport_hidden
					| start_airport_str에서 end_airport_str가는 항공편</span>
			</h3>
		</div>
		<div class="ticket_delete_btn">
			<input type="button" class="btn btn-xs btn-danger" value="x">
		</div>
		<div class="airport text-center">
			<img src="../../airplane/img/airimg" width="30px" height="30px">
			<div id="airline" class="bottom">
				<span>airline</span>
			</div>
		</div>
		<div class="airplane_info">
			<div class="start_info">
				<span class="airport_ticket_title">start_airport_str</span><br>
				<img src="../../airplane/img/start_spot.png"><br>
				<div class="airport_ticket_time">
					<span>start_hour</span>
				</div>
			</div>
			<div class="line"></div>
			<div class="total_time_seat">
				<span style="font-size: 15px;">total_time seattype</span>
			</div>
			<div class="end_info">
				<span class="airport_ticket_title">end_airport_str</span><br> <img
					src="../../airplane/img/end_spot.png"><br>
				<div class="airport_ticket_time">
					<span>end_hour</span>
				</div>
			</div>
		</div>
		<div class="airplane_reservation_btn text-center">
			<input id="reserveBtn" type="button"
				class="btn btn-lg btn-primary reserveBtn" value="예매하기">
		</div>
	</div>

</body>
</html>