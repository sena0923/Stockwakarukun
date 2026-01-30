<%-- 介護士用　入居者ストック管理画面 --%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../../baseKai.jsp">
	<c:param name="title">
		入居者ストック管理画面
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/stock.css">
	</c:param>

	<c:param name="content">
		<form class="container"  action="Kai_stockUpdate.action" method="get">

		<div class="input">
			<a class = "back" href="Kai_rdMenu.action?rd_id=${resident.rd_id}">戻る</a>
			<a class ="update_link" href="Kai_stockAdd.action?rd_id=${resident.rd_id}">ストック登録</a>
		</div>

			<h1>== ストック管理画面 ==</h1>
			<h2>${resident.name}さん</h2>

			<div class="tab-container">
				<a class="type_list">個人ストック</a>
				<a class="type_list non" href="Kai_ECstockList.action?rd_id=${resident.rd_id}">ECサイトストック</a>
			</div>

			<table class="table">
			<c:forEach var="iiList" items ="${iiList}">
				<tr>
					<td>${iiList.inve_name}</td>
					<td>
						<div class="qty">
							<button type="button" class="down">-</button>
							<input type="number" name="count_${iiList.inve_name}" value="${iiList.inve_count}" class="qty-input" required>
							<button type="button" class="up">+</button>
						</div>
					</td>
					<td><a class = "" href="Kai_stockDelete_q.action?rd_id=${resident.rd_id}&inve_name=${iiList.inve_name}">削除</a>
					</td>
				</tr>
			</c:forEach>
			</table>

			<script>
			document.querySelectorAll('.qty').forEach(qtyDiv => {
				const qtyDown = qtyDiv.querySelector('.down');
				const qtyUp = qtyDiv.querySelector('.up');
				const input = qtyDiv.querySelector('.qty-input');

					qtyDown.addEventListener('click', () => {
						let num = parseInt(input.value);
						if (num > 0) {
							input.value = num - 1;
						}
					});

					qtyUp.addEventListener('click', () => {
						let num = parseInt(input.value);
						input.value = num + 1;
					});
				});
			</script>


			<input type="hidden" name="rd_id" value="${resident.rd_id}">
			<button type="submit" class="update_link">更新</button>
		</form>
	</c:param>
</c:import>
