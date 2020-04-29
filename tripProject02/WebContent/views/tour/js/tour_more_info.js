$(function(){
	
	//더보기버튼 클릭
	$(document).on('click','.moreBtn',function(){
		
		$(this).remove();
		var page=$(this).attr('data-page');
		var pageInt=(parseInt(page))+1;
		var totalpage=$(this).attr('data-totalpage');
		console.log("page : " + page);
		$.ajax({
			type:'POST',
			url:'tour_list.do',
			data:{'page':pageInt},
			success:function(res)
			{
				$('.container').append(res);
				if(totalpage==page)
					$('.moreBtn').remove();
			},
			error:function(e)
			{
				alert(e);
			}
			
		})		
	
	})
})