<%-- ECサイト管理者画面　商品一覧 --%>


<%@ page contentType="text/html; charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<title>商品一覧表示</title>
<style>
  body {
    font-family: sans-serif;
    background-color: #f9f9f9;
    margin: 0;
    padding: 50px;
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  h1 {
    margin-bottom: 30px;
  }

  /* 商品カード全体のデザイン */
  .product {
    display: flex;
    align-items: center;
    background: #fff;
    border-radius: 10px;
    box-shadow: 0 3px 8px rgba(0,0,0,0.1);
    padding: 20px 30px;
    width: 600px;
    max-width: 95%;
    margin-bottom: 25px;
  }

  .product img {
    width: 180px;
    height: auto;
    border-radius: 10px;
    margin-right: 30px;
  }

  .info {
    text-align: left;
    flex: 1;
  }

  .info p {
    margin: 8px 0;
  }

  /* 詳細ボタン */
  .detail-btn {
    text-decoration: none;
    background: #b8d200;
    color: #000;
    padding: 8px 16px;
    border-radius: 6px;
    font-weight: bold;
    display: inline-block;
    margin-top: 10px;
    transition: background 0.2s;
  }

  .detail-btn:hover {
    background: #a5bf00;
  }
</style>
</head>
<body>
  <h1>商品一覧表示</h1>

  <!-- 商品登録ボタン -->
  <a href="商品新規.html" class="detail-btn" style="background:#00aaff; color:#fff; margin-bottom:20px;">商品登録</a>


  <!-- タオルケット -->
  <div class="product">
    <img src="GOOD-00036_hero_600_450.jpg" alt="タオルケットの画像">
    <div class="info">
      <p><strong>商品名：</strong>タオルケット</p>
      <p><strong>サイズ：</strong>120cm × 40cm</p>
      <p><strong>色：</strong>水色</p>
      <p><strong>在庫数：</strong>7</p>
      <a href="商品更新.jsp" class="detail-btn">商品更新</a>
    </div>
  </div>

  <!-- タオル -->
  <div class="product">
    <img src="t010000093834.jpg" alt="タオルの画像">
    <div class="info">
      <p><strong>商品名：</strong>フェイスタオル</p>
      <p><strong>サイズ：</strong>80cm × 34cm</p>
      <p><strong>色：</strong>白</p>
      <p><strong>在庫数：</strong>15</p>
      <a href="商品更新.jsps" class="detail-btn">商品更新</a>
    </div>
  </div>
</body>
</html>
