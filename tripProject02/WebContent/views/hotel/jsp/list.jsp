<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="./../../hotel/css/list.css?ver2">
</head>

<body>

	<nav class="hotel-nav">
		<ul>
			<li><select id="레이아웃♡행">
					<option value="1">한줄로 볼♡행</option>
					<option value="2">두줄로 볼♡행</option>
					<option value="3">세줄로 볼♡행</option>
			</select></li>
		</ul>
	</nav>
	<section class="list">

		<div class="list-count"></div>
		<ul>
			<li><a href="#"><img src="" alt=""></a></li>
			<div>
				<li><a href="">
						<div></div>
				</a></li>
				<li><a href="">
						<div></div>
				</a></li>
			</div>
		</ul>
		<div class="more-data">더 보기♡행</div>
	</section>
	<script id="template-list-items" type="text/template">
        <li name="{name}">
			<label class="evelPoint">{label}</label>
            <a ><img src="{img}" alt=""></a>
            <a ><div id="title">{title}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>{like}</span></div>
            <div id="info">{information}</div></a>
        </li>
    </script>
	<script src="./../../hotel/js/listConstructor.js?ver4"></script>
	<script src="./../../hotel/js/layout/listLayout.js"></script>
	<script src="./../../hotel/js/configuration/listConfiguration.js?ver1"></script>
	<script src="./../../hotel/js/ajax/ajax.js"></script>
	<script src="./../../hotel/js/getData/getDataForList.js"></script>
</body>

</html>