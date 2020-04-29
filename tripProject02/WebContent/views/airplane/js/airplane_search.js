$(function(){
	$(document).ajaxStart(function(e) {

		window.ajaxCheck = 1;

	});

	$(document).ajaxStop(function(e) { 

		window.ajaxCheck = null; 

	});
	
	$('.radio-btn').click(function(){
		let airway=$('input:radio[name=airway]:checked').val();
		if(airway=='왕복')
		{
			$('#end_time').attr('disabled',false);
			$('#end_time').css({'opacity':'1'});
		}
		else
		{
			$('#end_time').attr('disabled',true);
			$('#end_time').val('');
			$('#end_time').css({'opacity':'0.7'});
		}
	})
	
	$('#searchBtn').hover(function(){
		$(this).css('cursor','pointer');
		
	},function(){
		$(this).css('cursor','none');
	})	
	
	
	$('#searchBtn').click(function(){
		if( window.ajaxCheck == 1 ) return false;
		$('#side').css('height','');
		let start_airport=$('#start_airport').val();
		let end_airport=$('#end_airport').val();
		let start_time=$('#start_time').val();
		let end_time=$('#end_time').val();
		let airway=$('input:radio[name=airway]:checked').val();
		let inwon=$('#inwon').val();
		
		if(inwon==null)
		{
			Ext.onReady(function(){
				Ext.Msg.alert("인원수 체크","인원수를 선택해주세요");
			})
		}
		console.log("inwon:"+inwon);
		
		
		$.ajax({
			type:'POST',
			url:'../../airplane/airplaneList_ok.do',
			async: true,
			data:{"start_airport":start_airport,
				  "end_airport":end_airport,
				  "start_time":start_time,
				  "end_time":end_time,
				  "airway":airway,
				  "inwon":inwon
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
		
	})
	
})