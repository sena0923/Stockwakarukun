<%-- 連絡帳　送信完了画面 --%>


<%-- 本当にログアウトしても大丈夫ですか画面 --%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../../baseKai.jsp">
	<c:param name="title">
		連絡帳完了画面
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/logout.css">
	</c:param>

	<c:param name="content">
	<div class="container">
		  <h1>入居者：${resident.name}さん　親族：${relatives.name}さん</h1>
		  <h2>送信完了しました</h2>
			<div>
				<a class="logout_link" href="Kai_conList.action?rd_id=${resident.rd_id }">通知一覧へ</a>
			</div>
	</div>
	</c:param>
</c:import>