<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../tour/css/tour.css" >
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript" src="../../tour/js/tour_more_info.js"></script>
</head>
<body>
    <!-- ***** Breadcumb Area Start ***** -->
    <div class="breadcumb-area bg-img bg-overlay" style="background-image: url(../css/img/bg-img/jeju.png)"></div>
    <!-- ***** Breadcumb Area End ***** -->

    <!-- ***** Listing Destinations Area Start ***** -->
    <section class="dorne-listing-destinations-area section-padding-100-50">
        <div class="container text-center">
            <div class="row">
                <div class="col-12">
                    <div class="section-heading dark">
                        <span></span>
                        <h4>관광지</h4>
                        <!-- <p>Editor’s pick</p> -->
                    </div>
                </div>
            </div>
            
            <div class="row">
                <!-- Single Features Area -->
                 <c:forEach var="vo" items="${list }"> 
	                <div id="tourList">
	                	<input type="hidden" value="${vo.id }" >
	                    <div class="single-features-area">
	                       <img class="tour-img" src="${vo.thumbnail }" alt="">
	                        <!-- Price -->
	                        <!-- <div class="price-start">
	                            <p>FROM $59/night</p>
	                        </div> -->
	                        <div class="feature-content d-flex align-items-center justify-content-between tour-title">
	                            <div class="feature-title">
	                                <h5 style="margin-bottom: 5px">${vo.title }</h5>
	                                <p>${vo.address }</p>
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
		            	<input type="submit" class="btn dorne-btn moreBtn" value="더보기" style="width: 100%; display: block;" id="moreBtn" data-page="${page }" 
		            	  data-totalpage="${totalpage }">
	            </div>
            
        </div>
    </section>
    <!-- ***** Listing Destinations Area End ***** -->
</body>
</html>