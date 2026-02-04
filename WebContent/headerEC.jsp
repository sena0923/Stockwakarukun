<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ストックかえる君</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/headerEC.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/EClist.css">
</head>
<body>
<header class="site-header">
    <div class="header-top">
        <div class="logo">
            <a>ストックかえる君</a>
        </div>
        <div class="user-actions">
            <a href="${pageContext.request.contextPath}/scoremanager/ECsite/CartExecute.action">カート</a>
        </div>
    </div>
    <nav class="main-nav">
        <ul>
        	<c:choose>

				<c:when test="${not empty resident}">
			        <a href="../../scoremanager/resident/NyuMenu.action">ホーム</a>
			    </c:when>

				<c:when test="${not empty selectedResident}">
			        <a href="../../scoremanager/relatives/SinMenu.action">ホーム</a>
			    </c:when>


			    <c:when test="${not empty relatives}">
			        <a href="../../scoremanager/relatives/SinMenu.action">ホーム</a>
			    </c:when>

			</c:choose>
		<!-- 入居者本人ログインを最優先 -->
		<!-- 親族が入居者を選んで代理操作中 -->
		<!-- 親族本人ログイン -->
            <li><a href="../../scoremanager/ECsite/AllExecute.action">すべて</a></li>
            <li><a href="../../scoremanager/ECsite/WashExecute.action">洗面用具</a></li>
            <li><a href="../../scoremanager/ECsite/TowelExecute.action">タオル類</a></li>
            <li><a href="../../scoremanager/ECsite/ClotExecute.action">衣類</a></li>
            <li><a href="../../scoremanager/ECsite/ColdExecute.action">防寒用具</a></li>
            <li><a href="../../scoremanager/ECsite/EquipmentExecute.action">備品・日用品</a></li>
            <li><a href="../../scoremanager/ECsite/EntertainmentExecute.action">娯楽</a></li>
            <li><a href="../../scoremanager/ECsite/NaireExecute.action">名入れ</a></li>
			<br><br>
            <li><a href="../../scoremanager/ECsite/PurchaseHistory.action">購入履歴</a></li>
        </ul>
    </nav>
</header>
