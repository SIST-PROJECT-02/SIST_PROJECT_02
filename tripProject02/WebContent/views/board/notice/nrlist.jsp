<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('.nrlist').hover(function(){
		$(this).css('cursor','pointer');
	},function(){
		$(this).css('cursor','none');
	});
	
	$('.nrlist').click(function(){
		$('#nrname').text($(this).text());
		$('#movie-score').text($(this).attr('data-score'));
		$('#mno').val($(this).attr('data-mno'));
		var tno=$(this).attr("data-theater");
		$.ajax({
			type:'post',
			url:'theater.do',
			data:{"tno":tno},
			success:function(res)
			{
				$('#movie-theater').html(res);
			}
		})
	});
})
</script>
<title>Insert title here</title>
</head>
<body>
  <div class="row" style="margin: 0px auto;width:350px;height:500px">
    <table class="table">
      <c:forEach var="vo" items="${nrList }">
        <tr>
         <td>
           ${vo.name }"
         </td>
         <td class="nrlist" data-name="${vo.name }" data-date="${regdate }" data-bno="${vo.bno }" data-no="${vo.no }">${vo.title }</td>
        </tr>
      </c:forEach>
    </table>
  </div>
</body>
</html>







