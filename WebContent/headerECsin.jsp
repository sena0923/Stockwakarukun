<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        	<li class="nav-home"><a href="../../scoremanager/relatives/SinMenu.action">ホームへ</a></li>
            <li><a href="../../scoremanager/ECsite/AllExecute.action">すべて</a></li>
            <li><a href="../../scoremanager/ECsite/WashExecute.action">洗面用具</a></li>
            <li><a href="../../scoremanager/ECsite/TowelExecute.action">タオル類</a></li>
            <li><a href="../../scoremanager/ECsite/ClotExecute.action">衣類</a></li>
            <li><a href="../../scoremanager/ECsite/ColdExecute.action">防寒用具</a></li>
            <li><a href="../../scoremanager/ECsite/EquipmentExecute.action">備品・日用品</a></li>
            <li><a href="../../scoremanager/ECsite/EntertainmentExecute.action">娯楽</a></li>
        </ul>
    </nav>
</header>
