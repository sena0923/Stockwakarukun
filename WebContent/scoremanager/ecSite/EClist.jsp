<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.Goods" %>

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

<!-- 通知 -->
<div id="popupMessage">カートに追加されました</div>

<div class="ec-page">

<ul>
<%
    // goodsList をリクエストから取得
    List<Goods> goodsList = (List<Goods>) request.getAttribute("goodsList");
    if(goodsList != null){
        for(Goods goods : goodsList){
%>
    <li>
        <!-- 商品画像 -->
        <img src="<%= goods.getImage_path(#ここはbeenを確認) %>" width="150" height="150">

        <!-- 商品情報 -->
        商品名: <%= goods.getGoods_name() %>　
        価格: <%= goods.getPrice() %>円　
        在庫: <%= goods.getStock() %>

        <!-- カートに入れる / 在庫なし -->
<%
    if(goods.getStock() != null && !goods.getStock().equals("0")) { #ここはintは使えない
%>
    <a href="#" onclick="addToCart('<%= goods.getGoods_id() %>'); return false;">
        カートに入れる
    </a>
<%
    } else {
%>
    <span style="color:red; font-weight:bold;">在庫なし</span>
<%
    }}}
%>

    </li>
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
