<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./../../airplane/js/airplane_ticket.js?v<%=System.currentTimeMillis()%>"></script>
<script type="text/javascript" src="./../../airplane/js/airplane_more_info.js?v<%=System.currentTimeMillis()%>"></script>
<script type="text/javascript" src="./../../airplane/js/airplane_reserve.js?v<%=System.currentTimeMillis()%>"></script>
<script type="text/javascript" src="./../../airplane/js/airplane_ticket_delete.js?v<%=System.currentTimeMillis()%>"></script>
</head>
<body>
	<div id="ticket_view" >
		<!-- <input type="hidden" name="number" id="number" value="0"> -->
	</div>
			<c:forEach var="vo" items="${list }" >
					<div class="container_air">
						<div class="air_info" data-airway="${airway }" data-start-airport="${start_airport }" 
						data-end-airport="${end_airport }" data-start-time="${start_time }" data-end-time="${end_time }" 
						data-type="${type }" data-totalpage="${totalpage }" data-inwon="${inwon }" data-plane-id="${vo.plane_id }"
						data-seattype="${vo.seatVO.seattype }">
							<div class="air_img">
								<img class="airport_img" src="../../airplane/img/${vo.img }" width="30px" height="30px" data-airimg="${vo.img }"/>
								<div id="airline" class="bottom"><span>${vo.airline }</span></div>
							</div>
							<div class="air_time_port">
								<dl style="width: 30%">
									<dt class="blind">출발지</dt>
									<dd id="start_airport" class="txt_code ng-binding">${vo.timeVO.start_airport}</dd>
									<dd id="start_hour" class="txt_time ngbinding">${vo.timeVO.start_hour }</dd>
								</dl>
								<%-- <div class="top"><b>${vo.timeVO.start_hour } - ${vo.timeVO.end_hour }</b></div> --%>
								<dl style="width: 40%">
									<dt class="blind">걸리는 시간</dt>
									<dd class="arrow_img"><img src="../../airplane/img/arrow.PNG"></dd>
									<dd id="total_time" class="txt_total_time" style="font-size: 14px; color:#647582; ">${vo.timeVO.totaltime}</dd>
								</dl>
								<dl style="width: 30%">
									<dt class="blind">도착지</dt>
									<dd id="end_airport" class="txt_code ng-binding">${vo.timeVO.end_airport}</dd>
									<dd id="end_hour" class="txt_time ngbinding">${vo.timeVO.end_hour }</dd>
								</dl>
							</div>
							<div class="air_seattype">
									<div class="airseat_img">
										<img src="../../airplane/img/seat.PNG" height="35px" width="35px">
									</div>
									
									<div class="seattype">
										<c:set var="seattype" value="${vo.seatVO.seattype }"/>
										<c:choose>
											<c:when test="${seattype eq 2 }">
												<span>일반석</span>
											</c:when>
											
											<c:when test="${seattype eq 1 }">
												<span>이등석</span>
											</c:when>
											
											<c:when test="${seattype eq 0 }">
												<span>일등석</span>
											</c:when>
										</c:choose>
									</div>
							</div>
							
							<div class="air_price">
								<b>${vo.seatVO.price }</b>
							</div>
						</div>
						
						
					</div>
					 
				</c:forEach>
				<div class="row">
					<c:if test="${listSize == 10 }">
					<div class="moreInfoBtn" id="moreInfoBtn" data-page="${page }" >
						<h3 class="text-center" style="line-height: 100px;">더 보기</h3>		
					</div>
					</c:if>
				</div>
				

</body>
</html>