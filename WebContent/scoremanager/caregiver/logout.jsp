<%-- 本当にログアウトしても大丈夫ですか画面 --%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../../baseKai.jsp">
	<c:param name="title">
		ログアウトしますか？
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/logout.css">
	</c:param>

	<c:param name="content">
	<div class="container">
		  <h1>ログアウトしますか</h1>
			<div>
				<a class="logout_link" href="KaiLogout.action">はい</a>
				<a class="logout_link" href="#" onclick="history.back()">いいえ</a>
			</div>
	</div>
	</c:param>
</c:import>
