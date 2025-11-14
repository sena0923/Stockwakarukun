<%-- 介護士用　入居者ストック管理画面 --%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../../base.jsp">
	<c:param name="title">
		入居者ストック管理画面
	</c:param>

	<c:param name="scripts">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/kai_rdList.css">
	</c:param>

	<c:param name="content">
		<form class="container" <%-- action="Kai_stockList.action" --%>method="get">
			<h1>${resident.name}さん　== ストック管理画面 ==</h1>

			<table class="table">
			<c:forEach var="iiList" items ="${iiList}">
				<tr>
					<td>${iiList.inve_name}</td>
					<td>${iiList.inve_count}</td>
				</tr>
			</c:forEach>
			</table>


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