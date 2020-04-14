<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="./../tmp.css">
</head>
<body>
	<!-- ***** Breadcumb Area Start ***** -->
	<div class="breadcumb-area bg-img bg-overlay"
		style="background-image: url(../css/img/bg-img/jeju.png)"></div>
	<!-- ***** Breadcumb Area End ***** -->

	<!-- ***** Listing Destinations Area Start ***** -->
	<section class="dorne-listing-destinations-area section-padding-100-50">


	<div class="container">
		<div class="row">
			<div class="col-12">
				<div class="section-heading dark text-center">
					<span></span>
					<h4>Featured destinations</h4>
					<p>Editor’s pick</p>
				</div>
			</div>
		</div>
		<div class="row">
			<!-- Single Features Area -->
			<c:forEach var="vo" items="${list }">
				<div class="col-12 col-sm-6 col-lg-4">
					<div class="single-features-area mb-50">
						<img src="${vo.thumbnail }" style="height: 180px">
						<!-- Price -->
						<div class="price-start">
							<p>FROM ${vo.evel_point }</p>
						</div>
						<div
							class="feature-content d-flex align-items-center justify-content-between">
							<div class="feature-title">
								<h5>${vo.title }</h5>
								<p>Party</p>
							</div>
							<div class="feature-favourite">
								<a href="#"><i class="fa fa-heart-o" aria-hidden="true"></i></a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	</section>
	<!-- ***** Listing Destinations Area End ***** -->

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