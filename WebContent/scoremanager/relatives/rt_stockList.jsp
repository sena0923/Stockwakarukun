<%-- 入居者の日用品のリストを表示／変更する画面 --%>
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
			<h1>ストック管理画面</h1>
			<h2>${resident.name}さん</h2>

			<div class="tab-container">
				<a class="type_list">個人ストック</a>
				<a class="type_list non" href="Sin_ECstockList.action?rt_id=${relatives.rt_id}">ECサイトストック</a>
			</div>

			<table class="table">
				<tr>
					<th>ストック名</th>
					<th>在庫数</th>
					<th>最終更新日</th>
				</tr>
				<c:forEach var="iiList" items ="${iiList}">
				<tr>
					<td>${iiList.inve_name}</td>
					<td>${iiList.inve_count}</td>
					<td><fmt:formatDate value="${iiList.regi_date}" pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>
			</table>

			<a class = "" href="SinMenu.action">メニュー</a>
		</form>
	</c:param>
</c:import>
