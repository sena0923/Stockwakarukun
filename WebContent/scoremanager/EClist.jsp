<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
    <style>
        .product-list {
            display: flex;
            flex-direction: column;
            gap: 20px;
            margin: 20px;
        }

        .product-item {
            display: flex;
            align-items: center;
            gap: 20px;
        }

        .product-item img {
            width: 150px; /* サイズ調整 */
            height: auto;
        }

        nav li {
            display: inline;
            margin-right: 10px;
        }
    </style>
</head>
<body>
    <header>
        <nav>
            <li><a href="#">アカウント情報</a></li>
            <li><a href="#">ログアウト</a></li>
        </nav>
    </header>

    <div>
        <h2>ECサイト ー商品一覧ー</h2>
    </div>

    <div>
        <a href="#">カート</a>
        <a href="#">購入履歴</a>
    </div>

    <div class="product-list">
        <div class="product-item">
            <img src="image/image1.jpg">
            <span>商品名A
                <br>￥150
                <br><a href="#">カートに入れる</a>
            </span>
        </div>
        <div class="product-item">
            <img src="image/image2.jpg" alt="">
            <span>商品名B
                <br>￥128
                <br><a href="#">カートに入れる</a>
            </span>
        </div>
        <div class="product-item">
            <img src="image/image3.jpg" alt="">
            <span>商品名C
                <br>￥200
                <br><a href="#">カートに入れる</a>
            </span>
        </div>
    </div>

    <div>
        <a href="#">メインメニューへ</a>
    </div>

    <footer>
    </footer>
</body>
</html>