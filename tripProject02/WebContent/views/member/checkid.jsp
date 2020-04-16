<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row{
	margin: 0px auto;
	width: 350px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#email').focus();
	$('#checkBtn').click(function(){
		let email=$('#email').val();
		if(email.trim()=="")
		{
			$('#email').focus();
			return;
		}
		
		$.ajax({
			type:'POST',
			url:'../member/checkid_ok.do',
			data:{"email":email},
			success:function(result){
				let count=result.trim();
				if(count==0)
				{
					let msg='<font color=blue><b>'+email+'는(은) 사용가능합니다.</b></font>'	;
					$('#result').html(msg);
					$('#ok2').attr('disabled',false);
				}
				else if(count==1)
				{
					let msg='<font color=red><b>'+email+'는(은) 이미 사용중입니다.</b></font>';
					$('#result').html(msg);
					$('#ok2').attr('disabled',true);
				}
			},
			error:function(e){
				alert("아이디중복체크오류발생");
			}
		})
	});
});

function ok()
{
	let email=$('#email').val();
	parent.frm.email.value=email;
	parent.Shadowbox.close();
};
</script>
</head>
<body>
<div class="container">
	<div class="row">
		<table style="margin: 0px auto">
			<tr>
				<td>
					입력:<input type=text id=email class=input-sm size=15>
						<input type=button value=이메일체크 class="btn btn-sm btn-primary" id=checkBtn>
				</td>
			</tr>
			<tr>
				<td class="text-center">
					<span id=result></span>
				</td>
			</tr>
			<tr>
				 <td class="text-center" id="ok">
				 <input type=button value=회원가입 class="btn btn-sm btn-primary" disabled="disabled" id=ok2 onclick="ok()">
				</td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>