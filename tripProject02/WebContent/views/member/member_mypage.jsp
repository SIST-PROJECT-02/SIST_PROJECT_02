<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
	<section class="dorne-listing-destinations-area section-padding-100-50">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div>
					<span></span>
	                <h4></h4>
	                </div>
	            </div>
			</div>
		</div>
	</section>	
		<!--  
			EMAIL  NOT NULL VARCHAR2(45) 
			PWD    NOT NULL VARCHAR2(20) 
			NAME   NOT NULL VARCHAR2(20) 
			NICK   NOT NULL VARCHAR2(51) 
			GENDER NOT NULL VARCHAR2(30) 
			BIRTH           VARCHAR2(30) 
			TEL    NOT NULL VARCHAR2(45) 
			ADMIN           NUMBER(5)    
		-->
	
<div class="login-wrap">
	<div class="login-html">
		<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">정보수정</label>
		<input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">회원탈퇴</label>
		<div class="login-form">
			<form method="POST" action="member_update.do?email=${email }" id="log_frm" name="log_frm">
				<div class="sign-in-htm">
				<div class="group" >
					<label style="width:30%; float:left; text-align:left; margin:5px;">Email</label>
					<input type="text" class="input" id="id" name="email" required="required" readonly style="width:67%; float: rigth;" value="${vo.email }"> 				
				</div>					
				<div class="group">
					<label style="width:30%; float:left; text-align: left; margin:5px;">비밀번호 </label>
					<input type="password" name="pwd1" class="input" id="pwd1" required="required" style="width:67%; float: rigth;">
					<span id=result1> 
					</span>
				</div>
				<div class="group">
					<label style="width:30%; float:left; text-align: left; margin:5px;">비밀번호 확인 </label>
					<input type="password" name="pwd2" class="input" id="pwd2" required="required" style="width:67%; float: rigth;">
					<span id=result2>
					</span>
				</div>
				<div class="group">
					<label style="width:30%; float:left; text-align: left; margin:5px;">이름 </label>
					<input id="pass" type="text" class="input" name="name" required="required" style="width:67%; float: rigth;" value="${vo.name }">
				</div>
       			<div class="group">
       			 	<label style="width:30%; float:left; text-align: left; margin:5px;">닉네임 </label>
					<input id="pass" type="text" class="input" name="nick" required="required" style="width:67%; float: rigth;" value="${vo.nick }">
				</div>
        		<div class="group" style="text-align: center" >
					<input type="radio" name="gender" value="남자" checked="checked">남자
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="gender" value="여자">여자
				</div>
        		<div class="group">
        			<label style="width:30%; float:left; text-align: left; margin:5px;">생일 </label>
					<input id="pass" type="text" class="input" name="birth" required="required" style="width:67%; float: rigth;" value="${vo.birth }">
				</div>
        		<div class="group">
        			<label style="width:30%; float:left; text-align: left; margin:5px;">전화번호 </label>
					<input id="pass" type="text" class="input" name="tel" required="required" style="width:67%; float: rigth;" value="${vo.tel }">
				</div>
				<div class="group">
					<input type="submit" value="회원정보수정" class="button" id="updateBtn">
				</div>
				</div>
			</form>
			<form name="frm" id="frm" action="member_delete.do" method="post">	
				<div class="sign-up-htm">
					<div class="group">
						<input id="email" type="text" class="input" name="email" value="${vo.email }" readonly>
					</div>
					<div class="group">
						<input id="pwd" type="password" class="input" data-type="password" placeholder="비밀번호" name="pwd">
					</div>
					<div class="group">
						<input type="submit" class="button" value="회원탈퇴" id="deleteBtn">
					</div>
				</div>
			</form>
		</div>
	</div>
	</div>
</body>
</html>