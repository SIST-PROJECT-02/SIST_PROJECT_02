<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./../../hotel/css/hotelList.css">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Gugi&family=Jua&family=Yeon+Sung&display=swap" rel="stylesheet">
</head>
<body>
	<div class="breadcumb-area bg-img bg-overlay"
		style="background-image: url(../css/img/bg-img/jeju.png)"></div>
	<jsp:include page="./../../hotel/jsp/search.jsp"></jsp:include>
	<jsp:include page="./../../hotel/jsp/modal.jsp"></jsp:include>
	<div class="recommended-hotel">
		<span></span> 추천 숙박
	</div>
	<jsp:include page="./../../hotel/jsp/sliding.jsp"></jsp:include>
	<div class="recommended-hotel">
		<span></span> 숙박 리스트
	</div>
	<jsp:include page="./../../hotel/jsp/list.jsp"></jsp:include>

</body>
</html>