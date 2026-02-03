<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>購入確認画面</title>

<style>
body {
    text-align: center;
}

.goods-name {
    font-size: 18px;
    font-weight: bold;
}

.number {
    font-size: 17px;
    font-weight: bold;
}

.total {
    font-size: 20px;
    font-weight: bold;
    margin-top: 20px;
}

.confirm-button {
    font-size: 20px;
    padding: 15px 40px;
    background-color: #4CAF50;
    color: white;
    border: none;
    border-radius: 10px;
    cursor: pointer;
}

.confirm-button:hover {
    opacity: 0.8;
}
</style>
</head>

<body>

<h2>購入内容の確認</h2>

<c:set var="NAIRE_PRICE" value="300" />

<c:forEach var="cart" items="${sessionScope.cartList}">
    <c:set var="itemTotal" value="${cart.price * cart.quantity}" />

    <!-- ★ 名入れがある場合 -->
    <c:if test="${cart.can_name == 1}">
        <c:set var="itemTotal"
               value="${itemTotal + (NAIRE_PRICE * cart.quantity)}" />
    </c:if>

    <p>
        <span class="goods-name">${cart.goods_name}</span>
        × <span class="number">${cart.quantity}</span>
        ＝ <span class="number">${itemTotal}</span>円
    </p>
</c:forEach>


<p class="total">
合計金額：¥${totalPrice}
</p>



<form action="../ECsite/PurchaseExecute.action" method="post">
    <button type="submit" class="confirm-button">購入確定</button>
</form>

<br><br>
<a href="javascript:history.back();">戻る</a>

</body>
</html>
