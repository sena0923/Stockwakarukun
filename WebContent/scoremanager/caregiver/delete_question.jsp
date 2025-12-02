<%-- 本当に個人ストックを消しても大丈夫ですか画面 --%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../../baseKai.jsp">
	<c:param name="title">
		個人ストック消しますか？
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/logout.css">
	</c:param>

	<c:param name="content">
	<div class="container">
		  <h1>本当に削除しますか？</h1>
			<div>
				<a class="logout_link" href="Kai_stockDelete.action?rd_id=${resident.rd_id}&inve_name=${inve_name}">はい</a>
				<a class="logout_link" href="#" onclick="history.back()">いいえ</a>
			</div>
	</div>
	</c:param>
</c:import>
