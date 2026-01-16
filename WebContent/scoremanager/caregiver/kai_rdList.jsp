<%-- 介護士が閲覧する入居者リスト画面 --%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../../baseKai.jsp">
	<c:param name="title">
		入居者一覧
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/kai_rdList.css">
	</c:param>

	<c:param name="content">
		<form class="container"  action="RdSearch.action" method="get">
			<a href="KaiMenu.action" class="back-btn">戻る</a>

			<h1>入居者一覧</h1>

			<div class="search">
					<label for="f1" class="label">入居者名</label>
					<input type="text" name="name" placeholder="フルネーム - スペース入力不可" required>
					<button type="submit" class="btn-search" id="filter-button">検索</button>
			</div>

			<p>詳細を押下すると入居者のストック管理や連絡帳が確認できます。</p>

					<table class="table">
						<tr>
							<th>入居者氏名</th>
							<th>性別</th>
							<th>コース</th>
							<th>詳細</th>
						</tr>
						<c:forEach var="resident" items="${list}">
							<tr>
								<td>${resident.name}</td>
								<td>${resident.gender}</td>
								<td>${resident.course.course_name}</td>
								<td><a href="Kai_rdMenu.action?rd_id=${resident.rd_id}">詳細</a></td>
							</tr>
						</c:forEach>
					</table>

		</form>
	</c:param>
</c:import>
