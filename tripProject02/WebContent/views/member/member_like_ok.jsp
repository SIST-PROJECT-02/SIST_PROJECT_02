<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
                        <h4>즐겨찾기</h4>
                        <p>${email }의 즐겨찾기</p>
                    </div>
                </div>
            </div>
    	</div>        
    </section>
    <!-- ***** Listing Destinations Area End ***** -->
	    <div class="container">
	    	<div class="row">
		<!-- Single Features Area -->
				 <c:forEach var="vo" items="${vo }"> 
					<div  class="col-12 col-sm-6 col-lg-4" style="float: left;">
						<div class="single-features-area mb-50">
							<img src="${vo.thumbnail }" style="width: 366px; height: 217px;">
							<div class="feature-content d-flex align-items-center justify-content-between">
								<div class="feature-title">
									<h5>${vo.title }</h5>
									<p>${vo.address }</p>
									<p>${vo.tel }</p>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>		
			</div>
		</div>
</body>
</html>