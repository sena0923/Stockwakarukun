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
		<form class="container"  action="Kai_ECstockUpdate.action"method="get">
			<h1>== ストック管理画面 ==</h1>
			<h2>${resident.name}さん</h2>

			<div class="tab-container">
				<a class="type_list non" href="Kai_stockList.action?rd_id=${resident.rd_id}">個人ストック</a>
				<a class="type_list">ECサイトストック</a>
			</div>

			<table class="table">
			<c:forEach var="iiList" items ="${iiList}">
				<tr>
					<td>${iiList.goods_id}</td>
					<td>
						<div class="qty">
							<button type="button" class="down">-</button>
							<input type="number" name="count_${iiList.goods_id}" value="${iiList.goods_inve_count}" class="qty-input">
							<button type="button" class="up">+</button>
						</div>
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
			<a class ="update_link" href="Kai_stockAdd.action?rd_id=${resident.rd_id}">ストック登録</a>
			<a class = "" href="RdList.action">入居者の詳細メニューへ戻る</a>
		</form>
	</c:param>
</c:import>






<%--
<main>
  <form action="saveStock.jsp" method="post">
    <%-- 在庫アイテム一覧
    <%
      String[] items = { "ティッシュボックス", "靴下", "タオル(大)" };
      for (String item : items) {
        String inputName = "item_" + item.replaceAll("[^\\w]", "_"); // 安全なname属性
    %>
      <div class="item">
        <h2><%= item %></h2>
        <div class="counter">
          <button type="button" class="decrease">－</button>
          <input type="number" name="<%= inputName %>" class="count" value="0" min="0" max="90">
          <button type="button" class="increase">＋</button>
        </div>
      </div>
    <%
      }
    %>

    <script>
      document.querySelectorAll('.item').forEach(item => {
        const count = item.querySelector('.count');
        const increaseBtn = item.querySelector('.increase');
        const decreaseBtn = item.querySelector('.decrease');

        increaseBtn.addEventListener('click', () => {
          count.value = Math.min(parseInt(count.value) + 1, parseInt(count.max));
        });

        decreaseBtn.addEventListener('click', () => {
          count.value = Math.max(parseInt(count.value) - 1, parseInt(count.min));
        });
      });
    </script>

    <div class="button-area">
      <a href="入居者ホーム.jsp" class="button-a">戻る</a>
      <button type="submit" class="button-a">保存する</button>
    </div>
  </form>
</main>
</html>

--%>