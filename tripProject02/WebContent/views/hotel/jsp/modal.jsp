<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./../../hotel/css/modal.css?ver2">
</head>
<body>
	<div class="modal-background"></div>
	<section class="modal-wrap">
	<div class="data-wrap">
		<div class="img-wrap">
			<img src="#">
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
		<div class="dynamic-info-wrap">
			<p>^^Lorem ipsum dolor, sit amet consectetur adipisicing elit.
				Quae quibusdam expedita ipsam minus ducimus veritatis non iusto ea
				ipsum ut reprehenderit repudiandae magnam doloribus, veniam
				perspiciatis asperiores hic sapiente. Aperiam.</p>
			<p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Quae
				quibusdam expedita ipsam minus ducimus veritatis non iusto ea ipsum
				ut reprehenderit repudiandae magnam doloribus, veniam perspiciatis
				asperiores hic sapiente. Aperiam.</p>
			<p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Quae
				quibusdam expedita ipsam minus ducimus veritatis non iusto ea ipsum
				ut reprehenderit repudiandae magnam doloribus, veniam perspiciatis
				asperiores hic sapiente. Aperiam.</p>
			<p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Quae
				quibusdam expedita ipsam minus ducimus veritatis non iusto ea ipsum
				ut reprehenderit repudiandae magnam doloribus, veniam perspiciatis
				asperiores hic sapiente. Aperiam.</p>
		</div>
	</div>
	</section>
	<script id="template-modal-detail" type="text/template">
                <p id="template-modal-p">{description}</p>
        </script>
	<script id="template-modal-info" type="text.template">
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
	<script src="./../../hotel/js/modal.js?ver7"></script>
</body>
</html>