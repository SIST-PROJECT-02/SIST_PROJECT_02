<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Favicon -->
<link rel="icon" href="../css/img/core-img/favicon.ico">

<!-- Core Stylesheet -->
<link href="../css/style.css?v<%=System.currentTimeMillis()%>" rel="stylesheet">

<!-- Responsive CSS -->
<link href="../css/css/responsive/responsive.css" rel="stylesheet">
</head>
<body>
  <!-- ***** Search Form Area ***** -->
    <div class="dorne-search-form d-flex align-items-center">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="search-close-btn" id="closeBtn">
                        <i class="pe-7s-close-circle" aria-hidden="true"></i>
                    </div>
                    <form action="#" method="get">
                        <input type="search" name="caviarSearch" id="search" placeholder="Search Your Desire Destinations or Events">
                        <input type="submit" class="d-none" value="submit">
                    </form>
                </div>
            </div>
        </div>
    </div>

<!-- ***** Header Area Start ***** -->
    <header class="header_area" id="header">
        <div class="container-fluid h-100">
            <div class="row h-100">
                <div class="col-12 h-100">
                    <nav class="h-100 navbar navbar-expand-lg">
                    	<div id="logo">
                        	<a href="../../template/main/mainPage.do"><img src="../../airplane/img/logo.png" alt=""></a>
                        </div>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#dorneNav" aria-controls="dorneNav" aria-expanded="false" aria-label="Toggle navigation" ><span class="fa fa-bars"></span></button>
                        <!-- Nav -->
                        <div class="collapse navbar-collapse" id="dorneNav" style="margin-left: 120px;">
                            <ul class="navbar-nav mr-auto" id="dorneMenu">
                                <li class="nav-item active">
                                    <a class="nav-link" href="../../template/main/mainPage.do">Home <span class="sr-only">(current)</span></a>
                                </li>
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">여행정보<i class="fa fa-angle-down" aria-hidden="true"></i></a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                        <a class="dropdown-item" href="guidebook_safe.do">안전·안심관광가이드</a>
                                        <a class="dropdown-item" href="guidebook_guide.do">제주가이드북</a>
                                        <a class="dropdown-item" href="guidebook_map.do">제주관광지도</a>
                                    </div>
                                </li>
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">여행상품정보<i class="fa fa-angle-down" aria-hidden="true"></i></a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                        <a class="dropdown-item" href="airplane.do">항공</a>
                                        <a class="dropdown-item" href="staying.do">숙소</a>
                                        <a class="dropdown-item" href="tour.do">관광지</a>
                                    </div>
                                </li>
                           <!--      <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">여행플랜<i class="fa fa-angle-down" aria-hidden="true"></i></a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                                        <a class="dropdown-item" href="index.jsp?mode=6">항공</a>
                                        <a class="dropdown-item" href="index.jsp?mode=7">숙소</a>
                                        <a class="dropdown-item" href="index.jsp?mode=8">관광지</a>
                                    </div>
                                </li> -->
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">커뮤니티<i class="fa fa-angle-down" aria-hidden="true"></i></a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                                        <a class="dropdown-item" href="notice.do">공지사항</a>
                                        <a class="dropdown-item" href="free.do">자유게시판</a>
                                        <a class="dropdown-item" href="qna.do">Q&A</a>
                                    </div>
                                </li>
                                <!-- <li class="nav-item">
                                    <a class="nav-link" href="index.jsp?mode=13">고객센터</a>
                                </li> -->
                                <c:if test="${sessionScope.email!=null && admin==0}">
                                <li class="nav-item dropdown">
									<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">마이페이지<i class="fa fa-angle-down" aria-hidden="true"></i></a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                                        <a class="dropdown-item" href="member_mypage.do?email=${email }">정보수정 / 탈퇴</a>
                                        <a class="dropdown-item" href="member_like.do?email=${email }">즐겨찾기</a>
                                        <a class="dropdown-item" href="member_reservation.do">예약확인</a>
                                    </div>
								</li>
								</c:if>
								<c:if test="${sessionScope.email!=null && admin==1 }">
								 	<li class="nav-item dropdown">
										<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">마이페이지<i class="fa fa-angle-down" aria-hidden="true"></i></a>
	                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
	                                        <a class="dropdown-item" href="member_admin_reservation.do">예약 관리</a>
	                                    </div>
                                    </li>
								</c:if>
                            </ul>
                            <!-- Search btn -->
                            <!-- <div class="dorne-search-btn">
                                <a id="search-btn" href="#"><i class="fa fa-search" aria-hidden="true"></i>검색</a>
                            </div> -->
                            <!-- Register btn -->
                            <c:if test="${sessionScope.email==null }"> 
	                            <div class="dorne-signin-btn">
	                                <a href="member_join.do">로그인 / 회원가입</a>
	                            </div>
                            </c:if>
                            <c:if test="${sessionScope.email!=null }">
	                            <form method="post" action="member_logout.do">
	                            	<div class="collapse navbar-collapse" id="dorneNav">
										<span style="display: inline-block;">
											<font color="white">${sessionScope.name } 님</font>
										</span>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="submit" class="btn btn-sm btn-primary" value="로그아웃">
									</div>			
								</form>	
							</c:if>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </header>
<!-- ***** Header Area End ***** -->
</body>
</html>