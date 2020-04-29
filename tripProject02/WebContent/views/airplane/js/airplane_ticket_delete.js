$(function(){
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
		if(index==-1)
		{
			$(this).parents('.air_ticket2').remove();
			$('.container_air').show();
			$('.moreInfoBtn').last().show();
		}
	})
})
