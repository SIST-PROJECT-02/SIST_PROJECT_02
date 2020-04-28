<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:choose>

	<c:when test="${email eq null }">
		<script>
			alert("일치하는 회원정보를 찾을 수 없습니다. 확인 후 재입력 부탁드립니다.");
			history.back();
		</script>		
	</c:when>
	
</c:choose>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#mainBtn').click(function(){
		location.href="../main/index.jsp";
	})
})
</script>
</head>
<body>
<!-- ***** Breadcumb Area Start ***** -->
    <div class="breadcumb-area bg-img bg-overlay" style="background-image: url(../css/img/bg-img/jeju.png)"></div>
    <!-- ***** Breadcumb Area End ***** -->
	<section class="dorne-listing-destinations-area section-padding-100-50">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="section-heading dark text-center">
						<span></span>
						<h2>아이디찾기가 완료되었습니다.</h2>
		                <div>
			                <p>회원님의 아이디는</p>
			                <h4 style="margin:15px 0px;">${email }</h4>
			                <p>입니다.</p>
		                </div>
		                <div class="group">
							<input type="submit" class="btn dorne-btn" value="여행복행 메인화면" id="mainBtn">
						</div>
	                </div>
	            </div>
			</div>
		</div>
	</section>	
</body>
</html>