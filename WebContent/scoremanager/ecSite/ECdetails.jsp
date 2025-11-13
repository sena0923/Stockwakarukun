<%-- 入居者と親族が閲覧するECサイトの商品詳細画面 --%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>Product Details</title>
    <style>
        .product-list {
            display: flex;
            flex-direction: column;
            gap: 20px;
            margin: 20px;
        }

        .product-list {
            display: flex;
            /*align-items: center;*/
            gap: 20px;
        }


        .product-item img {
            width: 300px;
            height: 300px;
            object-fit: cover;
            border: 1px solid #ddd;
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
        <br>
        <a href="#">商品一覧</a>
        <a href="#">カート</a>
        <a href="#">購入履歴</a>
    </div>

    <div>
        <h2>商品詳細ページ</h2>
    </div>

    <div class="product-list">
        <div class="product-item">
            <img src="image/image1.jpg">
                <span>商品名A
                    <br>￥150
                    <br><a href="#">カートに入れる</a>
                </span>

            <div>
                <br>販売元 : 大原株式会社
                <br>サイズ : 100×30 cm
                <br>材質   : 綿100%
                <br>説明   : コットン100%のため，吸水性と肌触りが・・・
            </div>
        </div>
    </div>

    <div>

    </div>

    <footer>
    </footer>
</body>
</html>