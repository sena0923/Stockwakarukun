<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>購入完了</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/complete.css">
</head>
<body>

<h2>購入が完了しました</h2>
<p>ご利用ありがとうございました。</p>

<div class="back-home">
    <c:choose>


	    <c:when test="${not empty resident}">
	        <a href="../../scoremanager/resident/NyuMenu.action">ホームへ戻る</a>
	    </c:when>


	    <c:when test="${not empty selectedResident}">
	        <a href="../../scoremanager/relatives/SinMenu.action">ホームへ戻る</a>
	    </c:when>


	    <c:when test="${not empty relatives}">
	        <a href="../../scoremanager/relatives/SinMenu.action">ホームへ戻る</a>
	    </c:when>

	</c:choose>
	<!-- 入居者本人ログインを最優先 -->
	<!-- 親族が入居者を選んで代理操作中 -->
	<!-- 親族本人ログイン -->
</div>

</body>
</html>