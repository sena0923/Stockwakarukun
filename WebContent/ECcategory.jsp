<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>Product category</title>
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


        .list nav {
            display: flex;
            gap: 20px; /* 横の間隔 */
        }

        .list li {
            list-style: none; /* liの点を消す */
        }
        .list nav {
           display: flex;
            gap: 10px;
        }

        .list li {
            list-style: none;
            padding: 10px 15px;
            border-radius: 8px 8px 0 0; /* 上だけ角丸でタブ風 */
            background-color: #f0f0f0;
            cursor: pointer;
            transition: background 0.3s;
        }

        .list li:hover {
            background-color: #ddd;
        }

        .list li.active {
            background-color: #4CAF50; /* 選択中の色 */
            color: white;
            font-weight: bold;
            box-shadow: 0 2px 5px rgba(0,0,0,0.2);
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

    <div class="list">
    <nav>
        <li><h2>すべて</h2></li>
        <li><h2>洗面用具</h2></li>
        <li class="active"><h2>タオル</h2></li>
        <li><h2>衣類</h2></li>
        <li><h2>防寒</h2></li>
        <li><h2>備品</h2></li>
        <li><h2>娯楽</h2></li>
        <!-- 洗面用具/タオル/衣類/防寒/備品/娯楽 -->
    </nav>
    </div>

    <div>
        <h2>ECサイト ータオルー</h2>
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