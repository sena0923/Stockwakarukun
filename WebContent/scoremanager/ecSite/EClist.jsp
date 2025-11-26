<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../headerEC.jsp" %>
<%@ page import="bean.Goods" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/EClist.css">
<meta charset="UTF-8">
<title>EC商品一覧</title>

</head>
<body>
<div class="ec-page">

     <ul>
        <c:forEach var="goods" items="${goodsList}">
            <li>
                商品名：${goods.goods_name}　
                価格：${goods.price}円　
                在庫：${goods.stock}
                <a href="cart?goods_id=${goods.goods_id}">カートに入れる</a>
            </li>
        </c:forEach>
    </ul>

</div>

<!-- 商品一覧 -->
<div class="product-list">
  <!-- 「すべて」カテゴリが選ばれたときに AllList を表示 -->
<c:if test="${selectedCategory == 'All'}">
    <h3>すべての持ち物リスト</h3>
    <ul>
        <c:forEach var="item" items="${AllList['すべて']}">
            <li>${item}</li>
              <a href="#">カートに入れる</a>
        </c:forEach>

    </ul>
</c:if>
</div>

</body>
</html>
