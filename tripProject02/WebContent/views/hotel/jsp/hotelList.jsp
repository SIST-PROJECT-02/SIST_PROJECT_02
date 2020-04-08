<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./../../hotel/css/hotelList.css">
</head>
<body>

	<!-- ***** Breadcumb Area Start ***** -->
	<div class="breadcumb-area bg-img bg-overlay"
		style="background-image: url(../css/img/bg-img/jeju.png)"></div>
	<!-- ***** Breadcumb Area End ***** -->

	<!-- ***** Listing Destinations Area Start ***** -->
	<div class="recommended-hotel">
		<span></span>
		추천 숙박♡행
	</div>
	<jsp:include page="./../../hotel/jsp/sliding.jsp"></jsp:include>
	<div class="recommended-hotel">
		<span></span>
		숙박 리스트♡행
	</div>
	<jsp:include page="./../../hotel/jsp/list.jsp"></jsp:include>
	
	<script>
		var tmplate = document.getEleme
	</script>
	<script name="temp" type="aa">
	<div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-features-area mb-50">
                        <img src="{img}" alt="">
                        <!-- Price -->
                        <div class="price-start">
                            <p>FROM {evel_point}</p>
                        </div>
                        <div class="feature-content d-flex align-items-center justify-content-between">
                            <div class="feature-title">
                                <h5>{title}</h5>
                                <p>Party</p>
                            </div>
                            <div class="feature-favourite">
                                <a href="#"><i class="fa fa-heart-o" aria-hidden="true"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
</script>

</body>
</html>