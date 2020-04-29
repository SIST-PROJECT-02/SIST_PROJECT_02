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
	$('.resHotel').ready(function(){
		$('.on').css("background","#7643EA");
		$('.resHotel').css("color","#fff");
	});
	
	$('.resHotel').hover(function(){
		$(this).css("cursor","pointer");
	},function(){
		$(this).css("cursor","none");	
	});
	
	$('.resAir').hover(function(){
		$(this).css("cursor","pointer");
	},function(){
		$(this).css("cursor","none");	
	});
	
	$('.resHotel').click(function(){
		$('.on').css("background","#7643EA");
		$('.resHotel').css("color","#fff");
		$('.off').css("background","#fff");
		$('.resAir').css("color","#959595");
	});
	
	$('.resAir').click(function(){
		$('.on').css("background","#fff");
		$('.on').css("border-top","1px solid #e5e5e5");
		$('.resHotel').css("color","#959595");
		$('.off').css("background","#7643EA");
		$('.resAir').css("color","#fff");
	});
		
	$(document).ready(function(){
		$('.reserveTable_hotel').show();
		$('.reserveTable_air').hide();
		$('.resAir').click(function(){
			$('.reserveTable_hotel').hide();
			$('.reserveTable_air').show();
			$('#result_reservation').hide();
		});
		/* return false; */
		
		$('.resHotel').click(function(){
			$('.reserveTable_hotel').show();
			$('.reserveTable_air').hide();
			$('#result_reservation').hide();
		});
		/* return false; */
	});

});
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
                        <h4>예약확인</h4>
                        <p>${name }의 예약내역</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <div class="container" id="reservation">
    	<div class="row">
		    <ul class="theme_list item_2 clear">
		    	<li class="on">
		    		<a class="resHotel">호텔</a>
		    	</li>
		    	<li class="off">
		    		<a class="resAir">항공</a>
		    	</li>
		    </ul>
	    </div>
    </div>

    <div class="container">
    	<div class="row">
    		<table class="reserveTable_hotel" style="width: 100%;">
    			<thead class="reserveTable_head">
    				<tr>
    					<th>예약번호</th>
    					<th>예약자명</th>    				
	    				<th>숙소명</th>
	    				<th>체크인</th>
	    				<th>체크아웃</th>
	    				<th>요금합계</th>
	    				<th>상태</th>
    				</tr>
    			</thead>
    			<c:forEach var="hvo" items="${hotelList}">
    			<tbody class="reserveTable_body">
    				<tr>
    					<td>${hvo.id }</td>
    					<td>${hvo.email }</td>
	    				<td>${hvo.title }</td>
	    				<td>${hvo.check_in }</td>
	    				<td>${hvo.check_out }</td>
	    				<td>${hvo.price } 원</td>
	    				<td><a class="btn ok1">${hvo.state }</a></td>
    				</tr>
    			</tbody>
    			</c:forEach>
    		</table>
    	</div>
    </div>
    <div class="container">
    	<div class="row">
    		<table class="reserveTable_air" style="width: 100%;">
    			<thead class="reserveTable_head">
    				<tr>
	    				<th>항공사</th>
	    				<th>탑승일</th>
	    				<th>노선</th>
	    				<th>출발시간</th>
	    				<th>도착시간</th>
	    				<th>총 탑승객</th>
	    				<th>총 금액</th>
	    				<th>상태</th>
    				</tr>
    			</thead>
    			<c:forEach var="avo" items="${airList}">
    			<tbody class="reserveTable_body">
    			
    				<tr>
	    				<td>
	    					<img src="../../airplane/img/${avo.img }" style="width: 40px; height: 40px;"><br>
	    					${avo.airline }
	    				</td>
	    				<td style="width: 10%">${avo.date }<br>
	    					${avo.day }
	    				</td>
	    				<td>${avo.start_airport }<img src="../../airplane/img/arrow.PNG"> ${avo.end_airport }</td>
	    				<td>${avo.start_hour }</td>
	    				<td>${avo.end_hour }</td>
	    				<td>${avo.inwon } 명</td>
	    				<td>${avo.price } 원</td>
	    				<td>
	    					<c:choose>
	    						<c:when test="${avo.status==0 }">
	    							<button class="btn ok2" style="background-color:#FA5858; color:white;" >예약 대기</button>
	    						</c:when>
	    						<c:otherwise>
	    							<button class="btn" style="background-color:#01DFA5; color:white;">예약 완료</button>
	    						</c:otherwise>
	    					</c:choose>
	    				</td>
    				</tr>
    			
    			</tbody>
    			</c:forEach>
    		</table>	
    	</div>
    </div>
    <div id="result_reservation"></div>	
</body>
</html>