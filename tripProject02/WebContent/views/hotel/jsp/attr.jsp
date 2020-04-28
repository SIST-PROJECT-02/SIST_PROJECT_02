<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
      <c:forEach var="vo" items="${list }">
        <div class="col-md-5">
		    <div class="thumbnail">
		     <%--  <a href="../recipe/recipe_detail.do?no=${vo.no }"> --%>
		        <img src="${vo.thumb }" alt="Lights" style="width:100%">
		        <div class="caption">
		          <p>${vo.title }</p>
		          <p><sub style="color:red">${vo.introduction }</sub></p>
		        </div> 
		    </div>
		  </div>
      </c:forEach>
    </div>
    <!-- ################################################################################################ -->
    <div class="clear"></div>
    <div class="text-center">
       <ul class="pagination">
          <c:if test="${startPage>1 }">
            <li><a href="../views/template/main/attr.do?page=${startPage-1 }">&lt;</a></li>
          </c:if>
          <c:set var="type" value=""/>
          <c:forEach var="i" begin="${startPage }" end="${endPage }">
            <c:if test="${curpage==i }">
              <c:set var="type" value="class=active"/>
            </c:if>
            <c:if test="${curpage!=i }">
              <c:set var="type" value=""/>
            </c:if>
            <li ${type }><a href="../views/template/main/attr.do?page=${i}">${i}</a></li>
          </c:forEach>
          <c:if test="${endPage<allPage }">
		   <li><a href="../views/template/main/attr.do?page=${endPage+1 }">&gt;</a></li>
		  </c:if>
		</ul>
    </div>
  </div>
</div>

</body>
</html>