<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bCheck==true }">
	<c:redirect url="member_delete_ok.do"/>
</c:if>

<c:if test="${bCheck==false }">
	<script>
		alert("비밀번호가 일치하지 않습니다. 확인후 재입력 부탁드립니다. ");
		history.back();
	</script>
</c:if>