<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	
	//더보기버튼 클릭
	$(document).on('click','.moreBtn',function(){
		$(this).hide();
		var page=$(this).attr('data-page');
		var pageInt=(parseInt(page))+1;
		var totalpage=$(this).attr('data-totalpage');
		
		console.log("page"+page);
		console.log("totalpage"+totalpage);
		console.log("pageInt : "+pageInt);
		$.ajax({
			type:'POST',
			url:'tour.do',
			data:{'page':pageInt},
			success:function(res)
			{
				$('.container').append(res);
				if(totalpage==page)
					$('.moreBtn').remove();
			}
		})		
	
	})
})
</script>
</head>
<body>
		<c:forEach var="vo" items="${list }"> 
	                <div class="col-12 col-sm-6 col-lg-4" id="tourList">
	                	<input type="hidden" vlaue="${vo.id }" >
	                    <div class="single-features-area mb-50">
	                       <img src="${vo.thumbnail }" alt="">
	                        <!-- Price -->
	                        <!-- <div class="price-start">
	                            <p>FROM $59/night</p>
	                        </div> -->
	                        <div class="feature-content d-flex align-items-center justify-content-between">
	                            <div class="feature-title">
	                                <h5>${vo.title }</h5>
	                                <p>${vo.introduction }</p>
	                            </div>
	                            <!-- <div class="feature-favourite">
	                                <a href="#"><i class="fa fa-heart-o" aria-hidden="true"></i></a>
	                            </div> -->
	                        </div>
	                    </div>
	                </div>
	       		</c:forEach>         
            </div>
            
           		<div class="row">
		            	<input type="submit" class="btn dorne-btn moreBtn" value="더보기" style="width: 100%" id="moreBtn" data-page="${page }" 
		            	  data-totalpage="${totalpage }">
	            </div>
</body>
</html>