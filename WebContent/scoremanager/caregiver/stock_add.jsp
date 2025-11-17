<%-- 介護士用　ストックの備品追加入力画面 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../../baseKai.jsp">
	<c:param name="title">
		ストック備品追加入力
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
	</c:param>

	<c:param name="content">
		<form class="content" action="Kai_stockAddExecute.action" method="get">
			<h1>介護士ログイン</h1>



			<div class="controll">
			<label for="">ストック名</label>
			<input type="text" id="" name="" required>
			</div>

			<div class="controll">
			<label for="">個数</label>
				<input type="text" id="" name="" required>
			</div>



	        <!-- 入力欄のすぐ下に配置 -->
	        <div class="button-group">
	            <button class=btn type="submit">ログイン</button>
	            <a href="cg_create.jsp" class="btn">新規登録画面へ</a>
			</div>
		</form>
	</c:param>
</c:import>

