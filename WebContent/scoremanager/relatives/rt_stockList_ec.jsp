<%-- 介護士用　入居者ストック管理画面 --%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="../../baseSin.jsp">
	<c:param name="title">
		入居者ストック管理画面
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/stock_phone.css">
	</c:param>

	<c:param name="content">
		<form class="container">
		<a class="back-con" href="SinMenu.action">戻る</a>


			<h1>ストック管理画面</h1>
			<h2>${resident.name}さん</h2>

			<div class="tab-container">
				<a class="type_list non" href="Sin_stockList.action?rt_id=${relatives.rt_id}">個人ストック</a>
				<a class="type_list">ECサイトストック</a>
			</div>

			<table class="table">
				<tr>
					<th>ストック名</th>
					<th>在庫数</th>
					<th>最終更新日</th>
				</tr>
			<c:forEach var="iiList" items ="${iiList}">
				<tr>
					<td>${iiList.goods.goods_name}</td>
					<td>${iiList.goods_inve_count}</td>
					<td><fmt:formatDate value="${iiList.purchase_date}" pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>
			</table>

		</form>
	</c:param>
</c:import>

