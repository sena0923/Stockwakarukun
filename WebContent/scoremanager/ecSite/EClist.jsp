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
        <img src="/images/101.png" width="150" height="150">

        商品名: ${goods.goods_name}　
        価格: ${goods.price}円　
        在庫: ${goods.stock}

        <c:choose>
            <c:when test="${not empty goods.stock and goods.stock ne '0'}">
                <!-- フォームで必要な情報をPOST -->
                <form action="AddCartExecute.action" method="post" style="display:inline;">
                    <input type="hidden" name="course_id" value="${goods.course_id}">
                    <input type="hidden" name="rd_id" value="${sessionScope.rd_id}">
                    <input type="hidden" name="goods_id" value="${goods.goods_id}">
                    <input type="hidden" name="goods_name" value="${goods.goods_name}">
                    <input type="hidden" name="price" value="${goods.price}">
                    <input type="hidden" name="quantity" value="1">
                    <input type="submit" value="カートに入れる">
                </form>
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

    fetch("/scoremanager/ECsite/", {
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
