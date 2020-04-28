<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
						<h2>회원탈퇴가 완료되었습니다.</h2>
		                <!-- <h4>회원탈퇴가 완료되었습니다.</h4> -->
		                <!-- <h2>그동안 여행복행을 이용해주셔서 감사합니다.</h2> -->
		                &nbsp;
		                <h4>그동안 여행복행을 이용해주셔서 감사합니다.</h4>
		                <p>더 나은 여행복행이 되도록 노력하겠습니다.</p>
		                <br>
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