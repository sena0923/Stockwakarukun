<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>購入確認画面</title>

<style>
body {
    text-align: center;   /* 全体を中央寄せ */
}

/* 商品名 */
.goods-name {
    font-size: 18px;
    font-weight: bold;
}

/* 数字（数量・金額） */
.number {
    font-size: 17px;
    font-weight: bold;
}

/* 購入確定ボタン */
.confirm-button {
    font-size: 20px;
    padding: 15px 40px;
    background-color: #4CAF50; /* 緑色 */
    color: white;
    border: none;
    border-radius: 10px;      /* 角丸 */
    cursor: pointer;
}

.confirm-button:hover {
    opacity: 0.8;
}
</style>

</head>
<body>

<h2>購入内容の確認</h2>

<c:forEach var="cart" items="${sessionScope.cartList}">
    <p>
        <span class="goods-name">${cart.goods_name}</span>
        × <span class="number">${cart.quantity}</span>
        ＝ <span class="number">${cart.price * cart.quantity}</span>円
    </p>
</c:forEach>


<form action="../ECsite/PurchaseExecute.action" method="post">
    <button type="submit" class="confirm-button">購入確定</button>
</form>

</body>
</html>
