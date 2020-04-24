<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./../../hotel/css/sliding.css?ver1">
</head>

<body>
    <section class="sliding-wrap">
        <ul class="sliding-item">
        </ul>
        <a href="#" class="sliding-left-arrow pos-absolute">
            <img src="./../../hotel/img/left-arrow.png" alt="">
            <img src="" alt="">
        </a>
        <a href="#" class="sliding-right-arrow pos-absolute">
             <img src="./../../hotel/img/right-arrow.png" alt=""> 
            <img src="" alt="">
        </a>
        <div class="sliding-check-box pos-absolute">
            <ul class="sliding-check-items">
                <li>
                	<a href="#">
                        <img src="./../../hotel/img/stop-btn.png" alt="">
                    </a>
                </li>
            </ul>
        </div>
    </section>

    <script id="template-sliding-check-item" type="text/template">
            <li><a>
                <img src="./../img/{img-kind}" class = "{class}" alt="">    
            </a></li>

        </script>
        <script id="template-sliding-items" type="text/template">
            <li name="{name}">
                <a><img src="{img}" alt=""></a>
                <a><div>{title}</div></a>
                <a><div>{information}</div></a>
            </li>
        </script>
    <script src="./../../hotel/js/sliding.js?ver5"></script>
    <script src="./../../hotel/js/configuration/slidingConfiguration.js"></script>
    <script src="./../../hotel/js/getData/getDataForSliding.js"></script>
</body>

</html>