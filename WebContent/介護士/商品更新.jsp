<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<title>登録完了</title>
<style>
  html, body {
    height: 100%;
    margin: 0;
  }

  /* 画面中央に配置 */
  body {
    display: flex;
    flex-direction: column;
    justify-content: center; /* 縦方向中央 */
    align-items: center;     /* 横方向中央 */
    background-color: #f5f5f5;
    font-family: sans-serif;
  }

  h1 {
    margin-bottom: 20px;
  }

  a {
    display: inline-block;
    padding: 10px 20px;
    text-decoration: none;
    background-color: #b8d200;
    color: #000;
    border-radius: 6px;
    font-weight: bold;
  }

  a:hover {
    background-color: #a5bf00;
  }
</style>
</head>
<body>
  <h1>商品の更新が完了しました</h1>
  <a href="EC管理.jsp">管理一覧へ</a>
</body>
</html>
