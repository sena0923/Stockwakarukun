<%-- 親族アカウント情報表示画面 --%>
<%-- 介護士アカウント情報表示画面 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../../baseSin.jsp">
	<c:param name="title">
		アカウント表示
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/info.css">
	</c:param>

	<c:param name="content">
		<form class="container" action="SinInformationChange.action" method="get">
			<a href="SinMenu.action" class="back">戻る</a>

			<h1>アカウント情報</h1>


			<div class="controll">
			<a class="">名前: ${relatives.name}</a>
			<br>
			<a class="">入居者: ${resident.name}</a>
			<br>
			<a class="">メールアドレス: ${relatives.e_mail}</a>
			<br>

			<a class="">ログインID: ${relatives.rt_id}</a>
			<br>

			<a class="">パスワード：${relatives.password}</a>
	        </div>


	        <div class="button-group">
	            <button class="btn-info" type="submit">変更</button>

			</div>
		</form>
	</c:param>
</c:import>

