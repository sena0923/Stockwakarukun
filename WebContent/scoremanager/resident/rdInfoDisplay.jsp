<%-- 入居者アカウント情報表示画面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../../baseNyu.jsp">
	<c:param name="title">
		介護士アカウント表示
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/info.css">
	</c:param>

	<c:param name="content">
		<form class="container" action="#" method="get">
			<a href="NyuMenu.action" class="back">戻る</a>

			<h1>アカウント情報</h1>

			<div class="controll">
			<a class="">入居者名：${resident.name}</a>
			<br>
			<a class="">パスワード：${resident.password}</a>
	        </div>


	        <div class="button-group">
				<a href="rdInfoChange.jsp" class="btn-info">変更</a>

			</div>
		</form>
	</c:param>
</c:import>
