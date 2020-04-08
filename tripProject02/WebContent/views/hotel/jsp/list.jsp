<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="./../../hotel/css/list.css?ver1">
</head>

<body>
	<section class="list">
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
            <a href="#"><img src="{img}" alt=""></a>
            <a href="#"><div>{title}</div>
            <div>{information}</div></a>
        </li>
    </script>
	<script src="./../../hotel/js/listConstructor.js?ver1"></script>
	<script src="./../../hotel/js/listLayout.js"></script>
</body>

</html>