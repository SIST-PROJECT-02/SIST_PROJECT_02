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

	<!-- ***** Breadcumb Area Start ***** -->
    <div class="breadcumb-area bg-img bg-overlay" style="background-image: url(../css/img/bg-img/jeju.png)"></div>
    <!-- ***** Breadcumb Area End ***** -->
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
			<c:forEach var="vo" items="${list }"> 
	                <div class="col-12 col-sm-6 col-lg-4" id="tourList">
	                	<input type="hidden" value="${vo.id }" >
	                    <div class="single-features-area mb-50"  style="width: 300px; height: 200px;">
	                       <img src="${vo.thumbnail }" alt="" style="height: 100px;">
	                        <!-- Price -->
	                        <!-- <div class="price-start">
	                            <p>FROM $59/night</p>
	                        </div> -->
	                        <div class="feature-content d-flex align-items-center justify-content-between" style="padding: 20px 10px">
	                            <div class="feature-title">
	                                <h5>${vo.title }</h5>
	                                <p style="display:inline-block;text-overflow: ellipsis;white-space:nowrap;overflow:hidden;">${vo.address }</p>
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
				<input type="submit" class="btn dorne-btn moreBtn" value="더보기" style="width: 100%" id="moreBtn" data-page="${page }" data-totalpage="${totalpage }">
			</div>
		</div>
    </section>	            
</body>
</html>