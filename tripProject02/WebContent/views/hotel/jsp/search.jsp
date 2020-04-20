<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./../../hotel/css/search.css?ver1"/>
<link href="https://fonts.googleapis.com/css2?family=Gugi&family=Jua&family=Yeon+Sung&display=swap" rel="stylesheet">
</head>
<body>
	<aside class="search-wrap">
        <div class="search-subjext">검색 및 정렬</div>
        <div class="search-data-wrap">
            <div class="text-search">
                검색 : <input type="text" name="text-search" placeholder="검색♡행">
            </div>
            <div class="sort-search">
                정렬 :
                <select id="sort-search-wrap">
                    <option value="1">평점순 <span class="char-col">▼</span></option>
                    <option value="2">평점순 <span class="char-col">▲</option>
                    <option value="3">인기순 <span class="char-col">▼</option>
                    <option value="4">인기순 <span class="char-col">▲</option>
                </select>
            </div>
            <div class="submit-search">Click</div>
        </div>
    </aside>
    <script src="./../../hotel/js/search.js?ver3"></script>
</body>
</html>