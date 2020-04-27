$(function(){
	$('#reserveBtn').on('click',function(){
		var airway=$(this).find('.air_ticket').attr('data-airway');
		
		/*
	'<div class="air_ticket" data-start-airport="'+start_airport_str+'"data-end-airport="'+end_airport_str+'"'
					+ 'data-start-time="'+start_time_hidden+'" data-end-time="'+end_time_hidden+'" data-airway="'+airway+'"'
					+ 'data-total-time="'+total_time+'" data-start-hour="'+start_hour+'" data-end-hour="'+end_hour+'" data-seattype="'+seattype+'" data-airimg="'+airimg+'">'
		 */
		if(airway=='편도')
		{
			var start_airport=$(this).parents('#ticket_view').attr(' data-start-airport');
			var end_airport=$(this).parents('#ticket_view').attr(' data-end-airport');
			var start_time=$(this).parents('#ticket_view').attr('data-start-time');
			var end_time=$(this).parents('#ticket_view').attr('data-end-time');
			var total_time=$(this).parents('#ticket_view').attr('data-total-time');
			var start_hour=$(this).parents('#ticket_view').attr('data-start-hour');
			var end_hour=$(this).parents('#ticket_view').attr('data-end-hour');
			var seattype=$(this).parents('#ticket_view').attr('data-seattype');
			var airline=$(this).parents('#ticket_view').attr('data-airline');
			
			$.ajax({
				type:'POST',
				url:'',
				data:{"start_airport":start_airport,
					  "end_airport":end_airport,
					  "start_time":start_time,
					  "end_time":end_time,
					  "total_time":total_time,
					  "start_hour":start_hour,
					  "end_hour":end_hour,
					  "seattype":seattype,
					  "airline":airline
				}
					
			})
		}
		
		else if(airway=='왕복')
		{
			var start_airport=$(this).parents('#ticket_view').attr(' data-start-airport');
			var end_airport=$(this).parents('#ticket_view').attr(' data-end-airport');
			var start_time=$(this).parents('#ticket_view').attr('data-start-time');
			var end_time=$(this).parents('#ticket_view').attr('data-end-time');
			var total_time=$(this).parents('#ticket_view').attr('data-total-time');
			var start_hour=$(this).parents('#ticket_view').attr('data-start-hour');
			var end_hour=$(this).parents('#ticket_view').attr('data-end-hour');
			var seattype=$(this).parents('#ticket_view').attr('data-seattype');
			var airline=$(this).parents('#ticket_view').attr('data-airline');
			var start_airport2=$(this).parents('#ticket_view').attr(' data-start-airport2');
			var end_airport2=$(this).parents('#ticket_view').attr(' data-end-airport2');
			var start_time2=$(this).parents('#ticket_view').attr('data-start-time2');
			var end_time2=$(this).parents('#ticket_view').attr('data-end-time2');
			var total_time2=$(this).parents('#ticket_view').attr('data-total-time2');
			var start_hour2=$(this).parents('#ticket_view').attr('data-start-hour2');
			var end_hour2=$(this).parents('#ticket_view').attr('data-end-hour2');
			var seattype2=$(this).parents('#ticket_view').attr('data-seattype2');
			var airline2=$(this).parents('#ticket_view').attr('data-airline2');
			
			$.ajax({
				type:'POST',
				url:'',
				data:{"start_airport":start_airport,
					  "end_airport":end_airport,
					  "start_time":start_time,
					  "end_time":end_time,
					  "total_time":total_time,
					  "start_hour":start_hour,
					  "end_hour":end_hour,
					  "seattype":seattype,
					  "airline":airline,
					  "start_airport2":start_airport2,
					  "end_airport2":end_airport2,
					  "start_time2":start_time2,
					  "end_time2":end_time2,
					  "total_time2":total_time2,
					  "start_hour2":start_hour2,
					  "end_hour2":end_hour2,
					  "seattype2":seattype2,
					  "airline2":airline2
				}
					
			})
		}
	})
})