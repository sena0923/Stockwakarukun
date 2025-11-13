<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>

<main>
  <form action="saveStock.jsp" method="post">
    <%-- 在庫アイテム一覧 --%>
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