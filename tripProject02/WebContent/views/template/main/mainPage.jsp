<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>여행복행</title>
</head>
<body>
    <!-- ***** Welcome Area Start ***** -->
    <section class="dorne-welcome-area bg-img bg-overlay" style="background-image: url(../css/img/bg-img/jeju.png);">
        <div class="container h-100">
            <div class="row h-100 align-items-center justify-content-center">
                <div class="col-12 col-md-10">
                    <!-- 메인 검색창 위의 기능 -->
                    <div class="hero-content">
                        <h2>제주도의 방방곡곡</h2>
                        <h4>제주도의 구석구석을 검색해보세요</h4>
                    </div> 
                    
                    <!-- Hero Search Form -->
                    <!-- <div class="hero-search-form">
                        Tabs
                        <div class="nav nav-tabs" id="heroTab" role="tablist">
                            <a class="nav-item nav-link active" id="nav-places-tab" data-toggle="tab" href="#nav-places" role="tab" aria-controls="nav-places" aria-selected="true">Places</a>
                            <a class="nav-item nav-link" id="nav-events-tab" data-toggle="tab" href="#nav-events" role="tab" aria-controls="nav-events" aria-selected="false">Events</a>
                        </div>
                        Tabs Content
                        <div class="tab-content" id="nav-tabContent">
                            <div class="tab-pane fade show active" id="nav-places" role="tabpanel" aria-labelledby="nav-places-tab">
                                <h6>What are you looking for?</h6>
                                <form action="#" method="get">
                                    <select class="custom-select">
                                        <option selected>출발지</option>
                                        <option value="1">인천 국제공항</option>
                                        <option value="2">Latvia</option>
                                        <option value="3">Dhaka</option>
                                        <option value="4">Melbourne</option>
                                        <option value="5">London</option>
                                    </select>
                                    <select class="custom-select">
                                        <option selected>목적지</option>
                                        <option value="1">제주 국제공항</option>
                                        <option value="2">Catagories 2</option>
                                        <option value="3">Catagories 3</option>
                                    </select>
                                    <select class="custom-select">
                                        <option selected>항공권 종류</option>
                                        <option value="1">왕복</option>
                                        <option value="2">편도</option>
                                        <option value="3">$1000 - $4999</option>
                                    </select>
                                    <button type="submit" class="btn dorne-btn"><i class="fa fa-search pr-2" aria-hidden="true"></i>검색</button>
                                </form>
                            </div>
                            <div class="tab-pane fade" id="nav-events" role="tabpanel" aria-labelledby="nav-events-tab">
                                <h6>What are you looking for?</h6>
                                <form action="#" method="get">
                                    <select class="custom-select">
                                        <option selected>장소</option>
                                        <option value="1">숙소</option>
                                        <option value="2">여행지</option>
                                        <option value="3">맛집</option>
                                        <option value="4">Melbourne</option>
                                        <option value="5">London</option>
                                    </select>
                                    <select class="custom-select">
                                        <option selected>도착일</option>
                                        <option value="1">Catagories 1</option>
                                        <option value="2">Catagories 2</option>
                                        <option value="3">Catagories 3</option>
                                    </select> 
                                    <select class="custom-select">
                                        <option selected>인원수</option>
                                        <option value="1">$100 - $499</option>
                                        <option value="2">$500 - $999</option>
                                        <option value="3">$1000 - $4999</option>
                                    </select>
                                    <button type="submit" class="btn dorne-btn"><i class="fa fa-search pr-2" aria-hidden="true"></i>검색</button>
                                </form>
                            </div>
                        </div>
                    </div> -->
                </div>
            </div>
        </div>
    </section>
    <!-- ***** Welcome Area End ***** -->
    
    <!-- ***** About Area Start ***** -->
    <section class="dorne-about-area section-padding-0-50">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="about-content text-center">
                        <h2>믿을 수 있는 제주도 여행 사이트 <br><span>여행복행</span></h2>
                       <!--  <p>Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Fusce quis tempus elit. Sed efficitur tortor neque, vitae aliquet urna varius sit amet. Ut rhoncus, nunc nec tincidunt volutpat, ex libero.</p> -->
                    	<p>여행복행은 제주도 관련 여행정보를 종합 검색할 수 있는 곳입니다. 제주도와 관련된 구석구석의 정보를 찾아보시고 부디 제주도 여행에 보탬이 되었으면 합니다. 즐거운 제주도 여행과 함께하는 여행복행이 되도록 노력하겠습니다. </p>
                    </div>
                </div>
            </div>
        </div>
    </section> 
    <!-- ***** About Area End ***** -->

    <!-- ***** Editor Pick Area Start ***** -->
    <section class="dorne-editors-pick-area bg-img bg-overlay-9 section-padding-100" style="background-image: url(../css/img/bg-img/hero-2.jpg);">
        
        <div class="container-fluid">
        
            <div class="row">
                <div class="col-12">
                    <div class="section-heading text-center">
                        <span></span>
                        <h4>당신이 꼭 가봐야할 섬</h4>
                        <p>제주도</p>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-12" style="margin: 0px auto;">
               		<div class="features-slides owl-carousel">
               			<%-- <c:forEach begin="1" end="5" step="1" var="${img }"> --%>
	               			<div class="single-features-area">
	                    	<!-- <div class="single-features-area single-editors-pick-area wow fadeInUp" data-wow-delay="0.2s"> -->
	                        	<!-- <div class="single-features-area"> -->
	                        		<!-- <div class="places-total-destinations d-flex"> -->
	                      		  		<img src="../css/img/bg-img/jeju.png" alt="" style="width:271px; height: 181px; ">
	                        <!-- <div class="editors-pick-info features-slides owl-carousel">
	                            <div class="places-total-destinations d-flex"> -->
	                                <!-- <a href="#">{title}</a>
	                                <a href="#">{introduction}</a> -->
	                               <!--  <a>제주도</a>
	                                <a>대한민국에서 가장 큰 섬</a> -->
	                            <!-- </div> -->
	                       <!--  </div> -->
	                    	</div>
                    	<%-- </c:forEach> --%>
                    	<div class="single-features-area">
                    		<img src="../css/img/bg-img/jeju2.jpg" alt="" style="width:271px; height: 181px; ">
                    	</div>
                    	<div class="single-features-area">
                    		<img src="../css/img/bg-img/jeju3.jpg" alt="" style="width:271px; height: 181px; ">
                    	</div>
                    	<div class="single-features-area">
                    		<img src="../css/img/bg-img/jeju4.jpg" alt="" style="width:271px; height: 181px; ">
                    	</div>
                    	<div class="single-features-area">
                    		<img src="../css/img/bg-img/harbang.jpg" alt="" style="width:271px; height: 181px; ">
                    	</div>
                	</div>
            	</div>
        	</div>
    </section>
    <!-- ***** Editor Pick Area End *****  -->

    <!-- ***** Features Destinations Area Start ***** -->
    <section class="dorne-features-destinations-area">
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <div class="section-heading dark text-center">
                        <span></span>
                        <h4>제주도 추천 호텔 Top 5</h4>
                        <p>Editor’s pick</p>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-12">
                    <div class="features-slides owl-carousel">
                    
                    	<c:forEach var="hotelvo"  items="${hotelvo }">
	                        <!-- Single Features Area -->
	                        <div class="single-features-area">
	                            <img src="${hotelvo.thumbnail }" alt="" style="width: 257px; height: 171px;">
	                            <!-- Price -->
	                            <!-- <div class="price-start">
	                                <p>FROM $59/night</p>
	                            </div> -->
	                            <div class="feature-content d-flex align-items-center justify-content-between"  style="width: 257px; height: 167px;">
	                                <div class="feature-title">
	                                    <h5>${hotelvo.title }</h5>
	                                    <p>${hotelvo.introduction }</p>
	                                </div>
	                                <!-- <div class="feature-favourite">
	                                    <a href="#"><i class="fa fa-heart-o" aria-hidden="true"></i></a>
	                                </div> -->
	                            </div>
	                        </div>
                   		</c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ***** Features Destinations Area End ***** -->

    <!-- ***** Features Restaurant Area Start ***** -->
    <section class="dorne-features-restaurant-area bg-default">
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <div class="section-heading text-center">
                        <span></span>
                        <h4>제주도 추천 관광지 Top 5</h4>
                        <p>Editor’s pick</p>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-12">
                    <div class="features-slides owl-carousel">
                    
                    	<c:forEach var="tourvo"  items="${tourvo }">
	                        <!-- Single Features Area -->
	                        <div class="single-features-area">
	                            <img src="${tourvo.thumbnail }" alt="">
	                            <!-- Rating & Map Area -->
	                            <div class="ratings-map-area d-flex">
	                                <a href="#">${tourvo.evel_point}</a>
	                                <!-- <a href="#"><img src="../css/img/core-img/map.png" alt=""></a> -->
	                            </div>
	                            <div class="feature-content d-flex align-items-center justify-content-between"  style="width: 257px; height: 167px;">
	                                <div class="feature-title">
	                                    <h5>${tourvo.title}</h5>
	                                    <p>${tourvo.introduction}</p>
	                                </div>
	                                <!-- <div class="feature-favourite">
	                                    <a href="#"><i class="fa fa-heart-o" aria-hidden="true"></i></a>
	                                </div> -->
	                            </div>
	                        </div>
                        </c:forEach>
                        
                    </div>
                </div>
            </div>
            
        </div>
    </section>
    <!-- ***** Features Restaurant Area End ***** -->
	
	 <!-- ***** Features Destinations Area Start ***** -->
    <section class="dorne-features-destinations-area">
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <div class="section-heading dark text-center">
                        <span></span>
                        <h4>제주도 추천 음식점 Top 5</h4>
                        <p>Editor’s pick</p>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-12">
                    <div class="features-slides owl-carousel">
                    
                    	<c:forEach var="foodvo"  items="${foodvo }">
	                        <!-- Single Features Area -->
	                        <div class="single-features-area">
	                            <img src="${foodvo.thumbnail }" alt="" style="width: 257px; height: 171px;">
	                            <!-- Price -->
	                            <!-- <div class="price-start">
	                                <p>FROM $59/night</p>
	                            </div> -->
	                            <div class="feature-content d-flex align-items-center justify-content-between"  style="width: 257px; height: 167px;">
	                                <div class="feature-title">
	                                    <h5>${foodvo.title }</h5>
	                                    <p>${foodvo.introduction }</p>
	                                </div>
	                                <!-- <div class="feature-favourite">
	                                    <a href="#"><i class="fa fa-heart-o" aria-hidden="true"></i></a>
	                                </div> -->
	                            </div>
	                        </div>
                   		</c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ***** Features Destinations Area End ***** -->
	
    <!-- ***** Clients Area Start ***** -->
    <!-- <div class="dorne-clients-area section-padding-100">
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <div class="clients-logo d-md-flex align-items-center justify-content-around">
                        <img src="../css/img/clients-img/1.png" alt="">
                        <img src="../css/img/clients-img/2.png" alt="">
                        <img src="../css/img/clients-img/3.png" alt="">
                        <img src="../css/img/clients-img/4.png" alt="">
                        <img src="../css/img/clients-img/5.png" alt="">
                    </div>
                </div>
            </div>
        </div>
    </div> -->
    <!-- ***** Clients Area End ***** -->
    
    <!-- ***** About Area Start ***** -->
    <section class="dorne-about-area section-padding-0-100">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="about-content text-center">
                        <h2>제주도 참말로 좋수다! <br><span>여행복행</span></h2>
                        <p>Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Fusce quis tempus elit. Sed efficitur tortor neque, vitae aliquet urna varius sit amet. Ut rhoncus, nunc nec tincidunt volutpat, ex libero.</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ***** About Area End ***** -->
</body>
</html>