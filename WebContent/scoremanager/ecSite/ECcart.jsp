<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>カート内容</title>

<style>
/* ===== 既存CSSそのまま ===== */
body {
    font-family: "Segoe UI", sans-serif;
    background-color: #f7f7f7;
    text-align: center;
}
h2 { margin: 30px 0 20px; }
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
td:first-child { font-weight: bold; }
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
input[value="変更する"], input[value="設定"] {
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
    margin-bottom: 10px;
}
</style>

<script>
/* 数量変更時 */
function updateQuantity(input) {
    const row = input.closest(".cart-row");
    row.dataset.quantity = input.value;
}

/* 合計再計算 */
function calcTotal() {
    let total = 0;

    document.querySelectorAll(".cart-row").forEach(row => {
        const price = Number(row.dataset.price);     // 名入れなし単価
        const quantity = Number(row.dataset.quantity);
        const checkbox = row.querySelector(".can-name");

        let itemTotal = price * quantity;

        if (checkbox && checkbox.checked) {
            itemTotal += 300 * quantity; // 名入れ 300 × 数量
        }

        total += itemTotal;
    });

    document.getElementById("totalPrice").textContent = total;
}
</script>

</head>
<body>

<h2>🛒 カートの中身</h2>

<c:if test="${not empty cartList}">
<table>
<tr>
<th>商品名</th>
<th>価格</th>
<th>名入れ</th>
<th>数量</th>
<th>操作</th>
</tr>

<c:forEach var="item" items="${cartList}">
<tr class="cart-row"
    data-price="${item.price - (item.can_name == 1 ? 300 : 0)}"
    data-quantity="${item.quantity}">

<td>${item.goods_name}</td>

<td>${item.price}円</td>

<td>
<c:if test="${item.naireFlg}">
<form action="SetNameAction" method="post">
<input type="hidden" name="goods_id" value="${item.goods_id}">
<input type="checkbox"
       name="can_name"
       class="can-name"
       onchange="calcTotal()"
       <c:if test="${item.can_name == 1}">checked</c:if>>
名入れ（300円 × 個数）
</form>
</c:if>
</td>

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

</c:if>

</body>
</html>
