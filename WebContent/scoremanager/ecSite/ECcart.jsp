<%-- 入居者と親族が閲覧するECサイトのカート画面 --%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>Cart List</title>

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
        <h2>ECサイト ーカート一覧ー</h2>
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
                <br>
                <div class="counter-container">
                    <button id="minus-btn">-</button>
                    <span id="count" class="count-display">1</span>
                    <button id="plus-btn">+</button>
                </div>
            </span>
            <a href="#">削除</a>
        </div>
    </div>

    <div>
        合計数 : ○○○個
        <br>合計金額 : ￥●●●
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