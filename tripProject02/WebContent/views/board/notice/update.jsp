<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<h4><html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<style type="text/css">
.row{
	margin: 0 auto;
}
h2 {
	text-align: center;
}
#update{
	margin: 0px auto;
	display: block;
	width: 800px;
	
}
</style>
<script type="text/javascript">
$(function(){
	$('#pwd2').keyup(function(){ // 유저가 뭔가 입력후 바로 체크 ==> keyup으로 체크 
		var k=$(this).val();
		console.log(k);
		var no=$('#no').val();	
		$.ajax({
			type:'POST',
			url:'../main/npassword_check.do', 
			data:{"pwd":k,"no":no}, // 요청과 함께 서버에 보내는 string 또는 json
			success:function(res) // success:  요청이 성공일때 실행되는 callback 함수
			{ 
				var no=res.trim();
				if(no==1){
					$('#pwd_check_result').html("<font color=blue>비밀번호가 맞습니다. 수정할 수 있습니다.</font>");
					$('#updateBtn').attr('disabled', false);
				}
				else
				{
					$('#pwd_check_result').html("<font color=red>비밀번호가 틀립니다.</font>");
					$('#updateBtn').attr('disabled', true);
				}
			},
			error:function(e){
				alert(e);
			}
		})
	});
});
</script>
</head>
<body>
<div class="breadcumb-area bg-img bg-overlay" style="background-image: url(../../template/css/img/bg-img/jeju.png)"></div>
<div class="wrapper row2">
  <div id="services" class="clear">
  <div style="width:1000px;height: 150px;margin-left:300px;">
			<img src="../../board/images/notice.png" style="text-align:center;width:100%; height:120px;"/></div>
	<div class="container">
		<div id="update">
			<form method=post action="nupdate_ok.do"> 
				<table class="table table-hover" style="width:80%; margin:0px auto;">
					<tr>
						<th width=20% class="text-right"style="background-color: #7643ea;">이름</th>
							<td width=80% data-name="${name }"><c:out value="${name }"></c:out>
							</td>
					</tr>
					<input type="hidden" name="no" id="no" value="${vo.no }">
					<tr>
						<th width=20% class="text-right"style="background-color: #7643ea;">제목</th>
						<td width=80%>
							<input type="text" name="subject" size=50 value="${vo.subject }" required />
						</td>
					</tr>
					<tr>
						<th width=20% class="text-right"style="background-color: #7643ea;">내용</th>
						<td width=80%>
							<textarea rows="8" cols="50" name="content" required>${vo.content }</textarea>
							<!-- input은 value로 주고, textarea는 태그 사이에 값 준다. -->
						</td>
					</tr>
					<tr>
						<td class="text-center" colspan="2">
							<input type="submit" value="수정" class="btn btn-sm btn-primary"
							id="updateBtn">
							<input type="button" value="취소" class="btn btn-sm btn-danger"
							onclick="javascript:history.back()">
						</td>
					</tr>
				</table>
			</form>
		</div>
		</div>
		</div>
		</div>
	</div>
</body>
</html></h4>