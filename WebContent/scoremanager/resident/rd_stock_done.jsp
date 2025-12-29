<%-- 介護士用　入居者ストック管理画面 --%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../../baseNyu.jsp">
	<c:param name="title">
		入居者ストック管理画面
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/stockDelete_down_phone.css">
	</c:param>

	<c:param name="content">

		<div class="container">
			<h1>ストック更新が完了しました</h1>
			<a href="Nyu_stockList.action?rd_id=${resident.rd_id}">ストック管理へ</a>
		</div>
	</c:param>
</c:import>
