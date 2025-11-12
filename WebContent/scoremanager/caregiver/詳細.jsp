<%@ page contentType="text/html; charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>△△さんの詳細ページ</title>
<style>
  html, body {
    height: 100%;
    margin: 0;
    font-family: sans-serif;
    background-color: #f5f5f5;
  }

  /* 画面中央に配置 */
  body {
    display: flex;
    justify-content: center;
    align-items: center;
  }

  /* カード風コンテナ */
  .container {
    background: #fff;
    padding: 30px 50px;
    border-radius: 10px;
    box-shadow: 0 4px 15px rgba(0,0,0,0.1);
    text-align: center;
    width: 400px;
    max-width: 90%;
  }

  h1 {
    margin-bottom: 25px;
  }

  .menu a {
    text-decoration: none;
    background: #b8d200;
    color: #000;
    border-radius: 0.25em;
    padding: 1em 2em 0.8em;
    line-height: 1;
    display: block;
    font-weight: bold;
    margin: 10px auto;
    width: 200px;
  }

  .menu a:hover {
    background: #a5bf00;
  }

  .back-link {
    display: inline-block;
    margin-top: 20px;
    text-decoration: none;
    color: #000;
    font-weight: bold;
  }

  .back-link:hover {
    text-decoration: underline;
  }
</style>
</head>
<body>
  <div class="container">
    <h1>△△さんの詳細ページ</h1>

    <div class="menu">
      <a href="在庫.jsp">在庫情報</a>
      <a href="連絡帳.jsp">連絡帳</a>
      <a href="PR.jsp">プロフィール</a>
      <a href="気分.jsp">気分管理</a>
    </div>

    <a class="back-link" href="入居者一覧.jsp">戻る</a>
  </div>
</body>
</html>
