<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>カート内容</title>

<style>
body {
    font-family: "Segoe UI", sans-serif;
    background-color: #f7f7f7;
    text-align: center;
}
h2 {
    margin: 30px 0 20px;
}
table {
    margin: 0 auto 20px;
    border-collapse: collapse;
    background-color: #ffffff;
    box-shadow: 0 4px 10px rgba(0,0,0,0.08);
    min-width: 700px;
}
th {
    background-color: #4CAF50;
    color: white;
    padding: 12px;
}
td {
    padding: 12px;
    border-bottom: 1px solid #ddd;
}
td:first-child {
    font-weight: bold;
}
input[type="number"] {
    width: 60px;
    padding: 5px;
}
input[type="submit"], button {
    padding: 8px 16px;
    font-size: 14px;
    border: none;
    border-radius: 6px;
    cursor: pointer;
}
input[value="変更する"] {
    background-color: #2196F3;
    color: white;
}
input[value="削除"] {
    background-color: #f44336;
    color: white;
}
button {
    font-size: 18px;
    padding: 15px 40px;
    background-color: #4CAF50;
    color: white;
    border-radius: 10px;
}
button.back {
    background-color: #2196F3;
}
input[type="submit"]:hover, button:hover {
    opacity: 0.85;
}
.total {
    font-size: 20px;
    font-weight: bold;
    margin: 20px 0;
}
.error {
    color: red;
    font-weight: bold;
    margin-bottom: 20px;
}
/* =========================
   スマホ完全カード化（確実版）
========================= */
@media screen and (max-width: 768px) {

    table {
        display: block;
        width: 100%;
        min-width: 0 !important;
        box-shadow: none;
    }

    thead {
        display: none;
    }

    table tr {
        display: block;
        margin-bottom: 15px;
        background: #ffffff;
        padding: 15px;
        border-radius: 12px;
        box-shadow: 0 3px 8px rgba(0,0,0,0.1);
    }

    table td {
        display: block;
        border: none;
        padding: 6px 0;
        text-align: left;
    }

    table td:nth-child(1)::before {
        content: "商品名：";
        font-weight: bold;
    }

    table td:nth-child(2)::before {
        content: "価格：";
        font-weight: bold;
    }

    table td:nth-child(3)::before {
        content: "数量：";
        font-weight: bold;
    }

    table td:nth-child(4)::before {
        content: "操作：";
        font-weight: bold;
    }

    input[type="submit"],
    button {
        width: 100%;
        margin-top: 8px;
        padding: 12px;
        font-size: 16px;
    }

}

</style>

<script>
function updateQuantity(input) {
    const row = input.closest(".cart-row");
    row.dataset.quantity = input.value;
}

function calcTotal() {
    let total = 0;

    document.querySelectorAll(".cart-row").forEach(row => {
        const price = Number(row.dataset.price);
        const quantity = Number(row.dataset.quantity);
        total += price * quantity;
    });

    document.getElementById("totalPrice").textContent = total;
}
</script>

</head>
<body>

<h2>🛒 カートの中身</h2>

<!-- ★ カートが空のとき -->
<c:if test="${empty cartList}">
    <p class="error">カートは空です</p>

    <form action="${pageContext.request.contextPath}/scoremanager/ECsite/AllExecute.action" method="get">
        <button type="submit" class="back">商品一覧に戻る</button>
    </form>
</c:if>

<!-- ★ カートに商品があるとき -->
<c:if test="${not empty cartList}">

<table>
<tr>
    <th>商品名</th>
    <th>価格</th>
    <th>数量</th>
    <th>操作</th>
</tr>

<c:forEach var="item" items="${cartList}">
<tr class="cart-row"
    data-price="${item.price}"
    data-quantity="${item.quantity}">

    <td>${item.goods_name}</td>
    <td>${item.price}円</td>

    <td>
        <form action="UpdateCartExecute.action" method="post">
            <input type="hidden" name="goods_id" value="${item.goods_id}">
            <input type="number"
                   name="quantity"
                   value="${item.quantity}"
                   min="1"
                   oninput="updateQuantity(this); calcTotal();">
            <input type="submit" value="変更する">
        </form>
    </td>

    <td>
        <form action="RemoveCartExecute.action" method="post">
            <input type="hidden" name="goods_id" value="${item.goods_id}">
            <input type="submit" value="削除">
        </form>
    </td>
</tr>
</c:forEach>
</table>

<p class="total">
合計金額：¥<span id="totalPrice">${totalPrice}</span>
</p>

<form action="${pageContext.request.contextPath}/scoremanager/ECsite/Confirm.action" method="post">
    <button type="submit">購入へ進む</button>
</form>

<br>

<form action="${pageContext.request.contextPath}/scoremanager/ECsite/AllExecute.action" method="get">
    <button type="submit" class="back">商品一覧に戻る</button>
</form>

</c:if>

</body>
</html>
