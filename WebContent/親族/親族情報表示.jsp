<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>

<main>
  <h2 style="font-size: 50px;">ユーザー情報</h2>

  <p style="font-size: 40px;">名前 | <%= session.getAttribute("userName") != null ? session.getAttribute("userName") : "未設定" %></p>
  <p style="font-size: 30px;">パスワード | ＊＊＊＊＊＊</p>
  <p style="font-size: 25px;">ログインID | <%= session.getAttribute("loginId") != null ? session.getAttribute("loginId") : "未設定" %></p>

  <div class="button-container">
    <button onclick="location.href='親族/親族ホーム.jsp'">戻る</button>
    <button onclick="location.href='親族/親族情報変更.jsp'">変更する</button>
  </div>
</main>

<style>
  main {
    font-family: "Hiragino Sans", "Meiryo", sans-serif;
  }

  h2 {
    margin: 0;
    height: 15vh;
    display: flex;
    justify-content: center;
    align-items: center;
  }

  p {
    margin: 0;
    height: 10vh;
    display: flex;
    justify-content: center;
    align-items: center;
    font-weight: bold;
    color: #333;
  }

  .button-container {
    display: flex;
    gap: 15px;
    justify-content: center;
  }

  button {
    padding: 10px 20px;
    font-size: 16px;
    font-weight: bold;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    color: #fff;
    background-color: #4CAF50;
    transition: background-color 0.3s;
  }

  button:hover {
    background-color: #45a049;
  }
</style>