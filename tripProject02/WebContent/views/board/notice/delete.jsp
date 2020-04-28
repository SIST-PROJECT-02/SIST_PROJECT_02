<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h4><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#delete{
	margin: 0px auto;
	display: block;
	width: 300px;
	
}
</style>
</head>
<body>
	<div class="breadcumb-area bg-img bg-overlay"
		style="background-image: url(../../template/css/img/bg-img/jeju.png)"></div>
	<div class="wrapper row2">
		<div id="services" class="clear">
		<div class="text-center">
  		<img src="../../board/images/notice.jpeg">
  	</div> 
			<div class="wrapper row2">
				<div id="services" class="clear">
					
					<div class="row" id="delete">
						<form method=post action="ndelete_ok.do">
							<table class="table">
								<tr>
									<th class="text-right success" width=25%>비밀번호</th>
									<td width=75%><input type="password" name=pwd size=15>
										<input type="hidden" name=no value="${no }"></td>
								</tr>
								<tr>
									<td colspan="2" class="text-center"><input type="submit"
										class="btn btn-sm btn-primary" value="삭제"> <input
										type="button" class="btn btn-sm btn-danger" value="취소"
										onclick="javascript:history.back()"></td>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>
</html></h4>