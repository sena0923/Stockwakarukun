<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>カート内容</title>

<style>

/* ===== 全体 ===== */

body {

    font-family: "Segoe UI", sans-serif;

    background-color: #f7f7f7;

    text-align: center;

}

/* 見出し */

h2 {

    margin: 30px 0 20px;

}

/* ===== テーブル ===== */

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

/* 商品名を少し目立たせる */

td:first-child {

    font-weight: bold;

}

/* ===== フォーム共通 ===== */

input[type="number"] {

    width: 60px;

    padding: 5px;

}

/* ===== ボタン共通 ===== */

input[type="submit"],

button {

    padding: 8px 16px;

    font-size: 14px;

    border: none;

    border-radius: 6px;

    cursor: pointer;

}

/* 変更・設定ボタン */

input[value="変更する"],

input[value="設定"] {

    background-color: #2196F3;

    color: white;

}

/* 削除ボタン */

input[value="削除"] {

    background-color: #f44336;

    color: white;

}

/* 購入へ進むボタン */

button {

    font-size: 18px;

    padding: 15px 40px;

    background-color: #4CAF50;

    color: white;

    border-radius: 10px;

}

/* ホバー */

input[type="submit"]:hover,

button:hover {

    opacity: 0.85;

}

/* ===== 合計金額 ===== */

.total {

    font-size: 20px;

    font-weight: bold;

    margin: 20px 0;

}

/* エラーメッセージ */

.error {

    color: red;

    font-weight: bold;

    margin-bottom: 10px;

}
</style>

</head>
<body>

<h2>🛒 カートの中身</h2>

<c:if test="${empty cartList}">
<p>カートは空です</p><br><br>

    <div class="back-home">
<c:choose>

		    <c:when test="${not empty resident}">
<a href="../../scoremanager/ECsite/AllExecute.action">購入画面へ戻る</a>
</c:when>

			<c:when test="${not empty selectedResident}">
<a href="../../scoremanager/ECsite/AllsinExecute.action">購入画面へ戻る</a>
</c:when>

		    <c:when test="${not empty relatives}">
<a href="../../scoremanager/ECsite/AllsinExecute.action">購入画面へ戻る</a>
</c:when>

		</c:choose>
<!-- 入居者本人ログインを最優先 -->
<!-- 親族が入居者を選んで代理操作中 -->
<!-- 親族本人ログイン -->
</div>
</c:if>

<c:if test="${not empty cartList}">

    <c:if test="${not empty error}">
<p class="error">${error}</p>
</c:if>

    <table>
<tr>
<th>商品名</th>
<th>価格</th>
<th>名入れ</th>
<th>数量</th>
<th>操作</th>
</tr>

<c:forEach var="item" items="${cartList}">
<tr>
<!-- 商品名 -->
<td>${item.goods_name}</td>

        <!-- 価格 -->
<td>${item.price}円</td>

<!-- 名入れ -->
<td>

    <!-- 名入れ項目の表示 -->

        <!-- setNaireFlgを使用してif分岐  -->
<!--  ${item.naireFlg}-->
<c:if test="${item.naireFlg}">


        <!-- チェックボックス -->
<label>
<c:if test="${canNameFlg}">
<input type="checkbox" name="can_name" value="1">

	    名入れを希望する
</c:if>

        </label>

        <br>

        <!-- 名入れ入力（最初は非表示） -->


<!-- <div id="nameArea_${item.goods_id}" style="display:none;">  -->
<form action="SetNameExecute.action" method="post">
<input type="hidden" name="goods_id" value="${item.goods_id}">


<input type="text" name="name_text"

              placeholder="名入れ文字"

            maxlength="10">
			<input type="submit" value="設定">

</form>
<!--  </div> -->
</c:if>


</td>


        <!-- 数量 -->
<td>
<form action="UpdateCartExecute.action" method="post">
<input type="hidden" name="goods_id" value="${item.goods_id}">
<input type="number" name="quantity"

                       value="${item.quantity}" min="1">
<input type="submit" value="変更する">
</form>
</td>

        <!-- 削除 -->
<td>
<form action="RemoveCartExecute.action" method="post">
<input type="hidden" name="goods_id" value="${item.goods_id}">
<input type="submit" value="削除">
</form>
</td>
</tr>
</c:forEach>

    </table>

    <p class="total">合計金額：${totalPrice}円</p>

    <form action="${pageContext.request.contextPath}/scoremanager/ECsite/Confirm.action" method="post">
<button type="submit">購入へ進む</button>
</form>
<br><br>
<div class="back-home">
<c:choose>

		    <c:when test="${not empty resident}">
<a href="../../scoremanager/ECsite/AllExecute.action">購入画面へ戻る</a>
</c:when>

			<c:when test="${not empty selectedResident}">
<a href="../../scoremanager/ECsite/AllsinExecute.action">購入画面へ戻る</a>
</c:when>

		    <c:when test="${not empty relatives}">
<a href="../../scoremanager/ECsite/AllsinExecute.action">購入画面へ戻る</a>
</c:when>

		</c:choose>
<!-- 入居者本人ログインを最優先 -->
<!-- 親族が入居者を選んで代理操作中 -->
<!-- 親族本人ログイン -->
</div>
</c:if>


</body>
</html>