<%-- 介護士アカウント更新完了画面 --%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<title>情報更新画面</title>
<style>
  html, body {
    height: 100%;
    margin: 0;
    font-family: sans-serif;
    background-color: #f5f5f5;
  }

  /* 画面中央配置 */
  body {
    display: flex;
    justify-content: center;
    align-items: center;
  }

  /* コンテナ */
  .container {
    background: #fff;
    padding: 30px 40px;
    border-radius: 10px;
    box-shadow: 0 4px 15px rgba(0,0,0,0.1);
    text-align: center;
    width: 400px;
    max-width: 90%;
    position: relative; /* 戻るボタンを右下に配置するために必要 */
  }

  h1 {
    margin-bottom: 20px;
  }

  .controll {
    margin: 10px 0;
    text-align: left;
  }

  label {
    display: block;
    margin-bottom: 5px;
    font-weight: bold;
  }

  input {
    width: 100%;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
  }

  .btn {
    margin-top: 20px;
    background-color: #b8d200;
    color: #000;
    border: none;
    border-radius: 6px;
    padding: 10px 20px;
    font-size: 16px;
    font-weight: bold;
    cursor: pointer;
  }

  .btn:hover {
    background-color: #a5bf00;
  }

  /* 戻るボタンのスタイル（右下固定） */
  .back-button {
    position: absolute;
    bottom: 15px;
    right: 20px;
    background: #ccc;
    color: #000;
    border-radius: 5px;
    padding: 8px 16px;
    font-size: 14px;
    text-decoration: none;
    font-weight: bold;
  }

  .back-button:hover {
    background: #999;
  }
</style>
</head>
<body>
  <div class="container">
    <h1>情報更新画面</h1>
    <form action="更新完了.jsp" method="post">
      <div class="controll">
        <label for="name">氏名</label>
        <input type="text" id="name" name="name" required>
      </div>

      <div class="controll">
        <label for="number">職員番号</label>
        <input type="text" id="number" name="number" required>
      </div>

      <div class="controll">
        <button class="btn" type="submit">完了</button>
      </div>
    </form>

    <!-- 枠の右下に配置された戻るボタン -->
    <a href="kai_menu.jsp" class="back-button">戻る</a>
  </div>
</body>
</html>
