<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="../../baseKai.jsp">
	<c:param name="title">
		連絡帳一覧
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/conList.css">
	</c:param>

	<c:param name="content">
		<div class = "notification-list">
			<a class = "back" href="Kai_rdMenu.action?rd_id=${resident.rd_id}">戻る</a>

			<h1>連絡帳　${resident.name} さん</h1>

			<p>対応する親族アカウントが登録されていません</p>

		</div>
	</c:param>
</c:import>
