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
		
		var type=$(this).attr('data-type');
		
		console.log("type:"+type);
		/*console.log(airway);
		console.log(start_airport);
		console.log(start_hour);
		console.log(end_airport);
		console.log(end_hour);
		console.log(seattype);
		console.log(total_time);*/
		
		if(airway=='편도')
		{
			$('#ticket_view').html(
					'<div class="air_ticket" data-start-airport="'+start_airport+'"data-end-airport="'+end_airport+'"'
					+ 'data-start-time="'+start_time_hidden+'" data-end-time="'+end_time_hidden+'" data-airway="'+airway+'">'
					+ '<div class="air_title">'
					+ '<h3 class="ticket_title"><b>가는날</b> 항공편</h3>'
					+ '</div>'
					+ '<div class="ticket_delete_btn">'
					+ '<input type="button" class="btn btn-xs btn-danger" value="x">'
					+ '</div>'
					+ '<div class="airport text-center">'
					+ '<img src="../../airplane/img/'+airimg+'" width="30px" height="30px" data-airimg="'+airimg+'">'
					+'<div id="airline" class="bottom"><span>'+airline+'</span></div>'
					+ '</div>'	
					+'<div class="airplane_info">'
					+start_hour+end_hour+seattype+total_time+ start_airport+end_airport
					+'</div>'
					+'<div class="airplane_reservation_btn">'
					+'</div>'
					+'</div>');
			$('.container_air').hide();
			$('.moreInfoBtn').hide();
		}
		else if(airway=='왕복')
		{
			if(type=='1')
			{
			/*	console.log(start_airport_hidden);
				console.log(end_airport_hidden);
				console.log(end_time_hidden);
				console.log(airway);
				console.log("type :"+type);*/
				console.log(end_time_hidden);
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
						/*console.log("type:"+type);
						console.log("airway:"+airway);*/
						$('#air-search').html(res);
						$('#ticket_view').append(
								'<div class="air_ticket" data-start-airport="'+start_airport+'"data-end-airport="'+end_airport+'"'
								+ 'data-start-time="'+start_time_hidden+'" data-end-time="'+end_time_hidden+'" data-airway="'+airway+'">'
								+ '<div class="air_title">'
								+ '<h3 class="ticket_title"><b>가는날</b> 항공편</h3>'
								+ '</div>'
								+ '<div class="ticket_delete_btn">'
								+ '<input type="button" class="btn btn-xs btn-danger" value="x">'
								+ '</div>'
								+ '<div class="airport text-center">'
								+ '<img src="../../airplane/img/'+airimg+'" width="30px" height="30px" data-airimg="'+airimg+'">'
								+'<div id="airline" class="bottom"><span>'+airline+'</span></div>'
								+ '</div>'	
								+'<div class="airplane_info">'
								+start_hour+end_hour+seattype+total_time
								+'</div>'
								+'<div class="airplane_reservation_btn">'
								/*+'<input type="hidden" name="start_time_hideen" id="start_time_hideen" value="'+start_time_hidden+'">'
								+'<input type="hidden" name="end_time_hidden" id="end_time_hidden" value="'+end_time_hidden+'">'
								+'<input type="hidden" name="start_airport_hideen" id="start_airport_hideen" value="'+start_airport+'">'
								+'<input type="hidden" name="end_airport_hideen" id="end_airport_hidden" value="'+end_airport+'">'*/
								+'</div>'
								+'</div>');
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
						'<div class="air_ticket">'
						+ '<div class="air_title">'
						+ '<h3 class="ticket_title"><b>오는날</b> 항공편</h3>'
						+ '</div>'
						+ '<div class="ticket_delete_btn">'
						+ '<input type="button" class="btn btn-xs btn-danger" value="x">'
						+ '</div>'
						+ '<div class="airport text-center">'
						+ '<img src="../../airplane/img/'+airimg+'" width="30px" height="30px" data-airimg="'+airimg+'">'
						+'<div id="airline" class="bottom"><span>'+airline+'</span></div>'
						+ '</div>'	
						+'<div class="airplane_info">'
						+start_hour+end_hour+seattype+total_time
						+'</div>'
						+'<div class="airplane_reservation_btn text-center">'
						+'<form method="POST" action="#">'
						+'<input type="submit" class="btn btn-sm btn-primary" value="예매하기">'
						+'</form>'
						+'</div>'
						+'</div>');
				$('.container_air').hide();
				$('.moreInfoBtn').hide();
				type='0';
			}
			
		}
		
		
	})
	
	$(document).on('click','.ticket_delete_btn',function(){
		if( window.ajaxCheck == 1 ) return false;
		
		var index=$(this).parents('.air_ticket').index();
		var start_airport=$(this).parents('.air_ticket').attr('data-start-airport');
		var end_airport=$(this).parents('.air_ticket').attr('data-end-airport');
		var start_time=$(this).parents('.air_ticket').attr('data-start-time');
		var end_time=$(this).parents('.air_ticket').attr('data-end-time');
		var airway=$(this).parents('.air_ticket').attr('data-airway');
		
		console.log("index:" +index);
		console.log("start_airport:" +start_airport);
		console.log("end_airport:" +end_airport);
		console.log("start_time:" +start_time);
		console.log("end_time:" +end_time);
		
		if(index==0)
		{
			$.ajax({
				type:'POST',
				url:'../../airplane/airplaneList_ok.do',
				async: true,
				data:{"start_airport":start_airport,
					  "end_airport":end_airport,
					  "start_time":start_time,
					  "end_time":end_time,
					  "airway":airway,
					  "type":"0"
				},
				success:function(res)
				{
						$('#air-search').html(res);
					
				},
				error:function(e)
				{
					alert(e);
				}
				
			})
		}
		if(index==1)
		{
			$(this).parents('.air_ticket').remove();
			$('.container_air').show();
			$('.moreInfoBtn').last().show();
		}
	})
	
	
})