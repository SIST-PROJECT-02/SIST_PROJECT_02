$(function() {
	$(document).ajaxStart(function(e) {

		window.ajaxCheck = 1;

	});

	$(document).ajaxStop(function(e) { 

		window.ajaxCheck = null; 

	});
	
	
	$('.moreInfoBtn').hover(function(){
		$(this).css('cursor','pointer');
	},function(){
		$(this).css('cursor','none');
	})
	
/*	var totalpage=$('body').find('#totalpage').val();
	var page=$('.moreInfoBtn').attr('data-page');
	console.log('init totalpage: '+totalpage);
	console.log('init page: '+page);
	*/
	if($('body').find('#totalpage').val()==$('.moreInfoBtn').attr('data-page'))
	{
		$('.moreInfoBtn').hide();
	}
		 
	$('.moreInfoBtn').click(function(){
		if( window.ajaxCheck == 1 ) return false;
		
		$(this).hide();
		
	/*	var airline=$('body').find('#airline').text().trim();
		var start_hour=$('body').find('#start_hour').text().trim();
		var end_hour=$('body').find('#end_hour').text().trim();
		var total_time=$('body').find('#total_time').text().trim();
		var seattype=$('body').find('#seattype').text().trim();*/
		
		var start_airport=$('body').find('.air_info').attr('data-start-airport');
		var end_airport=$('body').find('.air_info').attr('data-end-airport');
		var start_time=$('body').find('.air_info').attr('data-start-time');
		var end_time=$('body').find('.air_info').attr('data-end-time');
		var airway=$('body').find('.air_info').attr('data-airway');
		var totalpage=$('body').find('.air_info').attr('data-totalpage');
		var type=$('body').find('.air_info').attr('data-type');
		var page=$(this).attr('data-page');
		type=type-1;
/*		console.log('totalpage: '+totalpage);
		console.log('page: '+page);
		console.log('type: '+type);*/
		
		/*console.log(airline);
		 * console.log(page);
		console.log(start_airport);
		console.log(start_hour);
		console.log(end_airport);
		console.log(end_hour);
		console.log(total_time);
		console.log(seattype);
		console.log(totalpage);*/
		page=parseInt(page)+1;
		var totalpageInt=parseInt(totalpage);
		/*console.log('nextPage: ' + page);*/
			
		$.ajax({
			type:'POST',
			url:'../../airplane/airplaneList_ok.do',
			async: true,
			data:{'start_airport':start_airport,
				  'end_airport':end_airport,
				  'start_time':start_time,
				  'end_time':end_time,
				  'airway':airway,
				  'type':type,
				  'page':page},
			success:function(res)
			{
				$(this).remove();
				$('body').find('#air-search').append(res);
				
				if(totalpageInt==page)
				{
					$('body').find('.moreInfoBtn').remove();
				}
			},
			error:function(e)
			{
				alert(e);
			}
		})
		
	})
})