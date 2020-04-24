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
	
	$('.ok1').click(function(){
		$.ajax({
			type:'POST',
			url:'reserve_hotel.do',
			success:function(res)
			{
				$('#result_reservation').show();
				$('#result_reservation').html(res);
			}
		});
	});
	$('.ok2').click(function(){
		$.ajax({
			type:'POST',
			url:'reserve_air.do',
			success:function(res)
			{
				$('#result_reservation').show();
				$('#result_reservation').html(res);
			}
		});
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
    		<table class="reserveTable_hotel">
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
    			<tbody class="reserveTable_body">
    				<tr>
    					<td>예약번호</td>
	    				<td>투숙객명</td>
	    				<td>숙소명</td>
	    				<td>체크인</td>
	    				<td>체크아웃</td>
	    				<td>요금합계</td>
	    				<td><a class="btn ok1">상태</a></td>
    				</tr>
    			</tbody>
    		</table>
    	</div>
    </div>
    <div class="container">
    	<div class="row">
    		<table class="reserveTable_air">
    			<thead class="reserveTable_head">
    				<tr>
	    				<th>항공사</th>
	    				<th>탑승일</th>
	    				<th>노선</th>
	    				<th>출발시간</th>
	    				<th>도착시간</th>
	    				<th>총 탑승객</th>
	    				<th>상태</th>
    				</tr>
    			</thead>
    			<tbody class="reserveTable_body">
    				<tr>
	    				<td>항공사</td>
	    				<td>탑승일</td>
	    				<td>노선</td>
	    				<td>출발시간</td>
	    				<td>도착시간</td>
	    				<td>총탑승객</td>
	    				<td><a class="btn ok2">상태</a></td>
    				</tr>
    			</tbody>
    		</table>	
    	</div>
    </div>
    <div id="result_reservation"></div>	
</body>
</html>