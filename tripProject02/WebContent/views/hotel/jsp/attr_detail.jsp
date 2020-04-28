<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper row2">
  <div id="services" class="clear"> 
    <!-- ################################################################################################ -->
    <div class="row">
      <c:if test="${count!=0 }">
	      <div class="thumbnail">
	        <img src="${vo.thumb }" alt="Lights" style="width:800px;height:350px">
	        <div class="caption">
	          <p class="text-center"><img src="${vo.thumb }" width=50 height="50" class="img-circle"></p>
	         
	        </div>
	      </div>
	      <table class="table">
	        <tr>
	          <td class="text-center" colspan="3">
	           <b>${vo.title }</b>
	          </td>
	        </tr>
	        <tr>
	          <td class="text-center" colspan="3">
	           <font color="#999">${vo.description }</font>
	          </td>
	        </tr>
	 
	        <tr>
	          <td class="text-center">${vo.web }</td>
	          <td class="text-center">${vo.convenience }</td>
	          <td class="text-center">${vo.address }</td>
	          <td class="text-center">${vo.road_address }</td>
	          <td class="text-center">${vo.tel }</td>
	       
	        </tr>
	        <tr>
	          <td colspan="3">
	            <c:forTokens items="${vo.attrmake }" delims="@" var="s">
	             ${s }<br>
	            </c:forTokens>
	            
	          </td>
	        </tr>
	      </table>
	      <table class="table">
	        <caption><h3>관광지</h3></caption>
	        <tr>
	          <td width="30%" class="text-center" rowspan="2">
	           <img src="${vo.thmb }" style="width:45px;height:45px" class="img-circle">
	          </td>
	          <td width="70%">${vo.title }</tr>
	        </tr>
	        
	      </table>
      </c:if>
      <c:if test="${count==0 }">
         <h1 class="text-center">정보가 없습니다!</h1>
      </c:if>
    </div>
  </div>
 </div>
</body>
</html>