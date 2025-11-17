<%-- 身分選択ページ --%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>


<main>
<form class="container">
  <h1>あなたの立場は何ですか</h1>

<form class="container">
  <div class="button-row">
    <a href="caregiver/KaiLogin.action" class="btn1">介護士</a>
    <a href="resident/NyuLogin.action" class="btn1">入居者</a>
    <a href="relatives/親族ログイン.jsp" class="btn1">親族</a>
  </div>
</form>
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

.container {
    background: #fff;
    padding: 30px 50px;
    border-radius: 10px;
    box-shadow: 0 4px 15px rgba(0,0,0,0.1);
    text-align: center;
    width: 500px;
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
</style>