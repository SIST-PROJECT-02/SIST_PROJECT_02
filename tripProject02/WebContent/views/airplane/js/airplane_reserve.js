$(function(){
	
	$(document).on('click','#reserveBtn',function(){
		
		
		var airway=$(this).parents('#ticket_view').find('.air_ticket').attr('data-airway');
		if(airway=='편도')
		{
			var plane_id=$(this).parents('.air_ticket').attr('data-plane-id');
			var start_airport=$(this).parents('.air_ticket').attr('data-start-airport');
			var end_airport=$(this).parents('.air_ticket').attr('data-end-airport');
			var start_time=$(this).parents('.air_ticket').attr('data-start-time');
			var seattype=$(this).parents('.air_ticket').attr('data-seattype');
			var inwon=$(this).parents('.air_ticket').attr('data-inwon');
			
			console.log("편도:ok?");
			console.log("start_airport :" +start_airport);
			console.log("end_airport :"+ end_airport);
			console.log("start_time :"+start_time);
			console.log("seattype :"+seattype);
			console.log("inwon :"+inwon);
			
			$.ajax({
				type:'POST',
				url:'../../airplane/airplane_reserve_oneway_trip.do',
				data:{"start_airport":start_airport,
					  "end_airport":end_airport,
					  "start_time":start_time,
					  "seattype":seattype,
					  "inwon":inwon,
					  "plane_id":plane_id,
					  "airway":airway},
			    success:function(res)
			    {
			    	$(location).attr('href','../../template/main/member_reservation.do');
			    }
					
			})
		}
		
		else if(airway=='왕복')
		{
			var plane_id=$(this).parents('#ticket_view').find('.air_ticket').attr('data-plane-id');
			var start_airport=$(this).parents('#ticket_view').find('.air_ticket').attr('data-start-airport');
			var end_airport=$(this).parents('#ticket_view').find('.air_ticket').attr('data-end-airport');
			var start_time=$(this).parents('#ticket_view').find('.air_ticket').attr('data-start-time');
			var seattype=$(this).parents('#ticket_view').find('.air_ticket').attr('data-seattype');
			var inwon=$(this).parents('#ticket_view').find('.air_ticket').attr('data-inwon');
			
			var plane_id2=$(this).parents('.air_ticket2').attr('data-plane-id2');
			var start_airport2=$(this).parents('.air_ticket2').attr('data-start-airport2');
			var end_airport2=$(this).parents('.air_ticket2').attr('data-end-airport2');
			var start_time2=$(this).parents('.air_ticket2').attr('data-start-time2');
			var seattype2=$(this).parents('.air_ticket2').attr('data-seattype2');
			
			
			console.log("왕복:ok?");
			console.log("plane_id :"+plane_id);
			console.log("start_airport :" +start_airport);
			console.log("end_airport :"+ end_airport);
			console.log("start_time :"+start_time);
			console.log("seattype :"+seattype);
			console.log("plane_id2 :"+plane_id2);
			console.log("start_airport2 :" +start_airport2);
			console.log("end_airport2 :"+ end_airport2);
			console.log("start_time2 :"+start_time2);
			console.log("seattype2 :"+seattype2);
			console.log("inwon :"+inwon);
			
			$.ajax({
				type:'POST',
				url:'../../airplane/airplane_reserve_round_trip.do',
				data:{"start_airport":start_airport,
					  "end_airport":end_airport,
					  "start_time":start_time,
					  "seattype":seattype,
					  "start_airport2":start_airport2,
					  "end_airport2":end_airport2,
					  "start_time2":start_time2,
					  "seattype2":seattype2,
					  "inwon":inwon,
					  "plane_id":plane_id,
					  "plane_id2":plane_id2,
					  "airway":airway},
				success:function(res)
				{
					$(location).attr('href','../../template/main/member_reservation.do');
				}
			})
		}
	})
})