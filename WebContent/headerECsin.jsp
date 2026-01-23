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
            <a href="../../scoremanager/ECsite/CartExecute.action">カート</a>
        </div>
    </div>
    <nav class="main-nav">
        <ul>
        	<li class="nav-home">
			    <c:choose>


			        <c:when test="${not empty selectedResident}">
			            <a href="../../scoremanager/relatives/SinMenu.action">ホーム</a>
			        </c:when>

			    </c:choose>
			</li>
            <li><a href="../../scoremanager/ECsite/AllsinExecute.action">すべて</a></li>
            <li><a href="../../scoremanager/ECsite/WashsinExecute.action">洗面用具</a></li>
            <li><a href="../../scoremanager/ECsite/TowelsinExecute.action">タオル類</a></li>
            <li><a href="../../scoremanager/ECsite/ClotsinExecute.action">衣類</a></li>
            <li><a href="../../scoremanager/ECsite/ColdsinExecute.action">防寒用具</a></li>
            <li><a href="../../scoremanager/ECsite/EquipmentsinExecute.action">備品・日用品</a></li>
            <li><a href="../../scoremanager/ECsite/EntertainmentsinExecute.action">娯楽</a></li>
        </ul>
    </nav>
</header>
