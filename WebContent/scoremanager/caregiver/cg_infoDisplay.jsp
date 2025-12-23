<%-- 介護士アカウント情報表示画面 --%>

<%-- 介護士ログイン画面 --%>
<%-- ログインJSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../../baseKai.jsp">
	<c:param name="title">
		アカウント表示
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/info.css">
	</c:param>

	<c:param name="content">
		<form class="container" action="Kai_infoChange.action" method="get">
			<a href="KaiMenu.action" class="back">戻る</a>

			<h1>アカウント情報</h1>


			<div class="controll">
			<a class="">職員番号：${caregiver.staffid}</a>
			<br>
			<a class="">職員名：${caregiver.name}</a>
			<br>
			<a class="">パスワード：${caregiver.password}</a>
	        </div>


	        <div class="button-group">
				<input type="hidden" name="cg_num" value="${caregiver.staffid}">
	            <button class="btn-info" type="submit">変更</button>

			</div>
		</form>
	</c:param>
</c:import>
