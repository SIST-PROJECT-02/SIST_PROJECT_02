<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./../../airplane/css/airplane.css?ver6">
<link rel="stylesheet" href="./../../airplane/css/air_search_info.css?v<%=System.currentTimeMillis()%>">
<link rel="stylesheet" href="./../../airplane/css/air_ticket.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript" src="../../airplane/js/airplaneList.js?v<%=System.currentTimeMillis()%>"></script>
<script type="text/javascript" src="./../../airplane/js/airplane_search.js"></script>

</head>
<body>
	<!-- ***** Breadcumb Area Start ***** -->
	
	<!-- ***** Breadcumb Area End ***** -->

	<!-- Explore Area -->
	<div class="breadcumb-area bg-img bg-overlay" style="background-image: url(../css/img/bg-img/jeju.png)"></div>
	<section id="air_frame" class="dorne-explore-area">
		<!-- Explore Search Area -->
		<!-- Explore Search Form -->
		<div class="row">
			<div id="side" class="explore-search-form col-3" style="font-weight: bold; min-height: 700px;">
				<h6><font class="search-fixed" style="font-size: 20px; font-weight: bold;">어디로 떠나볼까요?</font></h6>
				<!-- Tabs Content -->

				<div class="tab-content search-fixed" id="nav-tabContent" style="width: 20%; top:230px;">
					<div class="tab-pane fade show active" id="nav-places"
						role="tabpanel" aria-labelledby="nav-places-tab">
						
						<!-- <form name="frm" action="../../airplane/airplaneList_ok.do" method="post" id="frm"> -->

							<select class="custom-select-air" id="start_airport"
								name="start_airport" style="font-weight: bold;" required>
								<option selected value="">출발공항 선택</option>
								<option value="제주 국제공항">제주 국제공항</option>
								<option value="인천 국제공항">인천 국제공항</option>
								<option value="포항 공항">포항 공항</option>
								<option value="김포 국제공항">김포 국제공항</option>
							</select> 
							<select class="custom-select-air" id="end_airport"
								name="end_airport" style="font-weight: bold;" required>
								<option selected value="">도착공항 선택</option>
								<option value="제주 국제공항">제주 국제공항</option>
								<option value="인천 국제공항">인천 국제공항</option>
								<option value="포항 공항">포항 공항</option>
								<option value="김포 국제공항">김포 국제공항</option>
							</select>
							<div class="date_font">
								<h6>
									<font style="color: white; font-weight: bold;">출발 날짜</font>
								</h6>
								<input type="date" min="${today }" name="start_time" class="form-control-air" id="start_time">
							</div>
							<div class="date_font" >
								<h6>
									<font style="color: white; font-weight: bold;">도착 날짜</font>
								</h6>
								<input type="date"  min="${today }" name="end_time" class="form-control-air" id="end_time" style="margin-left: 5px;">
							</div>

							<!-- 왕복 편도 라디오 버튼 -->
							<div class="air-radio-box">
								<label class="container-btn">왕복 <input class="radio-btn"
									type="radio" name="airway" value="왕복" checked> <span
									class="checkmark"></span>
								</label>
							</div>
							<div class="air-radio-box">
								<label class="container-btn">편도 <input class="radio-btn"
									type="radio" name="airway" value="편도"> <span
									class="checkmark"></span>
								</label>
							</div>

							<div class="inwon">
								<select  class="custom-select-air" id="inwon"
									name="inwon" style="font-weight: bold; width: 100%; text-right" required>
									<option selected value="1">인원 수</option>
									<c:forEach var="i" begin="1" end="8">
										<option value="${i}">${i} 명 </option>
									</c:forEach>
								</select> 
							</div>
							<button type="button" id="searchBtn"
								class="btn dorne-btn-air mt-50 bg-white text-dark" style="margin-top: 30px">
								<i class="fa fa-search pr-2" aria-hidden="true"></i> Search
							</button>
<!-- 						</form>
 -->					</div>
				</div>
			</div>
			
			<div class="col-sm-9" id="air-search">
				
			</div>
		</div>

		
	</section>
</body>
</html>