<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>Purchase List</title>

    <meta charset="UTF-8">
    <title>Cart List</title>
    <link rel="stylesheet" href="ecstyle.css">


</head>
<body>
    <header>
        <nav>
            <li><a href="#">アカウント情報</a></li>
            <li><a href="#">ログアウト</a></li>
        </nav>
    </header>

    <div>
        <h2>ECサイト ー購入一覧ー</h2>
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
                <br>注文完了日 : 2025年10月24日

            </span>
            <a href="#">再度購入</a>
        </div>
    </div>

     <div class="product-list">
        <div class="product-item">
            <img src="image/image2.jpg">
            <span>商品名A
                <br>￥150
                <br>注文完了日 : 2025年09月18日

            </span>
            <a href="#">再度購入</a>
        </div>
    </div>


    <script>
        const countDisplay = document.getElementById('count');
        const minusBtn = document.getElementById('minus-btn');
        const plusBtn = document.getElementById('plus-btn');

        let count = 0;

        minusBtn.addEventListener('click', () => {
        if (count > 0) {
            count--;
            countDisplay.textContent = count;
        }
        });

        plusBtn.addEventListener('click', () => {
        count++;
        countDisplay.textContent = count;
        });
  </script>

    <footer>
    </footer>
</body>
</html>