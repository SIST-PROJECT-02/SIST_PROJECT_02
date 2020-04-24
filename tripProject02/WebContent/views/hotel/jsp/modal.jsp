<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./../../hotel/css/modal.css?ver3">
<link rel="stylesheet" href="./../../hotel/css/modalList.css">
<link href="https://fonts.googleapis.com/css2?family=Gugi&family=Jua&family=Yeon+Sung&display=swap" rel="stylesheet">
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=339dabf7e4db5fbb62ad255755d1f27d"></script>
</head>
<body>
	<div class="modal-background"></div>
	<section class="modal-wrap">
	<div class="data-wrap">
		<div class="img-wrap">
			<span>#해시태그지롱</span> <img src="#" />
			<div>♡</div>
		</div>
		<div class="basic-info-wrap">
			<p>
				무슨무슨 호텔&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>★★★★☆</span>
			</p>
		</div>
		<nav>
		<ul>
			<li id="nav-detail">상세 정보</li>
			<li id="nav-info">이용안내</li>
			<li id="nav-attraction">주변/관광지</li>
			<li id="nav-review" style="border-right: 1px solid #e5e5e5">리뷰</li>
		</ul>
		</nav>
		<div class="dynamic-info-wrap"></div>
		<div class="reservation-btn">예약하기</div>
	</div>
	</section>
	<script id="template-modal-detail" type="text/template">
                <p id="template-modal-p">{description}</p>
        </script>
	<script id="template-modal-info" type="text/template">
			<table id="template-modal-table">
				<tr>
					<th width=20%>소개</th>
					<td width=80%>{introduction}</td>
				</tr>
				<tr>
					<th width=20%>이용 시간</th>
					<td width=80%>{short_introduction}</td>
				</tr>
				<tr>
					<th width=20%>편의 시설</th>
					<td width=80%>{convenience}</td>
				</tr>
			</table>
	</script>
	<script id="template-modal-review" type="text/template">
		<li name="{user-id}">
		<span class="user-name">{user-name}</span><span class="user-date">{user-date}</span><span class="delete">X</span>
		<div class="user-star">{user-star}</div>
		<div class="user-content">{user-content}</div>
		</li>
	</script>
	<script id="template-modal-review-wrap" type="text/template">
	<section class="modal-review-wrap">
		<div class="list-modal-count">{count}</div>
		<ul class="modal-review">
		
		</ul>
		<div class="modal-more-data">검색결과 더보기</div>
	</section>
	<section class="modal-review-form">
        <div class="top">리뷰 쓰기</div>
        <ul class="star">
            <li name="1">☆</li>
            <li name="2">☆</li>
            <li name="3">☆</li>
            <li name="4">☆</li>
            <li name="5">☆</li>
            <span class="star-num">1</span> / 5
        </ul>
        <textarea id="review-content" cols="30" rows="5" class="content" required></textarea>
        <div class="bottom">
            <input type="button" class="delete" value="삭 제">
            <input type="button" class="update" value="수 정">
            <input type="button" class="create" value="생 성">
        </div>
    </section>
	</script>
	<script id="template-modal-map-wrap" type="text/template">
		<section class="modal-map-wrap">
		</section>
	</script>
	<script id="template-mark" type="text/template">
		<div class="mark-wrap">
			<div class="mark-thumbnail"><img src="{thumbnail}"/></div>
			<div class="mark-title"><p>{title}</p></div>
		</div>
	</script>
	<script src="./../../hotel/js/modal.js?ver9"></script>
	<script src="./../../hotel/js/configuration/modalConfiguration.js"></script>
	<script src="./../../hotel/js/getData/getDataForModal.js"></script>
	<script src="./../../hotel/js/modalListConstructor.js"></script>
</body>
</html>