<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="../base.jsp" %>

<main>
  <h1>あなたの立場は何ですか</h1>

  <div class="button-row">
    <a href="caregiver/介護士ログイン.jsp" class="btn1">介護士</a>
    <a href="resident/入居者ログイン.jsp" class="btn1">入居者</a>
    <a href="relatives/親族ログイン.jsp" class="btn1">親族</a>
  </div>
</main>

<style>
  body {
    font-family: "Hiragino Sans", "Meiryo", sans-serif;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    min-height: 100vh;
    margin: 0;
    background-color: #f7f7f7;
  }

  h1 {
    margin-bottom: 50px;
    text-align: center;
    color: #333;
  }

  .button-row {
    display: flex;
    gap: 30px;
    flex-wrap: wrap;
    justify-content: center;
  }

  .btn1 {
    display: inline-block;
    padding: 15px 40px;
    background-color: #4CAF50;
    color: white;
    text-decoration: none;
    font-size: 1.2rem;
    border-radius: 8px;
    transition: background-color 0.3s;
  }

  .btn1:hover {
    background-color: #45a049;
  }

  @media screen and (max-width: 500px) {
    .button-row {
      gap: 15px;
    }

    .btn1 {
      width: 100%;
      text-align: center;
      padding: 12px 0;
    }
  }
</style>