<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>

<main>
  <div class="logout-container">
    <h1>ログアウトしますか？</h1>
    <div class="logout-buttons">
      <a href="入居者/入居者ログアウト.jsp" class="btn yes">はい</a>
      <a href="入居者/入居者ホーム.jsp" class="btn no">いいえ</a>
    </div>
  </div>
</main>

<style>
  main {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 70vh;
    text-align: center;
    font-family: "Hiragino Sans", "Meiryo", sans-serif;
  }

  .logout-container {
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  .logout-container h1 {
    font-size: 2rem;
    margin-bottom: 30px;
    color: #333;
  }

  .logout-buttons {
    display: flex;
    gap: 20px;
  }

  .btn {
    padding: 14px 30px;
    font-size: 1.2rem;
    font-weight: bold;
    border: none;
    border-radius: 8px;
    text-decoration: none;
    color: #fff;
    background-color: #4CAF50;
    transition: background-color 0.3s, transform 0.2s;
  }

  .btn:hover {
    background-color: #45a049;
    transform: translateY(-2px);
  }

  @media screen and (max-width: 480px) {
    .logout-buttons {
      flex-direction: column;
      gap: 15px;
    }

    .btn {
      width: 80vw;
      text-align: center;
    }
  }
</style>