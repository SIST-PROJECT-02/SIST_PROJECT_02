<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:if test="${bCheck==true }">
	<c:redirect url="../main/memberdelete_ok.do" />
</c:if>

<c:if test="${bCheck==false }">
	<script>
		alert("회원정보가 일치하지않습니다. 확인후 다시 입력부탁드립니다.");
		history.back();
	</script>
</c:if>