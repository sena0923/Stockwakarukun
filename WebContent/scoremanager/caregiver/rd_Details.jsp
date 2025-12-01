<%-- 該当入居者のメインメニュー --%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../../baseKai.jsp">
	<c:param name="title">
		入居者の詳細メニュー
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/rd_Details.css">
	</c:param>

	<c:param name="content">
		<form class="container" <%-- action="RdList.action"--%> method="get">
			<a class="back-link" href="RdList.action">戻る</a>

			<h1>${resident.name}さん</h1>

			<div class="menu">
				<a href="Kai_stockList.action?rd_id=${resident.rd_id}">ストック管理</a>
				<a href="Kai_conList.action?rd_id=${resident.rd_id }">連絡帳</a>
			</div>


		</form>
	</c:param>
</c:import>
