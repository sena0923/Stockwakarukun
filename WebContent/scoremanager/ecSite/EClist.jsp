<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>EC商品一覧</title>

<style>
/* 通知メッセージ */
#popupMessage {
    position: fixed;
    top: 20px;
    right: 20px;
    background: #4CAF50;
    color: white;
    padding: 12px 20px;
    border-radius: 6px;
    box-shadow: 0 4px 10px rgba(0,0,0,0.2);
    display: none;
    z-index: 9999;
}
</style>

</head>
<body>

<%@ include file="../../headerEC.jsp" %>

<!-- ここに通知 -->
<div id="popupMessage">カートに追加されました</div>

<div class="ec-page">

<ul>
    <c:forEach var="goods" items="${goodsList}">
        <li>
    <!-- 画像 -->
    <img src="/images/101.png" width="150" height="150">

    商品名:${goods.goods_name}　
    価格:${goods.price}円　
    在庫:${goods.stock}

    <!-- 🔽ここで条件分岐 -->
  <c:choose>

    <c:when test="${not empty goods.stock and goods.stock ne '0'}">
        <a href="#" onclick="addToCart('${goods.goods_id}'); return false;">
            カートに入れる
        </a>
    </c:when>

    <c:otherwise>
        <span style="color:red; font-weight:bold;">在庫なし</span>
    </c:otherwise>

</c:choose>


</li>

    </c:forEach>
</ul>

</div>

<script>
function addToCart(goodsId) {

    fetch("cart", {
        method: "POST",
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
        body: "goods_id=" + goodsId
    })
    .then(response => response.text())
    .then(() => {
        showPopup();
    })
    .catch(() => {
        alert("エラーが発生しました");
    });
}

function showPopup() {
    const popup = document.getElementById("popupMessage");
    popup.style.display = "block";

    setTimeout(() => {
        popup.style.display = "none";
    }, 2000);
}
</script>

</body>
</html>
