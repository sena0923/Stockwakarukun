<%-- サイドバー --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/navigation.css">

<div class="navigation">

	<ul class="">
		<li class="nav-item"><a href="RdList.action">入居者一覧</a></li>
		<li class="nav-item"><a href="Kai_account.action">マイページ</a></li>
		<li class="nav-item"><a href="logout.jsp">ログアウト</a></li>
	</ul>
</div>