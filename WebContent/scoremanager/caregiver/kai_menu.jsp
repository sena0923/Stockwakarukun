<%-- 介護士メニューJSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../../baseKai.jsp">
	<c:param name="title">
		ストックわかるくん
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/menu.css">
	</c:param>

	<c:param name="content">
		<section class="container">
			<h2 class="menu-title">メニュー</h2>
			<div class="menu-grid">
            <div class="menu-item">
				<a href="RdList.action">入居者一覧</a>
            </div>
            <div class="menu-item">
				<a href="Kai_account.action">マイページ</a>
            </div>
        </div>

		</section>
	</c:param>
</c:import>