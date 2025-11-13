<%-- 介護士メニューJSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../../base.jsp">
	<c:param name="title">
		ストックわかるくん
	</c:param>

	<c:param name="scripts"></c:param>

	<c:param name="content">
		<section class="menu-container">
			<h2 class="menu-title">メニュー</h2>
			<div class="menu-grid">
            <div class="menu-item">
				<a href="入居者一覧.jsp">入居者一覧</a>
            </div>
            <div class="menu-item">
				<a href="情報変更.jsp">マイページ</a>
            </div>
        </div>

		</section>
	</c:param>
</c:import>