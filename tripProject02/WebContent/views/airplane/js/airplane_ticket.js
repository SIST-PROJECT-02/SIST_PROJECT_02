$(function() {
	 
	$(document).ajaxStart(function(e) {

		window.ajaxCheck = 1;

	});

	$(document).ajaxStop(function(e) { 

		window.ajaxCheck = null; 

	});
	
	
	$('.air_info').off('click').on('click',function() {
		if( window.ajaxCheck == 1 ) return false;
		
		var airline=$(this).find('#airline').text();
		var airimg=$(this).find('.airport_img').attr('data-airimg');
		var start_airport=$(this).find('#start_airport').text();
		var start_hour=$(this).find('#start_hour').text();
		var end_airport=$(this).find('#end_airport').text();
		var end_hour=$(this).find('#end_hour').text();
		var total_time=$(this).find('#total_time').text();
		var seattype=$(this).find('#seattype').text();
		// 왕복에서 돌아가기 데이터를 찾기 위한 데이터들
		var airway=$(this).attr('data-airway');
		var start_airport_hidden=$(this).attr('data-start-airport');
		var end_airport_hidden=$(this).attr('data-end-airport');
		var start_time_hidden=$(this).attr('data-start-time');
		var end_time_hidden=$(this).attr('data-end-time');
		var inwon=$(this).attr('data-inwon');
		
		var plane_id=$(this).attr('data-plane-id');
		var seattype=$(this).attr('data-seattype');
		var type=$(this).attr('data-type');
		
		var start_airport_str=start_airport_hidden.substring(0,2);
		var end_airport_str=end_airport_hidden.substring(0,2);
		var seatname="";
		
		if(seattype=='0')
		{
			seatname="일등석";
		}
		else if(seattype=='1')
		{
			seatname="이등석";
		}
		else
		{
			seatname="일반석";
		}
		
		
		if(airway=='편도')
		{
			$('#ticket_view').html(
					'<div class="air_ticket" data-start-airport="'+start_airport+'"data-end-airport="'+end_airport+'" data-airline="'+airline+'"'
					+ 'data-start-time="'+start_time_hidden+'" data-end-time="'+end_time_hidden+'" data-airway="'+airway+'"'
					+ 'data-total-time="'+total_time+'" data-start-hour="'+start_hour+'" data-end-hour="'+end_hour+'" data-seattype="'+seattype+'" data-inwon="'+inwon+'"' 
					+ ' data-plane-id="'+plane_id+'" >'
					+ '<div class="air_title">'
					+ '<h3 class="ticket_title"><b>가는날</b> 항공편 &nbsp;' 
					+ '<span style="font-size: 14px; color:#999; vertical-align: top;">'+start_time_hidden+' | '+start_airport_str+'에서 '+end_airport_str+'가는 항공편</span>'
					+ '</h3>'
					+ '</div>'
					+ '<div class="ticket_delete_btn">'
					+ '<input class="btn btn-xs btn-danger deleteBtn" value="x">'
					+ '</div>'
					+ '<div class="airport text-center">'
					+ '<img src="../../airplane/img/'+airimg+'" width="30px" height="30px">'
					+ '<div id="airline" class="bottom"> <span>'+airline+'</span></div>'
					+ '</div>'
					+ '<div class="airplane_info">'
					+ '<div class="start_info">'
					+ '<span class="airport_ticket_title">'+start_airport_str+'</span><br>'
					+ '<img src="../../airplane/img/start_spot.png"><br>'
					+ '<div class="airport_ticket_time">'
					+ '<span>'+start_hour+'</span>'
					+ '</div>'
					+ '</div>'
					+ '<div class="line"></div>'
					+ '<div class="total_time_seat">'
					+ '<span style="font-size: 15px;">'+total_time+' '+seatname+'</span>'
					+ '</div>'
					+ '<div class="end_info">'
					+ '<span class="airport_ticket_title">'+end_airport_str+'</span><br>'
					+ '<img src="../../airplane/img/end_spot.png"><br>'
					+ '<div class="airport_ticket_time">'
					+ '<span>'+end_hour+'</span>'
					+ '</div>'
					+ '</div>'
					+ '</div>'
					+ '<div class="airplane_reservation_btn text-center">'
					+ '<input id="reserveBtn" type="button" class="btn btn-lg btn-primary reserveBtn" value="예매하기">'
					+ '</div>'
					+ '</div>'
					+ '</div>');
			$('.container_air').hide();
			$('.moreInfoBtn').hide();
		}
		else if(airway=='왕복')
		{
			if(type=='1')
			{
				$.ajax({
					type:'POST',
					url:'../../airplane/airplaneList_ok.do',
					async: true,
					data:{"start_airport":end_airport_hidden,
						  "end_airport":start_airport_hidden,
						  "end_time":end_time_hidden,
						  "airway":airway,
						  "type":type
					},
					success:function(res)
					{
						$('#air-search').html(res);
						$('#ticket_view').append(
								'<div class="air_ticket" data-start-airport="'+start_airport+'"data-end-airport="'+end_airport+'" data-airline="'+airline+'"'
								+ 'data-start-time="'+start_time_hidden+'" data-end-time="'+end_time_hidden+'" data-airway="'+airway+'"'
								+ 'data-total-time="'+total_time+'" data-start-hour="'+start_hour+'" data-end-hour="'+end_hour+'" data-seattype="'+seattype+'" data-inwon="'+inwon+'"'
								+ 'data-plane-id="'+plane_id+'" >'
								+ '<div class="air_title">'
								+ '<h3 class="ticket_title"><b>가는날</b> 항공편  &nbsp;'
								+ '<span style="font-size: 14px; color:#999; vertical-align: top;">'+start_time_hidden+' | '+start_airport_str+'에서 '+end_airport_str+'가는 항공편</span>'
								+ '</h3>'
								+ '</div>'
								+ '<div class="ticket_delete_btn">'
								+ '<input class="btn btn-xs btn-danger deleteBtn" value="x">'
								+ '</div>'
								+ '<div class="airport text-center">'
								+ '<img src="../../airplane/img/'+airimg+'" width="30px" height="30px">'
								+ '<div id="airline" class="bottom"><span>'+airline+'</span></div>'
								+ '</div>'
								+'<div class="airplane_info">'
								+ '<div class="start_info">'
								+ '<span class="airport_ticket_title">'+start_airport_str+'</span><br>'
								+ '<img src="../../airplane/img/start_spot.png"><br>'
								+ '<div class="airport_ticket_time">'
								+ '<span>'+start_hour+'</span>'
								+ '</div>'
								+ '</div>'
								+ '<div class="line"></div>'
								+ '<div class="total_time_seat">'
								+ '<span style="font-size: 15px;">'+total_time+' '+seatname+'</span>'
								+ '</div>'
								+ '<div class="end_info">'
								+ '<span class="airport_ticket_title">'+end_airport_str+'</span><br>'
								+ '<img src="../../airplane/img/end_spot.png"><br>'
								+ '<div class="airport_ticket_time">'
								+ '<span>'+end_hour+'</span>'
								+ '</div>'
								+ '</div>'
								+ '</div>'
								+ '<div class="airplane_reservation_btn">'
								+ '</div>'
								+ '</div>'
								+ '</div>');
						
					},
					error:function(e)
					{
						alert(e);
					}
				})
				
				
			}
			
			else if(type=='2')
			{
				$('#ticket_view').append(
						'<div class="air_ticket2" data-start-airport2="'+start_airport+'"data-end-airport2="'+end_airport+'" data-airline2="'+airline+'"'
						+ 'data-start-time2="'+end_time_hidden+'" data-airway2="'+airway+'"'
						+ 'data-seattype2="'+seattype+'" data-inwon="'+inwon+'"'
						+ ' data-plane-id2="'+plane_id+'">'
						+ '<div class="air_title">'
						+ '<h3 class="ticket_title"><b>오는날</b> 항공편  &nbsp;'
						+ '<span style="font-size: 14px; color:#999; vertical-align: top;">'+end_time_hidden+' | '+start_airport_str+'에서 '+end_airport_str+'가는 항공편</span>'
						+ '</h3>'
						+ '</div>'
						+ '<div class="ticket_delete_btn">'
						+ '<input class="btn btn-xs btn-danger deleteBtn" value="x">'
						+ '</div>'
						+ '<div class="airport text-center">'
						+ '<img src="../../airplane/img/'+airimg+'" width="30px" height="30px">'
						+ '<div id="airline" class="bottom"><span>'+airline+'</span></div>'
						+ '</div>'	
						+'<div class="airplane_info">'
						+ '<div class="start_info">'
						+ '<span class="airport_ticket_title">'+start_airport_str+'</span><br>'
						+ '<img src="../../airplane/img/start_spot.png"><br>'
						+ '<div class="airport_ticket_time">'
						+ '<span>'+start_hour+'</span>'
						+ '</div>'
						+ '</div>'
						+ '<div class="line"></div>'
						+ '<div class="total_time_seat">'
						+ '<span style="font-size: 15px;">'+total_time+' '+seatname+'</span>'
						+ '</div>'
						+ '<div class="end_info">'
						+ '<span class="airport_ticket_title">'+end_airport_str+'</span><br>'
						+ '<img src="../../airplane/img/end_spot.png"><br>'
						+ '<div class="airport_ticket_time">'
						+ '<span>'+end_hour+'</span>'
						+ '</div>'
						+ '</div>'
						+ '</div>'
						+ '<div class="airplane_reservation_btn text-center">'
						+ '<input id="reserveBtn" type="button" class="btn btn-lg btn-primary reserveBtn" value="예매하기">'
						+ '</div>'
						+ '</div>');
				$('.container_air').hide();
				$('.moreInfoBtn').hide();
				type='0';
			}
			
		}
		
		
	})
	
	
})