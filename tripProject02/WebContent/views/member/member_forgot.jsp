<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- ***** Breadcumb Area Start ***** -->
    <div class="breadcumb-area bg-img bg-overlay" style="background-image: url(../css/img/bg-img/jeju.png)"></div>
    <!-- ***** Breadcumb Area End ***** -->
    <br>
   	<br>
    <div class="login-wrap">
	<div class="login-html">
		<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">이메일찾기</label>
		<input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">비밀번호찾기</label>
		<div class="login-form">
			<form method="POST" action="member_forgot_email_ok.do" id="frm" name="frm">
			<div class="sign-in-htm">
				<div class="group">
					<input id="email" type="text" class="input" placeholder="이름" name="name" required="required">
				</div>
				<div class="group">
					<input id="pass" type="text" class="input" placeholder="생일 ( - 제외)" name="birth" required="required">
				</div>
				<div class="group">
					<input type="submit" class="button" value="이메일찾기" id="emailBtn">
				</div>
				<div class="hr"></div>
			</div>
			</form>
			
			<!-- <form name="frm" id="frm" action="../../member/member_join_ok.do" method="post">	 -->
			<!-- <form name="frm" id="frm" action="member_forgot_pwd_ok.do" method="post"> -->
			<form name="frm" id="frm" action="member_forgot_pwd_ok.do" method="post">
			<div class="sign-up-htm">
				<div class="group" >
					<input type="text" class="input" placeholder="Email" id="id" name="email" required="required" >					
				</div>			
				<div class="group">
					<input type="submit" value="비밀번호찾기" class="button" id="sendBtn">
				</div>
				<div class="hr"></div>
			</div>
			</form>
		</div>	
	</div>
</div>
</body>
</html>