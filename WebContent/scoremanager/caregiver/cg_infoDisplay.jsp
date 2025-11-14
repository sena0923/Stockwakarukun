<%-- 介護士アカウント情報表示画面 --%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<title>介護士情報</title>
<style>
  html, body {
    height: 100%;
    margin: 0;
  }

  /* 中央配置 */
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

  p {
    margin: 5px 0;
    font-size: 18px;
  }

  a {
    text-decoration: none;
    background: #b8d200;
    color: #000;
    border-radius: 0.25em;
    padding: 1em 2em 0.8em;
    line-height: 1;
    display: inline-block;
    font-weight: bold;
    margin-top: 10px;
  }

  a:hover {
    background: #a5bf00;
  }

  /* 戻るボタンのスタイル */
  .back-button {
    background: #ccc;
    color: #000;
    margin-top: 30px;
  }

  .back-button:hover {
    background: #999;
  }
</style>
</head>


<body>
  <h1>介護士情報</h1>
  <p>名前 | ○○</p>
  <p>職員番号 | 1234</p>

  <a href="cg_infoChange.jsp.jsp">情報更新</a>
  <a href="logoutkai.jsp">ログアウト</a>
  <a href="kai_menu.jsp" class="back-button">戻る</a>
</body>
</html>
