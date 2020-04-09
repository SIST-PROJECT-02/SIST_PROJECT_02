<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./../css/sliding.css">
</head>

<body>
    <section class="sliding-wrap">
        <ul class="sliding-item">

        </ul>
        <a href="#" class="sliding-left-arrow pos-absolute">
            <img src="./../img/left-arrow.png" alt="">
        </a>
        <a href="#" class="sliding-right-arrow pos-absolute">
            <img src="./../img/right-arrow.png" alt="">
        </a>
        <div class="sliding-check-box pos-absolute">
            <ul class="sliding-check-items">
                <li><a href="#">
                        <img src="./../img/check-off.png" alt="">
                    </a></li>
            </ul>
        </div>
    </section>

    <script id="template-sliding-check-item" type="text/template">
            <li><a href="#">
                <img src="./../img/{img-kind}" class = "{class}" alt="">    
            </a></li>

        </script>
        <script id="template-sliding-items" type="text/template">
            <li name="{name}">
                <a href="#"><img src="{img}" alt=""></a>
                <a href="#"><div>"{title}"</div></a>
                <a href="#"><div>"{information}"</div></a>
            </li>
        </script>
    <script src="./../js/sliding.js"></script>
</body>

</html>