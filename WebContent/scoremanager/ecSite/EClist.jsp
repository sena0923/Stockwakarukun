<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>EC商品一覧</title>

<style>
    /* 画面全体を中央寄せ */
    body {
        display: flex;
        flex-direction: column;
        align-items: center;
        margin: 0;
        font-family: sans-serif;
    }

    /* カテゴリーメニュー */
    .category-menu {
        display: flex;
        gap: 15px;
        margin: 20px auto;
    }

    .category-menu a {
        text-decoration: none;
    }

    .category-menu li {
        list-style: none;
        padding: 10px 20px;
        border-radius: 10px 10px 0 0;
        background: #f0f0f0;
        transition: 0.3s;
        cursor: pointer;
    }

    .category-menu li:hover {
        background: #ddd;
    }

    .category-menu .active {
        background: #4CAF50;
        color: white;
        font-weight: bold;
        box-shadow: 0px 2px 5px rgba(0,0,0,0.2);
    }

    /* 商品一覧を中央寄せ */
    .product-list {
        margin-top: 20px;
        width: 70%;
        display: flex;
        flex-direction: column;
        gap: 20px;
    }

    .product-item {
        display: flex;
        align-items: center;
        padding: 15px;
        border-radius: 10px;
        background: #fafafa;
        box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        gap: 20px;
    }

    .product-item img {
        width: 130px;
        height: auto;
        border-radius: 5px;
    }
</style>

</head>
<body>

<h2>ECサイト 商品一覧</h2>

<!-- カテゴリータブ -->
<ul class="category-menu">

    <li class="${selectedCategory == 'all' ? 'active' : ''}">
        <a href="NyuECExecute.action?category=all">すべて</a>
    </li>

    <li class="${selectedCategory == 'A' ? 'active' : ''}">
        <a href="NyuECExecute.action?category=A">洗面用具</a>
    </li>

    <li class="${selectedCategory == 'B' ? 'active' : ''}">
        <a href="NyuECExecute.action?category=B">タオル</a>
    </li>

    <li class="${selectedCategory == 'C' ? 'active' : ''}">
        <a href="NyuECExecute.action?category=C">衣類</a>
    </li>

    <li class="${selectedCategory == 'D' ? 'active' : ''}">
        <a href="NyuECExecute.action?category=D">防寒</a>
    </li>

    <li class="${selectedCategory == 'E' ? 'active' : ''}">
        <a href="NyuECExecute.action?category=E">備品</a>
    </li>

    <li class="${selectedCategory == 'F' ? 'active' : ''}">
        <a href="NyuECExecute.action?category=F">娯楽</a>
    </li>

</ul>

<!-- 商品一覧 -->
<div class="product-list">

    <c:forEach var="g" items="${goodsList}">
        <div class="product-item">
            <img src="image/${g.goods_id}.jpg" alt="商品画像">
            <div>
                <strong>${g.goods_name}</strong><br>
                価格：￥${g.price}<br>
                在庫：${g.stock}<br>
                カテゴリー：${g.category_id}<br><br>

                <a href="#">カートに入れる</a>
            </div>
        </div>
    </c:forEach>

</div>

</body>
</html>
