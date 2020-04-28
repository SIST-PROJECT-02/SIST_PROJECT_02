<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	
	$('.moreBtn').click(function(){
		
		var totalpage=$('body').find('.air_info').attr('data-totalpage');
		var page=$(this).attr('data-page');
		page=parseInt(page)+1;
		var totalpageInt=parseInt(totalpage);
		
		$.ajax({
			type:'POST',
			url:'tour.do',
			data:{'page':page}, 
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
</script>
</head>
<body>
    <!-- ***** Breadcumb Area Start ***** -->
    <div class="breadcumb-area bg-img bg-overlay" style="background-image: url(../css/img/bg-img/jeju.png)"></div>
    <!-- ***** Breadcumb Area End ***** -->

    <!-- ***** Listing Destinations Area Start ***** -->
    <section class="dorne-listing-destinations-area section-padding-100-50">
        <div class="container">
            
            <div class="row">
                <div class="col-12">
                    <div class="section-heading dark text-center">
                        <span></span>
                        <h4>관광지</h4>
                        <!-- <p>Editor’s pick</p> -->
                    </div>
                </div>
            </div>
            
            <div class="row">
                <!-- Single Features Area -->
                 <c:forEach var="vo" items="${vo }"> 
	                <div class="col-12 col-sm-6 col-lg-4">
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
            
            <form  method="POST" action="tour_more.do" id="frm" name="frm">
	            <div class="row">
	            	<input type="submit" class="btn dorne-btn" value="더보기" style="width: 100%" id="moreBtn">
	            </div>
            </form>
        </div>
    </section>
    <!-- ***** Listing Destinations Area End ***** -->
</body>
</html>