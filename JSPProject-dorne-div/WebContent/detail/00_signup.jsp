<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<div class="section-heading dark text-center">
				<span></span>
                <h4>회원가입</h4>
                <!-- <p>Editor’s pick</p> -->
                </div>
            </div>
            <div class="col-12">
            	<table class="dorne-table" width="100%">
            	<tr>
					<th width="40%" class="danger text-right">Email</th>
					<td width="5%">
					<td width="45%">
						<input type="text" name="id" size="15" class="input-sm" readonly>
						<input type="button" value="check" class="btn btn-sm btn-danger" onclick="idcheck()">
					</td>
				</tr>
				<tr height="10px">
					<td colspan="2">
					</td>
				</tr>
				<tr>
					<th width="40%" class="danger text-right">비밀번호</th>
					<td width="5%">
					<td width="55%" >
						<input type="password" name="pwd" size="15" class="input-sm">
					</td>
				</tr>
				<tr height="10px">
					<td colspan="2">
					</td>
				</tr>
				<tr>
					<th width="40%" class="danger text-right">비밀번호 확인</th>
					<td width="5%">
					<td width="55%" >
						<input type="password" name="pwd1" size="15" class="input-sm">
					</td>
				</tr>
				<tr height="10px">
					<td colspan="2">
					</td>
				</tr>
				<tr>
					<th width="40%" class="danger text-right">이름</th>
					<td width="5%">
					<td width="55%" >
						<input type="text" name="name" size="15" class="input-sm">
					</td>
				</tr>
				<tr height="10px">
					<td colspan="2">
					</td>
				</tr>
				<tr>
					<th width="40%" class="danger text-right">닉네임</th>
					<td width="5%">
					<td width="55%" >
						<input type="text" name="email" size="15" class="input-sm">
					</td>
				</tr>
				<tr height="10px">
					<td colspan="2">
					</td>
				</tr>
				<tr>
					<th width="40%" class="danger text-right">성별</th>
					<td width="5%">
					<td width="55%" >
						<input type="radio" name="sex" value="남자" checked="checked">남자
						<input type="radio" name="sex" value="여자">여자
					</td>
				</tr>
				<tr height="10px">
					<td colspan="2">
					</td>
				</tr>
				<tr>
					<th width="40%" class="danger text-right">생일</th>
					<td width="5%">
					<td width="55%" >
						<input type="date" name="birthday" size="50" class="input-sm">
					</td>
				</tr>
				<tr height="10px">
					<td colspan="2">
					</td>
				</tr>
				<tr>
					<th width="40%" class="danger text-right">전화번호</th>
					<td width="5%">
					<td width="55%" >
						<select class="input-sm" name="tel1">
							<option>010</option>
							<option>011</option>
							<option>017</option>
						</select>
						&nbsp;-&nbsp;
						<input type="text" name="tel2" size="5" class="input-sm">&nbsp;-&nbsp; 
						<input type="text" name="tel3" size="5" class="input-sm">
					</td>
				</tr>
				<tr height="10px">
					<td colspan="2">
					</td>
				</tr>
				<tr>
					<td colspan="3" class="text-center">
						<input type="button" value="가 입" class="dorne-btn"
								onclick="join()"
						>
						<input type="button" value="취 소" class="dorne-btn"
							   onclick="javascript:history.back()"
						>
					</td>
				</tr>
            	</table>
            </div>
		</div>
	</div>
	</section>
</body>
</html>