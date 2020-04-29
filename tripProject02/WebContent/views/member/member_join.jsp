<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link rel="stylesheet" href="../../../shadow/css/shadowbox.css">
<script type="text/javascript" src="../../../shadow/js/shadowbox.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
Shadowbox.init({
	players:['iframe']
});
var i=0;
$(function(){
	
	$('#checkBtn').click(function(){
		Shadowbox.open({
			content:'../../member/member_checkid.do',
			title:'아이디 중복체크',
			player:'iframe',
			width:390,
			height:200
		})
		i=1;
	})
	
	$('#pwd2').blur(function(){
		if($('#pwd1').val()!=$('#pwd2').val())
		{
			if($('pwd2').val()!=''){
				$('#result2').html("<font color=red>비밀번호가 일치하지않습니다.</font>");
				$('#pwd1').val('');
				$('#pwd2').val('');
				$('#pwd1').focus();
			}
		}
		else
		{
			$('#result2').html("<font color=blue>비밀번호가 일치합니다.</font>");
		}	
	})
	
	$('#logBtn').click(function(){
		
		let email=$('#email').val();
		if(email.trim()=="")
		{
			$('#email').focus();
			return;
		}
		let pwd=$('#pwd').val();
		if(pwd.trim()=="")
		{
			$('#pwd').focus();
			return;
		} 

		 $.ajax({
			type:'POST',
			url:'../../member/member_login.do',
			data:{"email":email, "pwd":pwd},
			success:function(res){
				if(res.trim()=='NOID')
				{
					alert("아이디가 존재하지 않습니다. 확인후 재입력 부탁드립니다.")
					$('#email').val("");
					$('#pwd').val("");
					$('#email').focus();
				}
				else if(res.trim()=='NOPWD')
				{
					alert("비밀번호가 틀립니다. 확인후 재입력 부탁드립니다.")
					$('#pwd').val("");
					$('#pwd').focus();
				}
				else
				{
					location.href="../../template/main/mainPage.do";
				}
			},
			error:function(e){
				alert("로그인에러발생");
			}
		}) 
	})
})
</script>
</head>
<body>
    <!-- ***** Breadcumb Area Start ***** -->
    <div class="breadcumb-area bg-img bg-overlay" style="background-image: url(../css/img/bg-img/jeju.png)"></div>
    <!-- ***** Breadcumb Area End ***** -->
    <br>
   	<br>
    <div class="login-wrap">
	<div class="login-html">
		<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">로그인</label>
		<input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">회원가입</label>
		<div class="login-form">
			<form method="POST" action="../../member/member_login.do" id="log_frm" name="log_frm">
			<div class="sign-in-htm">
				<div class="group">
					<input id="email" type="text" class="input" placeholder="Email" name="email">
				</div>
				<div class="group">
					<input id="pwd" type="password" class="input" data-type="password" placeholder="비밀번호" name="pwd">
				</div>
				<div class="group">
					<input type="button" class="button" value="로그인" id="logBtn">
				</div>
				<div class="hr"></div>
				<div class="foot-lnk">
					<a href="member_forgot.do">회원정보를 잊으셨나요?</a>
				</div>
			</div>
			</form>
			
			<!-- <form name="frm" id="frm" action="../../member/member_join_ok.do" method="post">	 -->
			<form name="frm" id="frm" action="member_join_ok.do" method="post">
			<div class="sign-up-htm">
				<div class="group" >
					<input type="text" class="input" placeholder="Email" id="id" name="email" required="required" readonly>					
				</div>	
				<div class="group" >
					<input type="button" value="중복확인" class="button" id="checkBtn" >
				</div>				
				<div class="group">
					<input type="password" name="pwd1" class="input" id="pwd1" placeholder="비밀번호" required="required">
					<span id=result1>
					</span>
				</div>
				<div class="group">
					<input type="password" name="pwd2" class="input" id="pwd2" placeholder="비밀번호 확인" required="required">
					<span id=result2>
					</span>
				</div>
				<div class="group">
					<input id="pass" type="text" class="input" placeholder="이름" name="name" required="required">
				</div>
       			 <div class="group">
					<input id="pass" type="text" class="input" placeholder="닉네임" name="nick" required="required">
				</div>
        		<div class="group" style="text-align: center" >
					<input type="radio" name="gender" value="남자" checked="checked">남자
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="gender" value="여자">여자
				</div>
        		<div class="group">
					<input id="pass" type="text" class="input" placeholder="생일 ( - 제외)" name="birth" required="required">
				</div>
        		<div class="group">
					<input id="pass" type="text" class="input" placeholder="전화번호 ( - 제외)" name="tel" required="required">
				</div>
				<div class="group">
					<input type="submit" value="회원가입" class="button" id="sendBtn">
				</div>
				<div class="hr"></div>
			</div>
			</form>
		</div>	
	</div>
</div>
</body>
</html>